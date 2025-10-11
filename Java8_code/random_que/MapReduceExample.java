package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {
        int[] num={2,4,6,8};   //elements of a primitive array
        Integer sumResult=Arrays.stream(num).reduce(0,(x,y)->x+y);
        System.out.println(sumResult);

        List<Integer> list=Arrays.asList(2,4,6,8); //elements of a list
        Integer sum=list.stream().reduce(0,(a,b)->a+b);
        //reduce a sum with method reference
        Optional<Integer> reduce_sum_with_method_reference =list.stream().reduce(Integer::sum);
        System.out.println(reduce_sum_with_method_reference.get());
    }
}
