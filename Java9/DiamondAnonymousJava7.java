package Java9;

/**
 * ============================================================
 * Diamond Syntax with Anonymous Inner Classes (Java 7 and Java 9)
 * ============================================================
 *
 * In Java 7:
 * - The diamond operator (<>) was introduced to simplify generic
 *   instance creation without repeating the generic type.
 * - However, **diamond operator could not be used with anonymous inner classes**.
 *
 * Example in Java 7 (Without diamond for anonymous inner class):
 */
import java.util.ArrayList;
import java.util.List;

public class DiamondAnonymousJava7 {

    public static void main(String[] args) {

        // Java 7: Must explicitly specify generic type for anonymous inner class
        List<String> list = new ArrayList<String>() {  // diamond <> NOT allowed here
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