package Java9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ============================================================
 * 📘 PROGRAM: More Concise Try-With-Resources Statements
 * ============================================================
 *
 * Demonstrates the evolution of resource management in Java:
 *
 * 1. Traditional try-finally approach (pre-Java 7)
 * 2. Try-with-resources (Java 7+)
 * 3. Java 9 enhancement: using effectively final resources declared outside try
 *
 * Key Points:
 * - Ensures resources (like streams, readers, writers) are closed automatically.
 * - Reduces boilerplate code and prevents resource leaks.
 * - Java 9 allows resources declared outside the try block if they are effectively final.
 *
 * Author: Vinay
 * Since: Java 7 / Java 9
 */
public class TryWithResourcesExample {

    private static final Logger LOGGER = Logger.getLogger(TryWithResourcesExample.class.getName());

    public static void main(String[] args) {
        System.out.println("=== Traditional Try-Finally ===");
        traditionalTryFinally();

        System.out.println("\n=== Try-With-Resources (Java 7+) ===");
        tryWithResourcesJava7();

        System.out.println("\n=== Try-With-Resources (Java 9+) ===");
        tryWithResourcesJava9();
    }

    /**
     * Traditional approach using try-finally to close resources.
     * Pre-Java 7 style.
     */
    public static void traditionalTryFinally() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("sample.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file (traditional): " + e.getMessage(), e);
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Manually closing resource
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error closing resource (traditional): " + e.getMessage(), e);
            }
        }
    }

    /**
     * Try-with-resources introduced in Java 7.
     * Resources are declared in the try block and closed automatically.
     */
    public static void tryWithResourcesJava7() {
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file (Java 7+): " + e.getMessage(), e);
        }
    }

    /**
     * Java 9 enhancement: allows reusing resources declared outside the try block,
     * provided they are effectively final (not modified after initialization).
     */
    public static void tryWithResourcesJava9() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
            // Java 9+ allows using this effectively final resource in try-with-resources
            try (reader) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading file (Java 9+): " + e.getMessage(), e);
        }
    }
}

