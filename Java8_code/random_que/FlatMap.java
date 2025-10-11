package Java8;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<Integer>> nestedLists = Arrays.asList(Arrays.asList(2,5), Arrays.asList(7,9), Arrays.asList(8,11));
        // Using flatMap to flatten the nested lists into a single list of strings
        List<Integer> flattenedList = nestedLists.stream().flatMap(list -> list.stream()) // Stream<String>
                .collect(Collectors.toList());
        System.out.println(flattenedList);
        List<Integer> addedValue = nestedLists.stream().flatMap(list -> list.stream()) // Stream<String>
                .map(x->x+10) //perform operation on each value
                .collect(Collectors.toList());
        System.out.println(addedValue);
    }
}
