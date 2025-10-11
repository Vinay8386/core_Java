package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//Given an integer array arr, return true if any value appears at least twice in the array, and return false if every element is distinct.
public class SeventeenthQ {
    public static void main(String[] args) {
        int[] arr={2,4,6,2,8};
        //Approach-1
        System.out.println(valueAppears(arr));
        //Approach-2
        System.out.println(valueAppears2(arr));
        //Approach-3
        System.out.println(valueAppears3(arr));
    }

    private static boolean valueAppears(int[] arr) {
        long ans= Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(no->no.getValue()>1)
                .map(x->x.getValue())
                .findFirst().get();
        if (ans>=1){
            return true;
        }else {
            return false;
        }
    }
    private static boolean valueAppears2(int[] arr) {
        Set<Integer> set=new HashSet<>();
        long value=Arrays.stream(arr).boxed().map(no->!set.add(no)).count();
        if(value>=1){
            return true;
        }else {
            return false;
        }
    }
    private static boolean valueAppears3(int[] arr) {
        List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set=new HashSet<>(list);
        if (list.size()==set.size()){
            return false;
        } else return true;
    }
}
