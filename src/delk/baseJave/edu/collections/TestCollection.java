package delk.baseJave.edu.collections;
import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        Collection<?> collection = new ArrayList<>();
        Object object = new Object ();
        Iterator iterator = collection.iterator();
        // collection.add(object);
        boolean contains = collection.contains(object);
        collection.remove (object);
        // collection.addAll(Arrays.asList(object));
        int size = collection.size();
        collection.clear();
        Object [] objects = collection.toArray();
    }
}
