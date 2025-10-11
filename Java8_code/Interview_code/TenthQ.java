package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Given a list of integers, find out all the numbers starting with 1 using Stream functions?
public class TenthQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,13,4,5,16,7,1);
        numList.stream()
                .map(no->String.valueOf(no))
                .filter(no->no.startsWith("1"))
                .forEach(System.out::println);
        //or
        List<String> String_list=numList.stream()
                .map(String::valueOf)
                .filter(no->no.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(String_list);

        //Integer list which will start with 1 using valueOf method
        List<Integer> int_list=numList.stream()
                .map(String::valueOf)
                .filter(no->no.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(int_list);

        //Integer list which will start with 1 using toString method
        List<Integer> int_list1=numList.stream()
                .map(no->Integer.toString(no))
                .filter(no->no.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(int_list1);

        //Integer list which will start with 1 using format method
        List<Integer> int_list2=numList.stream()
                .map(no->String.format("%d", no))
                .filter(no->no.startsWith("1")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(int_list2);
    }
}
