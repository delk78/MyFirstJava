package delk.baseJave.edu.collections;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    /**
     * Реализуйте метод, вычисляющий симметрическую разность (см. вики) двух множеств.
     *
     * Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.
     * @return
     * @param <T>
     */
    public static <T> Set<T> symmetricDifference (Set <? extends T> set1, Set <? extends T> set2) {
        Set<T> result = new HashSet<>();
        for (T e : set1) {
            if (!set2.contains(e)) result.add(e);
        }
        for (T e : set2) {
            if (!set1.contains(e)) result.add(e);
        }
        return result;
    }
    public static <T> Set<T> symmetricDifference1 (Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();

        set1.forEach(x -> { if (!set2.contains(x)) result.add(x); });
        set2.forEach(x -> { if (!set1.contains(x)) result.add(x); });

        return result;
    }
}
