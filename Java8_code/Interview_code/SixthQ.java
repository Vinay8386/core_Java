package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.Comparator;

//Java program to find the second-lowest and second-highest number from given array
public class SixthQ {
    public static void main(String[] args) {
        int[] num={5,9,11,2,8,21,1};

        //find the second-lowest
        Integer second_lowest= Arrays.stream(num).boxed()
                .sorted()  //It will sort elements in default(ascending) order
                .skip(1)
                .findFirst()
                .get();
        System.out.println(second_lowest);

        //find the second-highest
        Integer secondHighestNumber=Arrays.stream(num).boxed()
                .sorted(Comparator.reverseOrder())   //It will sort elements in descending order
                .skip(1)    //skip first element
                .findFirst()
                        .get();
        System.out.println(secondHighestNumber);
    }
}
