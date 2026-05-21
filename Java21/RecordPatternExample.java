package Java21;

// =============================================================
// RECORD CLASS
// =============================================================
//
// Record automatically creates:
//      -> constructor
//      -> getter methods
//      -> toString()
//      -> equals()
//      -> hashCode()
//
// Components:
//      x
//      y
//
// =============================================================
record Point(double x, double y) { }



public class RecordPatternExample {

    public static void main(String[] args) {

        typePattern();

        recordPattern();
    }



    // =============================================================
    // TYPE PATTERN
    // =============================================================
    //
    // Here we only check object type.
    //
    // We get:
    //      whole object
    //
    // Then we manually access:
    //      p.x()
    //      p.y()
    //
    // =============================================================
    public static void typePattern() {

        Object obj = new Point(10, 20);

        if (obj instanceof Point p) {

            System.out.println("Using Type Pattern");

            System.out.println("X Coordinate: " + p.x());

            System.out.println("Y Coordinate: " + p.y());
        }
    }



    // =============================================================
    // RECORD PATTERN
    // =============================================================
    //
    // Here Java:
    //      -> checks object type
    //      -> extracts components automatically
    //
    // Point(double x, double y)
    //
    // Meaning:
    //
    //      1. obj must be Point
    //      2. extract x
    //      3. extract y
    //
    // No need:
    //      p.x()
    //      p.y()
    //
    // =============================================================
    public static void recordPattern() {

        Object obj = new Point(50, 80);

        if (obj instanceof Point(double x, double y)) {

            System.out.println("\nUsing Record Pattern");

            System.out.println("X Coordinate: " + x);

            System.out.println("Y Coordinate: " + y);
        }
    }
} 