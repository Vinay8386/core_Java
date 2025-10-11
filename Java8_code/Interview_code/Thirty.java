package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//How do you merge two unsorted arrays into single sorted array using Java 8 streams?
public class Thirty {
    public static void main(String[] args) {
        int[] a = new int[] {4, 2, 7, 1, 2};
        int[] b = new int[] {8, 3, 9, 5};

        //Merge and sort with duplicate
        List<Integer> listWithDuplicate=IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                .boxed()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(listWithDuplicate);

        //Merge and sort without a duplicate
        List<Integer> listWithoutDuplicate=IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                .boxed()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listWithoutDuplicate);
    }
}
