package Java17;

// =====================================================
// Sealed class allows only specific permitted subclasses
// =====================================================
public sealed interface Shape permits Rectangle, Circle {

}


// =====================================================
// Rectangle record (implicitly final)
// Represents a shape with length & width
// =====================================================
record Rectangle(double length, double width) implements Shape {

    // Instance method to calculate area
    public double area() {
        return length * width;
    }
}


// =====================================================
// Circle record (implicitly final)
// Represents a shape using diameter
// =====================================================
record Circle(double diameter) implements Shape {

    // =====================================================
    // Compact constructor
    // Used for validation + normalization before object creation
    // =====================================================
    public Circle {

        // Step 1: Validation (recommended approach)
        if (diameter <= 0) {
            throw new IllegalArgumentException(
                    "Diameter should be greater than zero"
            );
        }

        // Step 2: Normalization (optional)
        // NOTE:
        // Since record fields are final, we are only modifying
        // constructor parameter value, not the actual field logic.
        diameter = Math.abs(diameter);
    }

    // =====================================================
    // Instance method to calculate radius
    // Derived value (NOT stored in record)
    // =====================================================
    public double radius() {
        return diameter / 2;
    }

    // =====================================================
    // Instance method to calculate area
    // Uses derived radius
    // =====================================================
    public double area() {
        double r = radius();
        return Math.PI * r * r;
    }
}