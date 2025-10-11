package Java8.InterviewQuestion;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(fib(n));
        System.out.println(printAllFibNo(n));;
    }
    public static int fib(int n) {
        return Stream.iterate(new int[]{0,1}, x->new int[]{x[1],x[0]+x[1]})
                .limit(n+2)
                .map(x->x[0])
                .collect(Collectors.toList())
                .get(n);
    }

    public static int printAllFibNo(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return printAllFibNo(n - 1) + printAllFibNo(n - 2);
        }
    }

}
/*
Stream.iterate: It is used to create an infinite sequential stream where each element is generated based on the previous one.
new int[]{0, 1}: This is the initial seed or starting point for the stream.
                The stream begins with an array containing two integers: 0 and 1,
                which are the first two numbers in the Fibonacci sequence.
t -> new int[]{t[1], t[0] + t[1]}: This is the lambda expression that defines how to generate the
                                    next element in the stream based on the current element (t).
                                    It takes an array of two integers (t) and returns a new array
                                    containing the second element of the input array (t[1]) and the
                                    sum of the two elements (t[0] + t[1]). Essentially, it's updating
                                    the sequence by shifting one position to the left and adding the
                                    last two elements to get the next one.
 .limit(n + 2): This limits the infinite stream to the first n + 2 elements. The extra two elements are
       used to ensure that the stream has enough elements to calculate the nth Fibonacci number accurately.
 .map(num -> num[0]): This maps each array in the stream to its first element,
 which represents the Fibonacci numbers in the sequence.
 */