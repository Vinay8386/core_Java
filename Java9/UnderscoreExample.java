package Java9;

/**
 * ============================================================
 * Underscore Character Not Legal Name (Java 9)
 * ============================================================
 *
 * Background:
 * - In Java, an underscore '_' was historically allowed as an identifier (variable name, method name, etc.).
 * - Example in Java 8:
 *
 *   int _ = 5;   // legal in Java 8
 *   System.out.println(_);
 *
 * - However, this is not recommended because it can be confusing.
 *
 * Java 9 Change:
 * - Java 9 **disallows using a single underscore '_' as an identifier**.
 * - The compiler will give an error:
 *   "as of release 9, '_' is a keyword and may not be used as an identifier"
 *
 * Reason:
 * - The underscore is reserved for future use in the language, especially for things like lambda or type inference clarity.
 *
 * ============================================================
 * Examples:
 */

public class UnderscoreExample {

    public static void main(String[] args) {

        // Java 8: Allowed (It is commented because I am using Java21 and so it is giving compilation error if I will uncomment.
        //int _ = 10;
        //System.out.println("Java 8 allowed variable _: " + _);

        // Java 9+: Not allowed
        // int _ = 20;  // ❌ Compilation Error: '_' is not a valid identifier

        // Legal alternatives
        int score_ = 20;   // ✅ works fine
        int my_ = 30;      // ✅ works fine

        System.out.println("Legal alternative score_: " + score_);
        System.out.println("Legal alternative my_: " + my_);
    }
}

/**
 * ===================== Summary =====================
 *
 * 1. Java 8 and earlier:
 *    - Single underscore '_' as a variable name is allowed (not recommended)
 *
 * 2. Java 9 and later:
 *    - Single underscore '_' as a variable name is **illegal**
 *    - Must use a combination of letters, numbers, or underscore
 *
 * 3. Best practice:
 *    - Avoid using '_' as a variable name
 *    - Use descriptive names or underscores combined with letters (e.g., my_var)
 */

