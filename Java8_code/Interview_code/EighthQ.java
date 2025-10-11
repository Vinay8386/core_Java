package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Java program to find all elements from array who start with 1
public class EighthQ {
    public static void main(String[] args) {
        int[] num={12,23,34,45,15,19,91};
        List<Integer> list=Arrays.stream(num)
                .boxed()
                .map(x->x.toString())
                .filter(string->string.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
/*
primitive stream----->stream of wrapper/object : boxed()
Wrapper -------> String : object_name.toString()
String --------> Wrapper : Wrapper class name::valueOf (method reference)
 */
