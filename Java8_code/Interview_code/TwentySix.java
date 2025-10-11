package Java8.InterviewQuestion;

import java.util.*;

//How to check if a list is empty in Java 8 using Optional, if not null, iterate through the list and print the object?
public class TwentySix {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ABC","DEF");

        Optional.ofNullable(names)                  //Returns an Optional describing the given value, if non-null, otherwise returns an empty Optional.
                //.orElseGet(Collections::emptyList)  //Create an empty immutable list if our list is empty
                .stream().filter(Objects::nonNull)  //Loop through each object and consider only a non-null object
                .forEach(System.out::println);
    }
}
