package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Java program to count the occurrence of each character in a string
public class FirstQ {
    public static void main(String[] args) {
        String str="First Java8 interview question";

        //Print identity and their array like a=[a, a]
        Map<String, List<String>> map=Arrays.stream(str.split("")).collect(Collectors.groupingBy(ch->ch));
        System.out.println(map);

        //Count the occurrence of each character
        Map<String, Long> count=Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(count);
    }
}
        /*String[] strArray=str.split(""); //convert String---->String array
        char[] charArray=str.toCharArray(); //convert String---->char array
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(charArray));

        Return type is Map because if you use groupingBy method internally Stream will consider
        it as a HashMap.
        */