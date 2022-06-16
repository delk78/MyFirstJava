package delk.baseJave.edu.generics;

import java.util.Objects;
import java.util.Optional;

/**
 * Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов
 * и не запрещающий элементам принимать значение null.
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
 * а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
 * @param <First>
 * @param <Second>
 */
public class Pair <First, Second> {
    private First first;
    private Second second;
    private Pair (First theFirst, Second theSecond) {
        this.first = theFirst;
        this.second = theSecond;
    }

    public First getFirst() {
        return first;
    }

    public Second getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) return true;
        if (obj == null) return false;
        if (! (obj instanceof  Pair<?,?>) ) return false;
        Pair<?,?> other = (Pair<?,?>) obj;
        return Objects.equals(first, other.getFirst()) && Objects.equals(second, other.getSecond());
    }
    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
    public static <First, Second> Pair<First, Second> of(First first, Second second) {
        return new Pair<First, Second>(first, second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);

    }
}
