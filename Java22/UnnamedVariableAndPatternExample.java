package Java22;

import java.util.*;
import java.util.stream.Collectors;



// =============================================================
// RECORDS
// =============================================================
record Point(double x, double y) {}

enum Color {
    RED, GREEN, BLUE
}

record ColoredPoint(Point p, Color c) {}



// =============================================================
// SEALED INTERFACE + RECORDS
// =============================================================
sealed interface Employee permits Salaried, Freelancer, Intern {}

record Salaried(String name, long salary) implements Employee {}

record Freelancer(String name) implements Employee {}

record Intern(String name) implements Employee {}



public class UnnamedVariableAndPatternExample {

    public static void main(String[] args) {

        localUnnamedVariable();

        enhancedForLoopUnnamedVariable();

        catchUnnamedVariable();

        lambdaUnnamedVariable();

        unnamedPatternExample();

        switchUnnamedPattern();
    }



    // =============================================================
    // 1. LOCAL UNNAMED VARIABLE
    // =============================================================
    //
    // Variable exists but value is never used.
    //
    // "_" means:
    //      ignore this variable
    //
    // =============================================================
    public static void localUnnamedVariable() {

        System.out.println("\n===== Local Unnamed Variable =====");

        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.add("B");
        queue.add("C");

        // Value removed but ignored
        String _ = queue.remove();

        System.out.println("Remaining Queue: " + queue);
    }



    // =============================================================
    // 2. ENHANCED FOR LOOP UNNAMED VARIABLE
    // =============================================================
    //
    // We only want iteration count.
    // Actual character value is not needed.
    //
    // =============================================================
    public static void enhancedForLoopUnnamedVariable() {

        System.out.println("\n===== Enhanced For Loop =====");

        String word = "JAVA";

        int count = 0;

        for (char _ : word.toCharArray()) {

            count++;
        }

        System.out.println("Length: " + count);
    }



    // =============================================================
    // 3. CATCH BLOCK UNNAMED VARIABLE
    // =============================================================
    //
    // Exception object exists,
    // but we don't need to use it.
    //
    // =============================================================
    public static void catchUnnamedVariable() {

        System.out.println("\n===== Catch Unnamed Variable =====");

        try {

            Integer.parseInt("ABC");

        } catch (NumberFormatException _) {

            System.out.println("Invalid Number");
        }
    }



    // =============================================================
    // 4. LAMBDA PARAMETER UNNAMED VARIABLE
    // =============================================================
    //
    // Lambda parameter exists
    // but is never used.
    //
    // =============================================================
    public static void lambdaUnnamedVariable() {

        System.out.println("\n===== Lambda Unnamed Variable =====");

        List<String> list = Arrays.asList("A", "B", "C");

        Map<String, String> map = list.stream()

                .collect(Collectors.toMap(

                        value -> value,

                        _ -> "DEFAULT"
                ));

        System.out.println(map);
    }



    // =============================================================
    // 5. UNNAMED PATTERN
    // =============================================================
    //
    // Ignore unnecessary record components.
    //
    // ColoredPoint(Point p, Color c)
    //
    // We need only Point.
    // We ignore Color using "_"
    //
    // =============================================================
    public static void unnamedPatternExample() {

        System.out.println("\n===== Unnamed Pattern =====");

        Object obj = new ColoredPoint(

                new Point(10, 20),

                Color.RED
        );

        if (obj instanceof ColoredPoint(Point p, _)) {

            System.out.println("X Coordinate: " + p.x());

            System.out.println("Y Coordinate: " + p.y());
        }
    }



    // =============================================================
    // 6. SWITCH WITH UNNAMED PATTERN
    // =============================================================
    //
    // "_" ignores whole object variable.
    //
    // Multiple patterns allowed because
    // no pattern variables are declared.
    //
    // =============================================================
    public static void switchUnnamedPattern() {

        System.out.println("\n===== Switch Unnamed Pattern =====");

        Employee employee = new Freelancer("Vinay");

        switch (employee) {

            case Salaried s ->

                    System.out.println(
                            "Salary: " + s.salary()
                    );

            case Freelancer _, Intern _ ->

                    System.out.println("Other Employee");
        }
    }
}