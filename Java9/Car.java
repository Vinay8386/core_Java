package Java9;

/**
 * ============================================================
 * Support for Private Interface Methods (Java 9)
 * ============================================================
 *
 * Background:
 * - Before Java 8, interfaces could only have abstract methods (no body).
 * - Java 8 introduced:
 *   1. Default methods (methods with body)
 *   2. Static methods
 *
 * Problem in Java 8:
 * - Default methods often had **duplicate code** across multiple default methods.
 * - No way to **reuse code internally** within the interface.
 *
 * Java 9 Enhancement:
 * - Java 9 allows **private methods in interfaces**.
 * - Private methods can be used **only inside the interface** to reduce code duplication.
 * - They **cannot be accessed** from implementing classes.
 *
 * ============================================================
 * Example:
 */
interface Vehicle {

    // Default method
    default void start() {
        log("Vehicle starting...");
    }

    // Another default method
    default void stop() {
        log("Vehicle stopping...");
    }

    // Private method: Java 9+
    private void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Car implements Vehicle {

    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // calls default method -> internally uses private log()
        car.stop();  // calls default method -> internally uses private log()

        // car.log("Test"); // ❌ Not allowed: log() is private in interface
    }
}

/**
 * ===================== Summary =====================
 *
 * 1. Before Java 9:
 *    - Interfaces could have default and static methods
 *    - No private methods; code duplication in default methods was common
 *
 * 2. Java 9:
 *    - Private methods allowed in interfaces
 *    - Can be:
 *       a) private instance methods (used by default methods)
 *       b) private static methods (used by static or default methods)
 *    - Cannot be accessed from implementing classes
 *
 * 3. Benefits:
 *    - Reduces code duplication in default methods
 *    - Keeps helper logic encapsulated inside the interface
 *
 * ============================================================
 * Example Notes:
 * - log() is private, so only default methods can call it
 * - Car class cannot call log() directly
 * - Cleaner, maintainable interface design
 */

