package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Write a Java 8 program to first sort an array and then convert the sorted array into Stream and print it?
public class TwentyOneNoQ {
    public static void main(String[] args) {
        int arr[] = { 99, 55, 203, 99, 4, 91 };
        Arrays.parallelSort(arr); //Sorts the specified array into ascending numerical order.
        Arrays.stream(arr).forEach(System.out::println);
    }
}
