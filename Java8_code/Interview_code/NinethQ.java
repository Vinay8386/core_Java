package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
public class NinethQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,3,4,5,7,8,9,13,14);
        numList.stream()
                .filter(number->number%2==0)
                .forEach(System.out::println);
        //or
        List<Integer> even_no=numList.stream().filter(number->number%2==0).collect(Collectors.toList());
        System.out.println(even_no);
    }
}
