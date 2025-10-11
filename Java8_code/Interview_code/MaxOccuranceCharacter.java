package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccuranceCharacter {
    public static void main(String[] args) {
        String str="abcacc";
        System.out.println(maxOccurString(str));
        System.out.println(maxOccurCharacter(str));
    }

    private static Map<Character, Long> maxOccurCharacter(String str) {
        // Split the string into characters, count their occurrences, and find the character with the highest frequency
        Map<Character, Long> maxFrequencyCharacter = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting())) // Group by character and count occurrences
                .entrySet().stream()
                .reduce((a, b) -> a.getValue() > b.getValue() ? a : b) // Find the entry with the maximum value
                .map(e -> Map.of(e.getKey(), e.getValue())) // Create a new map with the most frequent character
                .orElse(Collections.emptyMap()); // Handle the case where the string might be empty
        return maxFrequencyCharacter;
    }

    public static Map<String, Long> maxOccurString(String str){
        Map<String, Long> maxFrequencyString =
                Arrays.stream(str.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .reduce((a,b)->a.getValue()>b.getValue()?a:b)
                        .map(e-> Map.of(e.getKey(),e.getValue()))
                        .orElse(Collections.emptyMap());
        return maxFrequencyString;
    }
}
