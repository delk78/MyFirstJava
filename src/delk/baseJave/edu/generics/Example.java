package delk.baseJave.edu.generics;
/**
 * https://javarush.ru/groups/posts/2004-teorija-dzhenerikov-v-java-ili-gde-na-praktike-stavitjh-skobki
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 */

import java.util.Optional;

public class Example <X> {
    public void someMethod(Object obj) {
        // X[] arrayX = new X[10]; //array of Xes...
        Optional<X> optX = Optional.empty();
        // boolean instance = (obj instanceof X);
        boolean instance = (obj instanceof Optional<?>); //this works
        //boolean instance = (obj instanceof Optional<X>); //but this wouldn't...
        // X justX = new X();
        X xxx = (X) obj;
    }
}