package delk.baseJave.edu.streamapi;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.*;

public class PseudoRandomStream {
static int mid (int input) {
    return input%10000/10; // keep only 2,3,4 decimal numbers.
}
    /** Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

    Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
    Первый элемент последовательности устанавливается равным этому числу.
    Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid (Rn*Rn) где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, \mathrm{mid}(123456) = 345mid(123456)=345
*/
     public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n->mid(n*n));
}

    /**
     * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
     *
     * Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
     *
     * minMaxConsumer.accept(min, max);
     * Если стрим не содержит элементов, то вызовите
     * minMaxConsumer.accept(null, null);
     * @param stream - исходный стрим
     * @param order - компаратор для сравнения.
     * @param minMaxConsumer - это выход, в него передадим значения.
     *
     */
    public static <T> void findMinMax(
            Stream<? extends T > stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        /* List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.size() > 0)
        minMaxConsumer.accept(list.get(0), list.get(list.size()-1));
        else minMaxConsumer.accept(null,null); */
        MyConsumer<T> myConsumer = new MyConsumer<>(order);
        stream.forEach(myConsumer);
        minMaxConsumer.accept(myConsumer.min, myConsumer.max);

        }


public static void main(String[] args) {
        pseudoRandomStream(13)
                .limit(20)
                .forEach(System.out::println);
    InputStream inputStream = System.in;
    }
}
