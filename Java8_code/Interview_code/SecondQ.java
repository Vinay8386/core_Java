package Java8.InterviewQuestion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Write a java program to find all duplicate element of a given String
public class SecondQ {
    public static void main(String[] args) {
        String str="abcadc";


        System.out.println("print duplicate value with count");
        List<Map.Entry<String,Long>> duplicateElementInKeyValuePair=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))//group by based on identity & count
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .collect(Collectors.toList());
        System.out.println(duplicateElementInKeyValuePair);

        System.out.println("print duplicate value without count");
        List<String> duplicateElement=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))//group by based on identity & count
                .entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateElement);

        System.out.println("print duplicate value without java8 using char array");
        char[] ch=str.toCharArray();
        Set<Character> e=new HashSet<>();
        Set<Character> duplicate=new HashSet<>();
        for (char c:ch) {
            if(!(e.add(c))){
                duplicate.add(c);
            }
        }
        System.out.println("duplicate element is: "+duplicate);


        System.out.println("print duplicate value without java8 using String array");
        String[] s=str.split("");
        Set<String> un=new HashSet<>();
        Set<String> du=new HashSet<>();
        for (String c:s) {
            if(!(un.add(c))){
                du.add(c);
            }
        }
        System.out.println("duplicate element is: "+du);
    }
}
