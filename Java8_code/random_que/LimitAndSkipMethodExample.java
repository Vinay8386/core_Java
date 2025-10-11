package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LimitAndSkipMethodExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Mango", "Papaya", "Date", "Orange");
        // Skip the first two elements
        Stream<String> skippedFruits = fruits.stream().limit(3);
        skippedFruits.forEach(System.out::println);
    }
}
