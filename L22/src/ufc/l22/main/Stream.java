package ufc.l22.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream {

    public static void main(String[] args) {

        Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(Task10_11::isPrime).forEach(System.out::println);

        Stream<Integer> stream = Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(Task10_11::isPrime);



        Integer[] arr = stream.toArray(Integer[]::new);
        Arrays.parallelSort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }
}
