package Java9;

import java.util.Arrays;

/**
 * ============================================================
 * 📘 PROGRAM: @SafeVarargs on Private Instance Methods
 * ============================================================
 *
 * Demonstrates the use of the @SafeVarargs annotation on private instance methods.
 *
 * Key Points:
 *  - Suppresses compiler warnings for varargs with generics.
 *  - Ensures type safety by indicating the method does not perform unsafe operations.
 *  - Java 7: allowed only on static and final methods.
 *  - Java 9+: allowed on private instance methods as well.
 *
 * Author: Vinay
 * Since: Java 7 / Java 9+
 */
public class SafeVarargsDemo {

    /**
     * Entry point to demonstrate @SafeVarargs usage.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SafeVarargsDemo demo = new SafeVarargsDemo();

        System.out.println("=== Printing messages using @SafeVarargs on private instance method ===");
        demo.printAll("Hello", "World", "Java");
    }

    /**
     * Private instance method demonstrating safe usage of varargs.
     *
     * @param messages varargs array of Strings to print
     * @SafeVarargs annotation suppresses unsafe operation warnings
     */
    @SafeVarargs
    private final void printAll(String... messages) {
        // Using stream to print each message
        Arrays.stream(messages).forEach(System.out::println);
    }
}

