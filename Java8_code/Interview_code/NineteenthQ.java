package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Write a Java 8 program to joint String and concatenate two Streams?
public class NineteenthQ {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "code");
        Stream<String> stream=Stream.concat(list1.stream(),list2.stream());
        System.out.println(stream.collect(Collectors.toList()));
    }
}
