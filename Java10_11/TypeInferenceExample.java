package Java10_11;

/**
 * ============================================================
 * 📘 PROGRAM: Type Inference using 'var' in Java 10+
 * ============================================================
 *
 * Demonstrates how Java 10 introduced local variable type inference
 * using the 'var' keyword. It shows how the compiler infers the
 * variable type at compile time based on the assigned value.
 *
 * Key Points:
 *  - 'var' infers the type from the right-hand side (RHS) expression.
 *  - Type inference happens only at compile time, not at runtime.
 *  - 'var' is not a keyword; it’s a reserved type name.
 *  - Once inferred, the variable has a fixed, strong type.
 *
 * Example:
 *      var number = 10;      // inferred as int
 *      var name = "Vinay";   // inferred as String
 *
 * @author Vinay
 * @since Java 10
 */
public class TypeInferenceExample {

    /**
     * Entry point for demonstrating local variable type inference in Java.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // ------------------------------------------------------------
        // 🧩 EXPLICIT TYPING (Before Java 10)
        // ------------------------------------------------------------
        int number = 42; // Explicitly declared as int
        String message = "Hello, Explicit Typing!"; // Explicitly declared as String

        System.out.println("Explicit Typing:");
        System.out.println("number: " + number + " (Type: " + ((Object) number).getClass().getSimpleName() + ")");
        System.out.println("message: " + message + " (Type: " + message.getClass().getSimpleName() + ")");

        // ------------------------------------------------------------
        // 🚀 TYPE INFERENCE USING 'var' (Java 10 and Later)
        // ------------------------------------------------------------
        var inferredNumber = 42; // Compiler infers type as int
        var inferredMessage = "Hello, Type Inference!"; // Compiler infers type as String

        System.out.println("\nType Inference with var:");
        System.out.println("inferredNumber: " + inferredNumber + " (Type: " + ((Object) inferredNumber).getClass().getSimpleName() + ")");
        System.out.println("inferredMessage: " + inferredMessage + " (Type: " + inferredMessage.getClass().getSimpleName() + ")");

        // ------------------------------------------------------------
        // ❌ TYPE SAFETY DEMONSTRATION
        // ------------------------------------------------------------
        // Uncommenting the below line will cause a compile-time error: The compiler infers the type of inferredNumber to be int (Line no 47) because 42 is an integer literal.
        // inferredNumber = "This will cause a compile-time error"; // ❌ Invalid: cannot assign String to int
    }
}

