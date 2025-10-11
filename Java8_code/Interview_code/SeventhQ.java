package Java8.InterviewQuestion;

import java.util.Arrays;

//Java program to find the longest String from a given array
public class SeventhQ {
    public static void main(String[] args) {
        String[] strArray={"Java","SpringBoot","Microservices","Golang"};
        String longest_String=Arrays.stream(strArray)
                .reduce((word1,word2)->word1.length()>word2.length()?word1:word2)
                .get();
        System.out.println(longest_String);

        String smallest_String=Arrays.stream(strArray)
                .reduce((word1,word2)->word1.length()<word2.length()?word1:word2)
                .get();
        System.out.println(smallest_String);
    }
}
/*
Reduce method is a terminal operation that takes two parameters
1. Identity value
2. An accumulator function
Identity value: It is the initial value (first value of stream) of reduction and default result if stream is empty
Accumulator function: It is the binary operator that combines the partial result and next element of the stream.
The accumulator function is (word1, word2) -> word1.length() > word2.length() ? word1 : word2.
This lambda function compares the lengths of two strings (word1 and word2) and returns the one with the greater length.
 */