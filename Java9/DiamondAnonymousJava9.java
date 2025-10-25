package Java9;

/**
 * ============================================================
 * Java 9 Enhancement:
 * - In Java 9, the diamond operator can now be used with anonymous
 *   inner classes **if the type can be inferred**.
 *
 * Example in Java 9:
 */
import java.util.ArrayList;
import java.util.List;

public class DiamondAnonymousJava9 {

    public static void main(String[] args) {

        // Java 9: Diamond operator allowed with anonymous inner class
        List<String> list = new ArrayList<>() {  // diamond <> allowed in Java 9+
            @Override
            public boolean add(String s) {
                System.out.println("Adding: " + s);
                return super.add(s);
            }
        };

        list.add("Hello");
        list.add("World");

        System.out.println(list);
    }
}

/**
 * ===================== Summary =====================
 * 1. Java 7:
 *    - Diamond <> allowed for normal generic instance creation
 *    - Not allowed for anonymous inner classes
 *    - Must repeat generic type for anonymous inner classes
 *
 * 2. Java 9:
 *    - Diamond <> allowed for anonymous inner classes
 *    - Reduces redundancy and improves readability
 *
 * Key Note:
 * - The enhancement in Java 9 is purely syntactic sugar for generics.
 * - Compiler infers the type from the left-hand side (LHS) declaration.
 */

