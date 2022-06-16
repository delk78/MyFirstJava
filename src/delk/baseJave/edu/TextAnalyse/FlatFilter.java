package delk.baseJave.edu.TextAnalyse;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatFilter {
    public static void main(String[] args) {
        String[] arrayOfWords = {"Java Java", "Magazine", "WTF OFF off"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        streamOfWords.map(s->s.split(" ")).
                flatMap(Arrays::stream).
                map(String::toLowerCase).
                distinct().
                forEach(System.out::println);
    }
}
