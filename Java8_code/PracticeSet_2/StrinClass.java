package Java8_code.PracticeSet_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
       List<String> list = Arrays.stream(str.split(" "))
                .sorted() //sorts words lexicographically(each character of word nt only first character)
                .toList();
        System.out.println(list);

       System.out.println("==========================================================");
       /*
        8. Print distinct words in alphabetical order
        Expected Output:[Fast, Java, Powerful, Secure, and, is]
        */
        List<String> distinctStr = Arrays.stream(str.split(" "))
                .sorted()
                .distinct()
                .toList();
        System.out.println(distinctStr);

       System.out.println("==========================================================");
       /*
        9. Convert every word to uppercase
        Expected Output: [JAVA, IS, POWERFUL, AND, JAVA, IS, FAST, AND, SECURE]
        */
        List<String> wordInUpperCase = Arrays.stream(str.split("\\s+")) //\\s → matches any whitespace (space, tab \t, newline \n, etc.) and + → matches one or more whitespace characters
                .map(s->s.toUpperCase())
                .toList();
        System.out.println(wordInUpperCase);

       System.out.println("==========================================================");
       /*
        10. Convert every word to lowercase
        Expected Output: [java, is, powerful, and, java, is, fast, and, secure]
        */
       List<String> wordInLowercase = Arrays.stream(str.split("\\s+"))
                .map(s->s.toLowerCase())
                .toList();
        System.out.println(wordInLowercase);

       System.out.println("==========================================================");
       /*
        11. Find the longest word       Expected Output:Powerful                                                                    //very important
        */
       System.out.println(Arrays.stream(str.split(" "))
                .collect(Collectors.toMap(Function.identity(),
                String::length,
                (oldValue,newValue)->oldValue))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing((Map.Entry<String,Integer> e)-> e.getValue()).reversed())
                .map(Map.Entry::getKey)
                .findFirst().orElse("null"));

        //simplest way
        System.out.println(Arrays.stream(str.split(" "))
            .distinct()
            .sorted(Comparator.comparing(String::length).reversed())
            .findFirst()
            .orElse("")
        );
        //second longest word
        System.out.println(Arrays.stream(str.split(" "))
            .distinct()
            .sorted(Comparator.comparing(String::length).reversed())
            .skip(1)
            .findFirst()
            .orElse("")
        );

       System.out.println("==========================================================");
       /*
        12. Find the shortest word  Expected Output: is
        */
       System.out.println(Arrays.stream(str.split(" "))
            .distinct()
            .sorted(Comparator.comparing(String::length))
            .findFirst()
            .orElse("")
        );
        //second shortest word
        System.out.println(Arrays.stream(str.split(" "))
            .distinct()
            .sorted(Comparator.comparing(String::length))
            .skip(1)
            .findFirst()
            .orElse("")
        );

       System.out.println("==========================================================");
       /*
        13. Count frequency of each character (ignore spaces)                                                   //Important

        Expected Output:
        J -> 2
        a -> 9
        v -> 2
        i -> 2
        s -> 4 
        ...
        (remaining characters) 
        */
        Map<String,Long> eachCharacterFrequencyExceptSpace =  
        Arrays.stream(str.split(""))
                .filter(charString->!charString.equals(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(eachCharacterFrequencyExceptSpace);

       System.out.println("==========================================================");
       /*
        14. Find duplicate characters

        Expected Output: [a, d, e, f, i, j, n, r, s, u, v]
        */
       List<Character> duplicateCharacter =
        Arrays.stream(str.split(""))
                .filter(charString->!charString.equals(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .map(s -> s.charAt(0))
                .toList();
        System.out.println(duplicateCharacter);

       System.out.println("==========================================================");
       /*
        15. Find unique characters
        Expected Output: [c, l, o, p, t, w]
        */
       List<Character> uniqueCharacter =
        Arrays.stream(str.split(""))
                .filter(charString->!charString.equals(" "))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .map(s -> s.charAt(0))
                .toList();
        System.out.println(uniqueCharacter);

       System.out.println("==========================================================");
       /*
        16. Reverse every word

        Expected Output:
        avaJ
        si
        lufrewoP
        dna
        avaJ
        si
        tsaF
        dna
        eruceS
        */
       Arrays.stream(str.split("\\s+"))
                .map(word -> new StringBuilder(word).reverse().toString())
                .forEach(System.out::println);

       System.out.println("==========================================================");
       /*
        17. Reverse the complete sentence
        Expected Output: eruceS dna tsaF si avaJ dna lufrewoP si avaJ
        */
       System.out.println(new StringBuilder(str).reverse().toString());


       System.out.println("==========================================================");
       /*
        18. Print words sorted by length

        Expected Output:
        is
        is
        and
        and
        Java
        Java
        Fast
        Secure
        Powerful
        */
       Arrays.stream(str.split("\\s+"))
              .sorted(Comparator.comparing(String::length))
              .forEach(System.out::println);


       System.out.println("==========================================================");
       /*
        19. Find the second longest word                                                      //Important
        Expected Output: Secure
        */
        String secondLongestWord =
        Arrays.stream(str.split("\\s+"))
              .sorted(Comparator.comparing(String::length).reversed())
              .distinct()
              .skip(1)
              .findFirst()
              .orElse("");
        System.out.println(secondLongestWord);

        //second distinct longest length
        int secondLongestLength =
        Arrays.stream(str.split("\\s+"))
              .map(String::length)
              .distinct()
              .sorted(Comparator.reverseOrder())
              .skip(1)
              .findFirst()
              .orElse(0);
        System.out.println(secondLongestLength);

        //second distinct longest length word
        int secondLongestLength2 =
        Arrays.stream(str.split("\\s+"))
              .map(String::length)
              .distinct()
              .sorted(Comparator.reverseOrder())
              .skip(1)
              .findFirst()
              .orElse(0);
        List<String> words =
        Arrays.stream(str.split("\\s+"))
              .filter(word -> word.length() == secondLongestLength2)
              .distinct()
              .toList();
        System.out.println(words);


       System.out.println("==========================================================");
       /*
        20. Find words starting with 'J'
        Expected Output: [Java, Java]
        */
       List<String> wordStartWithJ=
        Arrays.stream(str.split("\\s+"))
              .filter(word->word.charAt(0)=='J')
              .toList();
        System.out.println(wordStartWithJ);

       System.out.println("==========================================================");
       /*
        21. Find words ending with 'd'
        Expected Output: [and, and]
        */
        List<String> wordEndWithd=
        Arrays.stream(str.split("\\s+"))
              .filter(word->word.charAt(word.length()-1)=='d')
              .toList();
        System.out.println(wordEndWithd);

       System.out.println("==========================================================");
       /*
        22. Count vowels in the sentence                                                       //Important
            Expected Output: 15
        */
        Set<Character> vowels = Set.of('a','e','i','o','u');
        System.out.println(
            str.toLowerCase()
            .chars()                    // Converts the String into an IntStream where each character is represented by its Unicode (int) value
            .mapToObj(ch -> (char) ch)  // Converts each Unicode int value into a Character object (Stream<Character>)
            .filter(ch -> vowels.contains(ch))
            .count()
        );

       System.out.println("==========================================================");
       /*
        23. Count consonants in the sentence
        Expected Output: 20 
        */
        Set<Character> vowels1 = Set.of('a','e','i','o','u');
        System.out.println(str.toLowerCase()
            .chars()
            .mapToObj(no->(char)no)
            .filter(ch->!vowels1.contains(ch) && ch != ' ')
            .count());
        //another way 
        System.out.println(str.toLowerCase()
            .chars()
            .mapToObj(no->(char)no)
            .filter(ch->!vowels.contains(ch) && !Character.isWhitespace(ch))
            .count());
 
       System.out.println("==========================================================");
       /*
        24. Remove duplicate words while preserving order
        Expected Output: Java is Powerful and Fast Secure
        */
       List<String> removeDuplicate = 
        Arrays.stream(str.split("\\s+"))
              .distinct()
              .toList();
        System.out.println(String.join(" ",removeDuplicate));
        //or
        String result = 
        Arrays.stream(str.split("\\s+"))
              .distinct()
              .collect(Collectors.joining(" "));
        System.out.println(result);

       System.out.println("==========================================================");
       /*
        25. Join all words using "-"
        Expected Output: Java-is-Powerful-and-Java-is-Fast-and-Secure
        */
        String joinWithDelimeter = 
        Arrays.stream(str.split("\\s+"))
              .collect(Collectors.joining("-"));
        System.out.println(joinWithDelimeter);

       System.out.println("==========================================================");
       /*
        26. Check whether the sentence contains "Secure"                                           //Important
        Expected Output: true
        */
       boolean wordPresent = 
        Arrays.stream(str.split("\\s+"))
                .anyMatch(word -> word.equalsIgnoreCase("Secure"));
        System.out.println(wordPresent);
        /*
        .anyMatch(Predicate)  -> Returns true if at least one element matches the given condition.
        .allMatch(Predicate)  -> Returns true only if every element matches the given condition.
        .noneMatch(Predicate) -> Returns true only if no element matches the given condition.
        */

       System.out.println("==========================================================");
       /*
        27. Find index of the first occurrence of "Java"  Expected Output:0
        */
        

       System.out.println("==========================================================");
       /*
        28. Find index of the last occurrence of "Java"
        Expected Output: 22
        */

       System.out.println("==========================================================");
       /*
        29. Replace "Java" with "Spring"
        Expected Output: Spring is Powerful and Spring is Fast and Secure
        */

       System.out.println("==========================================================");
       /*
        30. Print words in reverse order
        Expected Output:
        Secure
        and
        Fast
        is
        Java
        and
        Powerful
        is
        Java
        */

    }
}
