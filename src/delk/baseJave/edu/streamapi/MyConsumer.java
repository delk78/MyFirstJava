package delk.baseJave.edu.streamapi;

import java.util.Comparator;
import java.util.function.Consumer;

public class MyConsumer<T> implements Consumer<T> {
    T min;
    T max;
    public T getMin() {
        return min;
    }


    public T getMax() {
        return max;
    }

    Comparator<? super T> comparator;
    public MyConsumer(Comparator<? super T> theComparator ) {
        min = null;
        max = null;
        comparator = theComparator;
    }
    @Override
    public void accept(T o) {
        if (min == null) min = o;
        if (max == null) max = o;
        if (comparator.compare(o, min) < 0) min = o;
        if (comparator.compare(o, max) > 0) max = o;
    }
}
