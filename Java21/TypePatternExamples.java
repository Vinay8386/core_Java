package Java21;

import java.util.List;

class TypePatternExamples {

    public static void main(String[] args) {

        // =========================================================
        // TYPE PATTERNS WITH REFERENCE TYPES
        // =========================================================
        checkReferenceType("Hello Java");

        checkReferenceType(100);

        checkReferenceType(99.99);



        // =========================================================
        // TYPE PATTERNS WITH PRIMITIVE TYPES
        // (Preview Feature)
        // =========================================================
        checkPrimitiveType(10);

        checkPrimitiveType(99.5);

        checkPrimitiveType(true);



        // =========================================================
        // TYPE PATTERNS WITH PARAMETERIZED TYPES
        // =========================================================
        checkParameterizedType(List.of("Java", "Spring"));

        checkParameterizedType(List.of(10, 20, 30));
    }



    // =============================================================
    // 1. TYPE PATTERNS WITH REFERENCE TYPES
    // =============================================================
    //
    // Reference Types:
    //      String
    //      Integer
    //      Double
    //      Object
    //
    // Java checks object type and automatically creates variable.
    //
    // Example:
    //      case String s
    //
    //
    // Meaning:
    //      If obj is String,
    //      create variable s
    //
    // =============================================================
    public static void checkReferenceType(Object obj) {

        switch (obj) {

            case String s ->
                    System.out.println("String Value: " + s);

            case Integer i ->
                    System.out.println("Integer Value: " + i);

            case Double d ->
                    System.out.println("Double Value: " + d);

            default ->
                    System.out.println("Unknown Reference Type");
        }
    }



    // =============================================================
    // 2. TYPE PATTERNS WITH PRIMITIVE TYPES
    // =============================================================
    //
    // Primitive Type Patterns are Preview Features.
    //
    // Primitive Types:
    //      int
    //      double
    //      boolean
    //
    // Java directly matches primitive values using type patterns.
    //
    // =============================================================
    public static void checkPrimitiveType(Object obj) {

        switch (obj) {

            case Integer i when i > 0 ->
                    System.out.println("Positive int: " + i);

            case Double d when d > 0 ->
                    System.out.println("Positive double: " + d);

            case Boolean b ->
                    System.out.println("Boolean value: " + b);

            default ->
                    System.out.println("Unknown Primitive Wrapper");
        }
    }



    // =============================================================
    // 3. TYPE PATTERNS WITH PARAMETERIZED TYPES
    // =============================================================
    //
    // Parameterized Types:
    //      List<String>
    //      List<Integer>
    //
    // Java allows checking generic type structures.
    //
    // IMPORTANT:
    // Due to type erasure,
    // Java cannot fully distinguish generic type arguments
    // at runtime.
    //
    // So:
    //      List<String>
    //      List<Integer>
    //
    // both become List at runtime.
    //
    // =============================================================
    public static void checkParameterizedType(Object obj) {

        switch (obj) {

            case List<?> list when !list.isEmpty() ->

                    System.out.println(
                            "Parameterized Type List Found: " + list
                    );

            case List<?> list ->

                    System.out.println(
                            "Empty List Found"
                    );

            default ->
                    System.out.println("Not a List");
        }
    }
}