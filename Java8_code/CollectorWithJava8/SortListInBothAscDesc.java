package Java8.CollectorWithJava8;

import java.util.*;
import java.util.stream.Collectors;

//Sort first 5 in descending order and next 5 in ascending order
class SortListInBothAscDesc {
    public static void main(String[] args){
        List<Integer> list=Arrays.asList(2,4,3,6,5,7,9,8,12,11);
        System.out.println(filetrList(list));
    }
    public static List<Integer> filetrList(List<Integer> list){
        //sort first 5 in descending order
        List<Integer> First5= list.stream()
                .limit(5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        //sort last 5 in descending order
        List<Integer> Last5= list.stream()
                .skip(5)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> result= First5;
        result.addAll(Last5);
        return result;
    }
}
