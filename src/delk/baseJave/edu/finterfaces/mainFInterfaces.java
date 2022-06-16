package delk.baseJave.edu.finterfaces;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collection;
        import java.util.Objects;
        import java.util.function.*;
public class mainFInterfaces {
        public static <T, U> Function<T, U> ternaryOperator(
                Predicate<? super T> condition,
                Function<? super T, ? extends U> ifTrue,
                Function<? super T, ? extends U> ifFalse) {

                return (x-> condition.test(x)? ifTrue.apply(x) : ifFalse.apply(x) );
        }

        public static void main(String[] args) {
                Predicate<Object>  conditionNull = Objects::isNull;
                Function <String, Integer> ifTrue = o->0;
                Function <String, Integer> ifFalse = CharSequence::length;
                Function <String, Integer> safeLength = ternaryOperator(conditionNull, ifTrue, ifFalse);
                Function <String, Integer> safeLength1 = ternaryOperator(Objects::isNull,o->0, CharSequence::length);
                String s = null;
                System.out.println(safeLength1.apply(s));
                ArrayList<Integer> integerArrayList = null;// new ArrayList<>(Arrays.asList (1,2,3,4,5,6,7)) ;
                Function<ArrayList, Integer> safeLength2 = ternaryOperator(Objects::isNull, o -> 0, str -> str.size());
                System.out.println(safeLength2.apply(integerArrayList));
        }
}
