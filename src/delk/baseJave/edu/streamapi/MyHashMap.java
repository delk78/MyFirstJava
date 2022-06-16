package delk.baseJave.edu.streamapi;

import java.util.*;

import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.emptyList;

/**
 * My hashmap get method returns empty collection with method get if no key found
 *
 */
public class MyHashMap <K, V > extends HashMap <K, List<V>> { //этим мы говорим, что мы наследуемсся от объекта, который параметризуется K и List V это влияет, например, на то, что возвратит метод put и метод get класса предка

    @Override
    public List<V> get(Object key) { //важно, что возвращаем List<V> т.е. если передали параметр V, то get
        return super.getOrDefault(key, emptyList());
    }
}
