package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java 8 program to perform cube on list elements and filter numbers greater than 50.
public class TwentiethQ {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,3,4,6);
        List<Integer> val=list.stream()
                .map(no->no*no*no)
                .filter(no->no>50)
                .collect(Collectors.toList());
        System.out.println(val);
    }
}
