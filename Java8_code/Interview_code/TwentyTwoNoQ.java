package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//How to use a map to convert an object into Uppercase in Java 8?
public class TwentyTwoNoQ {
    public static void main(String[] args) {
        String str="First Java8 interview question";
        System.out.println(str.toUpperCase());
        List<String> list=Arrays.stream(str.split(""))
                .map(e->e.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(list);
    }
}