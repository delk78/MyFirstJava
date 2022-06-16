package delk.baseJave.edu.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MyStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int step = 0;
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n );
                            return n * n;
                        })
                      //  .limit(2)
                        .collect(toList());
        // twoEvenSquares.stream().forEach(System.out::println);
        IntStream intStream =  IntStream.rangeClosed(1, 30);
        intStream
                .filter(i-> i%2 == 0)
                .boxed()
                .map(i->i.toString()+ " ")
                .forEach(System.out::print);


    }
}
