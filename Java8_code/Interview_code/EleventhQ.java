package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//How to find duplicate elements in a given integers list in java using Stream functions?
public class EleventhQ {
    public static void main(String[] args) {
        List<Integer> numList= Arrays.asList(2,4,5,6,2,4,8,9);
        numList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(no->no.getValue()>1)
                .map(x->x.getKey())
                .forEach(System.out::println);

        //Approach-2 print in the form of list
        List<Integer> val=numList.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(no->no.getValue()>1)
                .map(x->x.getKey())
                .collect(Collectors.toList());
        System.out.println(val);

        //Approach-3
        Set<Integer> set = new HashSet();
        numList.stream().filter(value-> !set.add(value)).forEach(System.out::println);

        //Approach-4
        Set<Integer> set2 = new HashSet();
        List<Integer> resultList=numList.stream().filter(value-> !set2.add(value))
                .collect(Collectors.toList());
        System.out.println(resultList);
    }
}
