package Java10_11;

import java.util.Arrays;
import java.util.List;

/**
 * ============================================================
 * 📘 PROGRAM: Using 'var' in Lambda Expressions (Java 11+)
 * ============================================================
 *
 * Demonstrates the difference between traditional lambda expressions
 * and using 'var' for type inference in lambda parameters and local variables.
 *
 * Key Concepts:
 *  - Java 11 allows 'var' in lambda parameters for concise type inference.
 *  - 'var' can also be used for local variables inside the lambda block.
 *  - Splitting traditional vs var examples into separate methods improves readability.
 *
 * Author: Vinay
 * Since: Java 11
 */
public class LambdaVarExample {

    /**
     * Entry point demonstrating traditional vs 'var' lambda examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Traditional Lambda ===");
        traditionalLambdaExample();

        System.out.println("\n=== Lambda with 'var' ===");
        lambdaWithVarExample();
    }

    /**
     * Demonstrates traditional lambda expression with explicit type.
     */
    public static void traditionalLambdaExample() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie"); // Explicitly typed

        // Traditional lambda with explicit parameter type
        names.forEach((String name) -> {
            String message = name.toUpperCase();
            System.out.println(message);
        });
    }

    /**
     * Demonstrates lambda expression using 'var' in parameters and local variables.
     */
    public static void lambdaWithVarExample() {
        var names = Arrays.asList("Alice", "Bob", "Charlie"); // 'var' infers List<String>

        // Lambda using 'var' in parameter (Java 11+)
        names.forEach((var name) -> {
            var message = name.toUpperCase();  // 'var' infers String
            System.out.println(message);
        });
    }
}


