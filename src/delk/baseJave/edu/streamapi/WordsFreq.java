package delk.baseJave.edu.streamapi;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.stream.Stream;
/**
 * Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 * и в конце выводящую 10 наиболее часто встречающихся слов.
 * Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например,
 * в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".
 *
 * Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите
 * слова в нижнем регистре.
 *
 * Если в тексте меньше 10 уникальных слов, то выводите сколько есть.
 *
 * Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 * то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
 *
 * Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.
 */
public class WordsFreq {


    public static void main(String[] args) {

            HashMap<String, Integer> result = new HashMap<>();

            (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                    .lines()
                    .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                    .map(w -> w.toLowerCase())
                    .forEach(w -> {
                        if(result.containsKey(w)) result.put(w, result.get(w) + 1);
                        else result.put(w, 1);
                    });

            result.entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                        else return e2.getValue().compareTo(e1.getValue());})
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey()));
        }
    }


