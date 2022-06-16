package delk.baseJave.edu.streamapi;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MailService<T> implements Consumer<Sendable<T>> {
    List <Sendable<T>> messages;
    public MailService() {
        messages = new ArrayList<>();
    }
    @Override
    public void accept(Sendable<T> m) {
        messages.add(m);
    }
    /**
     * Return Map в котором ключом всегда является строчка = Получатель, а значением - список сообщений T, которые ему отправили
     */
    public HashMap<String, List<T>> getMailBox() {
        MyHashMap <String, T> result = new MyHashMap<>(); ///MyHashMap параметризуется типом Т а не List<T>!
        messages.forEach(m->addPerKey(result, m.getTo(), m.getContent()));
        return result;
    }

    /**
     *
     * @param hashMap - map which will contain unique string keys.
     * @param key - string as key. if key not exist, new List will be created as entry
     * @param value - to be added to list, linked with key.
     */
    private void addPerKey (MyHashMap<String, T> hashMap, String key, T value ){

        if (!hashMap.containsKey(key)) hashMap.put(key, new ArrayList<>());
        hashMap.get(key).add(value);

    }

}
