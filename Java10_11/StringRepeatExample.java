package Java10_11;

/**
 * ============================================================
 * 📘 PROGRAM: String.repeat() Examples (Java 11+)
 * ============================================================
 *
 * Demonstrates the usage of the String.repeat(int count) method
 * introduced in Java 11.
 *
 * Key Features:
 *  - Repeat a string multiple times without loops.
 *  - Works with empty strings.
 *  - Throws IllegalArgumentException for negative count.
 *
 * Author: Vinay
 * Since: Java 11
 */
public class StringRepeatExample {

    /**
     * Entry point demonstrating all use cases of String.repeat().
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Basic Repetition ===");
        basicRepetition();

        System.out.println("\n=== Repetition with Empty String ===");
        emptyStringRepetition();

        System.out.println("\n=== Repetition with Zero Count ===");
        zeroCountRepetition();

        System.out.println("\n=== Repetition with Negative Count ===");
        negativeCountRepetition();
    }

    /**
     * Demonstrates repeating a non-empty string multiple times.
     */
    public static void basicRepetition() {
        String str = "Hi! ";
        String repeated = str.repeat(3); // Repeat 3 times
        System.out.println(repeated);    // Output: Hi! Hi! Hi!
    }

    /**
     * Demonstrates repeating an empty string any number of times.
     */
    public static void emptyStringRepetition() {
        String empty = "".repeat(5);
        System.out.println("Repeated empty string: '" + empty + "'");
        // Output: '' (empty string)
    }

    /**
     * Demonstrates repeating a string zero times.
     */
    public static void zeroCountRepetition() {
        String str = "Hello";
        String repeatedZero = str.repeat(0);
        System.out.println("Repeat 0 times: '" + repeatedZero + "'");
        // Output: '' (empty string)
    }

    /**
     * Demonstrates behavior when repeating a string with negative count.
     * Throws IllegalArgumentException.
     */
    public static void negativeCountRepetition() {
        try {
            String str = "Hello";
            str.repeat(-2); // ❌ Invalid
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
            // Output: Exception caught: count is negative
        }
    }
}

