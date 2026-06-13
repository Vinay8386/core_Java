package Java8_code.random_que;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {
    public static void main(String[] args) {

        int[] num = {2,4,6,8};
        List<Integer> list = Arrays.asList(2,4,6,8);

        // Question 1
        System.out.println("Q1. Find the sum of all elements in an array using reduce()");
        System.out.println(sumOfArray(num));

        // Question 2
        System.out.println("\nQ2. Find the sum of all elements in a List using reduce()");
        System.out.println(sumOfList(list));

        // Question 3
        System.out.println("\nQ3. Find the sum using method reference");
        System.out.println(sumUsingMethodReference(list));

        // Question 4
        System.out.println("\nQ4. Find the maximum element using reduce()");
        System.out.println(findMax(list));

        // Question 5
        System.out.println("\nQ5. Find the minimum element using reduce()");
        System.out.println(findMin(list));

        // Question 6
        System.out.println("\nQ6. Find the product of all elements using reduce()");
        System.out.println(findProduct(list));
    }

    private static Integer sumOfArray(int[] num){
        return Arrays.stream(num)
                .reduce(0, Integer::sum);
    }

    private static Integer sumOfList(List<Integer> list){
        return list.stream()
                .reduce(0, Integer::sum);
    }

    private static Integer sumUsingMethodReference(List<Integer> list){
        return list.stream()
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static Integer findMax(List<Integer> list){
        return list.stream()
                .reduce(Integer::max)
                .orElseThrow(()-> new RuntimeException("null"));
    }

    private static Integer findMin(List<Integer> list){
        return list.stream()
                .reduce(Integer::min)
                .orElseThrow(()-> new RuntimeException("null"));
    }

    private static Integer findProduct(List<Integer> list){
        return list.stream()
                .reduce(1, (a,b) -> a*b);
    }
}

/*
=> Reduce Method

      -> Introduced in Java 8 Stream API

            -> Terminal Operation
            -> Used to combine multiple elements into a single result
            -> Performs aggregation on Stream elements

            Examples:
            Sum
            Product
            Maximum
            Minimum
            String Concatenation

      -> Syntax 1 : reduce(identity, accumulator)

            Example:
            list.stream().reduce(0, (a,b) -> a+b);

            Identity:
            0

                  -> Initial value
                  -> Starting point of reduction
                  -> Returned if Stream is empty

            Accumulator:
            (a,b) -> a+b

                  -> Logic used to combine elements

      -> Working Example

            List<Integer> list = Arrays.asList(2,4,6,8);

            list.stream().reduce(0,(a,b)->a+b);

            Step 1:
            0 + 2 = 2

            Step 2:
            2 + 4 = 6

            Step 3:
            6 + 6 = 12

            Step 4:
            12 + 8 = 20

            Result:
            20

      -> Syntax 2 : reduce(accumulator)

            Example:
            list.stream().reduce((a,b)->a+b);

            OR

            list.stream().reduce(Integer::sum);

            Return Type:
            Optional<T>

            Reason:

                  -> No identity value is provided
                  -> Stream may be empty
                  -> Optional prevents NullPointerException

      -> Difference Between Two Reduce Methods

            reduce(0,(a,b)->a+b)

                  -> Returns Integer
                  -> Identity value provided
                  -> Result always available

            reduce(Integer::sum)

                  -> Returns Optional<Integer>
                  -> No identity value provided
                  -> Result may be empty

      -> Finding Sum

            list.stream()
                .reduce(0, Integer::sum);

            Output:
            20

      -> Finding Product

            list.stream()
                .reduce(1, (a,b)->a*b);

            Output:
            384

            Why Identity = 1 ?

                  -> 1 is multiplicative identity

                  1 × 2 × 4 × 6 × 8

      -> Finding Maximum Element

            list.stream()
                .reduce(Integer::max);

            Output:
            8

      -> Finding Minimum Element

            list.stream()
                .reduce(Integer::min);

            Output:
            2

      -> String Concatenation

            List<String> list =
                    Arrays.asList("Java","8","Streams");

            String result =
                    list.stream()
                        .reduce("", (a,b)->a+b);

            Output:
            Java8Streams

      -> Common Interview Questions

            -> What is identity in reduce()?

                  -> Initial value used to start reduction
                  -> Returned if stream is empty

            -> What is accumulator in reduce()?

                  -> Logic that combines two elements

            -> Why reduce(Integer::sum) returns Optional?

                  -> Stream may be empty
                  -> No identity value provided

            -> Difference between map() and reduce()?

                  map()

                        -> Transforms each element
                        -> Output size remains same

                  reduce()

                        -> Aggregates all elements
                        -> Produces a single result

      -> Interview One-Liner

            -> reduce() is a terminal operation used to combine all stream elements into a single result using an identity value and an accumulator function.
*/