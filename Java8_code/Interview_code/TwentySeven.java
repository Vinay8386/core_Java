package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//Given a list of integers, separate odd and even numbers?
public class TwentySeven {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,3,4,5,6,7,8,9);
        Map<Boolean,List<Integer>> evenAndOddSet=list.stream()
                .collect(Collectors.partitioningBy(x->x%2==0));
        System.out.println(evenAndOddSet);  //print even in true and odd in false

        Set<Map.Entry<Boolean,List<Integer>>> allEntry=evenAndOddSet.entrySet();
        for(Map.Entry<Boolean,List<Integer>> entry:allEntry){
            if(entry.getKey()){
                System.out.println("Even Number");
            }else {
                System.out.println("Odd Number");
            }
            for (int i:entry.getValue()) {
                System.out.println(i);
            }
        }
    }
}
