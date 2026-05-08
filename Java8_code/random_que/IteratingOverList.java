package Java8_code.random_que;

import java.util.Arrays;
import java.util.List;

public class IteratingOverList {
    public static void main(String[] args) {
        List<String> fruits= Arrays.asList("Apple", "grapes", "Orange", "mango");
        fruits.stream().forEach(System.out::println);
    }
}


