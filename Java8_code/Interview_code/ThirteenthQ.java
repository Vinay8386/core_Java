package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find the total number of elements present in the list using Stream functions?
public class ThirteenthQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,4,5,6);
        long countedValue= numList.stream().count();
        System.out.println(countedValue);
    }
}
