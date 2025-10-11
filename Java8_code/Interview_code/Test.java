package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String str="abcabdb";
        char[] arr=str.toCharArray();
        List<String> list=
        Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                                .stream()
                                        .filter(entry->entry.getValue()>1)
                .map(e->e.getKey()).collect(Collectors.toList());
        System.out.println(list);
    }
}
