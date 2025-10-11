package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, sort all the values present in it using Stream functions?
public class SixteenthQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,4,5,6,1);
        //In ascending order
        List<Integer> asc_order=numList.stream().sorted().collect(Collectors.toList());
        System.out.println(asc_order);
        //In descending order
        List<Integer> des_order=numList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(des_order);
    }
}
