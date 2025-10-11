package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//How do you get three maximum numbers and three minimum numbers from the given list of integers?
public class ThirtyOne {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println("=======Max Three=======");
        List<Integer> maxThree=listOfIntegers.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(maxThree);

        System.out.println("=======Min Three=======");
        List<Integer> minThree=listOfIntegers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(minThree);
    }
}
