package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;

//Given the list of integers, find the first element of the list using Stream functions?
public class TwelvethQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,4,5,6);
        numList.stream().findFirst().ifPresent(System.out::println);
    }
}
