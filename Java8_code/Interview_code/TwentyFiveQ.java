package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to find only duplicate elements with its count from the String ArrayList in Java8?
public class TwentyFiveQ {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Sham", "Baburao", "Ram");
        List<Map.Entry<String, Long>> pair=names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()>1)
                .collect(Collectors.toList());
        System.out.println(pair);
    }
}
