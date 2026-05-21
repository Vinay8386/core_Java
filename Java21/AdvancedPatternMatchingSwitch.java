package Java21;

class AdvancedPatternMatchingSwitch {

    public static void main(String[] args) {

        checkValue("Hi");

        checkValue("Hello Java");

        checkValue(10);

        checkValue(-5);

        checkValue(null);

        checkValue(99.5);

        checkValue(true);
    }

    public static void checkValue(Object obj) {

        switch (obj) {

            // =========================================================
            // NULL CASE LABEL
            // =========================================================
            // Handles null values directly inside switch
            case null ->
                    System.out.println("Value is null");



            // =========================================================
            // WHEN CLAUSE + SCOPE OF PATTERN VARIABLE
            // =========================================================
            // Pattern Variable:
            //      String s
            //
            // Scope of s:
            //      s is accessible inside:
            //          -> when condition
            //          -> case body
            //
            // when clause:
            //      Adds extra condition checking
            //
            // This case executes only when:
            //      1. obj is String
            //      2. length > 0
            //      3. length <= 5
            //
            case String s when s.length() > 0 && s.length() <= 5 ->
                    System.out.println("Short String: " + s);



            // =========================================================
            // ANOTHER WHEN CLAUSE
            // =========================================================
            // Executes only when:
            //      1. obj is String
            //      2. length > 5
            //
            case String s when s.length() > 5 ->
                    System.out.println("Long String: " + s);



            // =========================================================
            // PATTERN LABEL DOMINANCE
            // =========================================================
            // IMPORTANT:
            //
            // This Integer pattern must come AFTER
            // guarded Integer patterns.
            //
            // If this case comes first:
            //
            //      case Integer i ->
            //
            // then below guarded Integer cases become unreachable
            // because every Integer already matches here first.
            //
            // That situation is called:
            //      Pattern Label Dominance
            //
            // Example of WRONG ordering:
            //
            //      case Integer i ->
            //      case Integer i when i > 0 -> ERROR
            //
            // because first case dominates second case.
            // =========================================================



            // Positive Integer
            case Integer i when i > 0 ->
                    System.out.println("Positive Integer: " + i);



            // Negative Integer
            case Integer i when i < 0 ->
                    System.out.println("Negative Integer: " + i);



            // Remaining Integer case
            case Integer i ->
                    System.out.println("Integer Value: " + i);



            // Double case
            case Double d ->
                    System.out.println("Double Value: " + d);



            // Boolean case
            case Boolean b ->
                    System.out.println("Boolean Value: " + b);



            // Default case
            default ->
                    System.out.println("Unknown Type");
        }
    }
}