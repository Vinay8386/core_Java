package Java25;

//This class uses Java25 feature: Flexible Constructor Bodies
//Make sure to compile and run with Java 25 or later to see the benefits of this feature.
public class FlexibleConstructorBodies {

    private String name;
    private int age;

    // Constructor 1
    public FlexibleConstructorBodies() {

        // Flexible constructor body:
        // statements are allowed before this(...)
        System.out.println("Inside default constructor");
        System.out.println("Preparing default values");

        this("Unknown", 0);

        System.out.println("Default constructor completed");
    }

    // Constructor 2
    public FlexibleConstructorBodies(String name, int age) {

        this.name = name;
        this.age = age;

        System.out.println("Parameterized constructor called");
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public static void main(String[] args) {

        FlexibleConstructorBodies obj =
                new FlexibleConstructorBodies();

        System.out.println();

        obj.display();
    }
}