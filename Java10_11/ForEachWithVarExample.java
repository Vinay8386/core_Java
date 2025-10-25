package Java10_11;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * CLASS: ForEachWithVarExample
 * ============================================================
 * Demonstrates the use of the Java 10 'var' keyword in nested loops
 * and list creation. The example compares traditional explicit typing
 * with type inference using 'var' for improved readability.
 *
 * Introduced Feature: Local Variable Type Inference (Java 10 - JEP 286)
 *
 * Key Concepts Demonstrated:
 *  - Using 'var' in nested for-each loops
 *  - Using 'var' for loop counters and collection initialization
 *  - Type inference in complex generic structures like List<List<Integer>>
 *
 * Author: Vinay
 * Since: Java 10
 */
public class ForEachWithVarExample {

    /**
     * Entry point for the demonstration.
     *
     * This method:
     *  1. Retrieves a nested list of integers using getLists()
     *  2. Prints the list using explicit typing
     *  3. Prints the list again using 'var' for type inference
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // The method returns a List<List<Integer>>
        var nestedList = getLists(); // inferred type: List<List<Integer>>

        // ------------------------------------------------------------
        // Nested for-each loop with explicit typing
        // ------------------------------------------------------------
        System.out.println("Using Explicit Typing:");
        for (List<Integer> outerList : nestedList) {
            for (Integer value : outerList) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // ------------------------------------------------------------
        // Nested for-each loop using 'var' for cleaner syntax
        // ------------------------------------------------------------
        System.out.println("\nUsing var:");
        for (var outerList : nestedList) { // inferred type: List<Integer>
            for (var value : outerList) {  // inferred type: Integer
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    /**
     * Creates and returns a nested list of integers (3x3 matrix style)
     * using 'var' for loop counters and inner list creation.
     *
     * Process:
     *  1. Outer loop creates 3 inner lists
     *  2. Each inner list contains products of i * j
     *  3. Uses 'var' for all local variable declarations
     *
     * @return a nested list of integers (List of List of Integers)
     */
    @NotNull
    private static List<List<Integer>> getLists() {

        // For complex generics, explicit typing is clearer
        var nestedList = new ArrayList<List<Integer>>(); // inferred type: ArrayList<List<Integer>>

        // Populate the nested list using var
        for (var i = 1; i <= 3; i++) { // inferred type: int
            var innerList = new ArrayList<Integer>(); // inferred type: ArrayList<Integer>
            for (var j = 1; j <= 3; j++) { // inferred type: int
                innerList.add(i * j);
            }
            nestedList.add(innerList);
        }

        return nestedList;
    }
}
