package Java17;

// Sealed Interface
sealed interface AreaShape
        permits AreaCircle, AreaRectangle, AreaSquare {

    double area();
}

// AreaCircle Class
final class AreaCircle implements AreaShape {

    private double radius;

    public AreaCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// AreaRectangle Class
final class AreaRectangle implements AreaShape {

    private double length;
    private double width;

    public AreaRectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// AreaSquare Class
final class AreaSquare implements AreaShape {

    private double side;

    public AreaSquare(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Main Class
public class ShapeAreaCalculator {

    public static void main(String[] args) {

        AreaShape s1 = new AreaCircle(5);
        AreaShape s2 = new AreaRectangle(10, 4);
        AreaShape s3 = new AreaSquare(6);

        System.out.println("Circle Area: " + s1.area());
        System.out.println("Rectangle Area: " + s2.area());
        System.out.println("Square Area: " + s3.area());
    }
}
