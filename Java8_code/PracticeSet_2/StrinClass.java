package Java8_code.PracticeSet_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StrinClass {
    public static void main(String[] args) {
        String str = "Java is Powerful and Java is Fast and Secure";

        /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */
       System.out.println(str.length());

       System.out.println("==========================================================");
       /*
        2. Count total number of words

            Expected Output: 9
        */
       System.out.println(Arrays.stream(str.split(" ")).collect(Collectors.counting()));

       System.out.println("==========================================================");
       /*
        3. Count frequency of each word
            Expected Output:
            Java -> 2
            is -> 2
            Powerful -> 1
            and -> 2
            Fast -> 1
            Secure -> 1
        */
        Map<String,Long> map=
        Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);

       System.out.println("==========================================================");
       /*
        4. Find the first repeated word

            Expected Output: Java
        */
        Map<String,Long> FirstRepeatedWord=
        Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        System.out.println(FirstRepeatedWord.entrySet()
                            .stream()
                            .filter(e->e.getValue()>1)
                            .findFirst()  //findFirst() returns an Optional<Entry> rather than the entry itself.
                            .map(Map.Entry::getKey) //.map(Map.Entry::getKey) extracts the key if the Optional is present, transforming the Optional<Entry> into an Optional<KeyType>.
                            .orElse(null) // unwraps the final result and safely returns null if no entry matched your filter.
                        );

       System.out.println("==========================================================");
       /*
        Find second largest word
            Expected Output: Secure
        */
       Map<String,Integer> SecondLargestWord=
        Arrays.stream(str.split(" "))
                .distinct()
                .collect(Collectors.toMap(
                    word->word,
                    word->word.length()
                    ));
        System.out.println(SecondLargestWord);
        System.out.println(SecondLargestWord.entrySet()
                            .stream()
                            .sorted(Comparator.comparing((Map.Entry<String,Integer> e)->e.getValue()).reversed())
                            .skip(1)
                            .findFirst()
                            .map(Map.Entry::getKey)
                            .orElse(null)
                        );

       System.out.println("==========================================================");
       /*
        5. Find all duplicate words

            Expected Output: [Java, is, and]
        */
       Map<String,Long> duplicateWord=
        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()
                    ));
        System.out.println(duplicateWord);
        System.out.println(duplicateWord.entrySet()
                            .stream()
                            .filter(e->e.getValue()>1)
                            .map(Map.Entry::getKey)
                            .toList()
                        );

       System.out.println("==========================================================");
       /*
        6. Find all unique words

            Expected Output:[Powerful, Fast, Secure]
        */
        Map<String,Long> uniqueWord=
        Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()
                    ));
        System.out.println(uniqueWord);
        System.out.println(uniqueWord.entrySet()
                            .stream()
                            .filter(e->e.getValue()==1)
                            .map(Map.Entry::getKey)
                            .toList()
                        );

       System.out.println("==========================================================");
       /*
        7. Print words in alphabetical order

            Expected Output: [Fast, Java, Java, Powerful, Secure, and, and, is, is]
        */
       

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */

       System.out.println("==========================================================");
       /*
        1. Count total number of characters (including spaces)

            Expected Output: 45
        */


    }
}
