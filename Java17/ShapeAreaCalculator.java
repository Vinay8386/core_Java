package Java17;

// Sealed Interface
sealed interface Shape
        permits Circle, Rectangle, Square {

    double area();
}

// Circle Class
final class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Rectangle Class
final class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Square Class
final class Square implements Shape {

    private double side;

    public Square(double side) {
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

        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(10, 4);
        Shape s3 = new Square(6);

        System.out.println("Circle Area: " + s1.area());
        System.out.println("Rectangle Area: " + s2.area());
        System.out.println("Square Area: " + s3.area());
    }
}
