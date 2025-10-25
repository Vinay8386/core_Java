package Java10_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ============================================================
 * 📘 PROGRAM: Try-With-Resources using 'var' (Java 10+)
 * ============================================================
 *
 * Demonstrates how to use the Java 7+ Try-With-Resources feature
 * with Java 10's local variable type inference (`var`) for cleaner syntax.
 *
 * Key Concepts:
 *  - Try-With-Resources automatically closes resources (like files, streams)
 *    after use, eliminating the need for explicit finally blocks.
 *  - Both the traditional explicit type and the 'var' inferred type
 *    versions close the resource automatically at the end of the try block.
 *  - Java 10 allows using 'var' inside the try-with-resources declaration,
 *    making the code more concise while still strongly typed.
 *
 * Example:
 *      try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
 *          // Use reader
 *      } // reader is automatically closed here
 *
 *      try (var reader = new BufferedReader(new FileReader("sample.txt"))) {
 *          // Use reader
 *      } // reader is also automatically closed here
 *
 * Note:
 *  - 'var' infers the type of the resource at compile time.
 *  - The resource must implement AutoCloseable.
 *
 * Author: Vinay
 * Since: Java 10
 */
public class TryWithResourcesExample {

    //Logger instance for this class
    private static final Logger logger = Logger.getLogger(TryWithResourcesExample.class.getName());

    /**
     * Entry point for demonstrating Try-With-Resources using 'var'.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // Traditional Try-With-Resources (explicit type)
        // ------------------------------------------------------------
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Use Logger to log exception with level SEVERE
            logger.log(Level.SEVERE, "Error reading file (traditional): "+e.getMessage(),e);
        }

        // ------------------------------------------------------------
        // Modern Try-With-Resources using 'var' (Java 10+)
        // ------------------------------------------------------------
        try (var reader = new BufferedReader(new FileReader("sample.txt"))) {
            // 'var reader' is inferred as BufferedReader
            // Resource will be automatically closed when try block ends

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // print each line of the file
            }

        } catch (IOException e) {
            // Handle any I/O exceptions (e.g., file not found)
            logger.log(Level.SEVERE, "Error reading file (traditional): "+e.getMessage(),e);
        }
    }
}
