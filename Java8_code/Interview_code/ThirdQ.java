package Java8.InterviewQuestion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Java program to find elements, which is not duplicate in a given String
public class ThirdQ {
    public static void main(String[] args) {
        String str="abcadc";

        System.out.println("print non_duplicate elements with count");
        List<Map.Entry<String,Long>> duplicateElementInKeyValuePair=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))//group by based on identity & count
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .collect(Collectors.toList());
        System.out.println(duplicateElementInKeyValuePair);

        System.out.println("print non_duplicate elements without count");
        List<String> duplicateElement=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))//group by based on identity & count
                .entrySet().stream()
                .filter(entry->entry.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElement);

        System.out.println("print non_duplicate elements without java8 using char array");
        Set<Character> uniqueChars = new HashSet<>();
        Set<Character> nonDuplicateChars = new HashSet<>();

        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            if (!uniqueChars.add(ch)) {
                // If the character is already present, it's a duplicate
                nonDuplicateChars.remove(ch);
            } else {
                // If the character is not a duplicate, add it to the non-duplicate set
                nonDuplicateChars.add(ch);
            }
        }
        System.out.println("nonDuplicateChars element is: "+nonDuplicateChars);


        System.out.println("print non_duplicate elements without java8 using String array");
        String[] s=str.split("");
        Set<String> un=new HashSet<>();
        Set<String> non_duplicate=new HashSet<>();
        for (String c:s) {
            if(un.add(c)){  //The expression !un.add(c) is used to check whether adding an element c to the set un was successful or not.
                non_duplicate.add(c);
            }else {
                non_duplicate.remove(c);
            }
        }
        System.out.println("non_duplicate element is: "+non_duplicate);
    }
}