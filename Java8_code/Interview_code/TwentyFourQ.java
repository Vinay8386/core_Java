package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to count each element/word from the String ArrayList in Java8?
public class TwentyFourQ {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Sham", "Baburao", "Jaare");
        Map<String,Long> pair=names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(pair);
    }
}
