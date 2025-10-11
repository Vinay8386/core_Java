package Basic_concept;

public class SuperKeyword {
    int maxSpeed = 120; //Field
    int maxSpeed2 = 130; //Field
    void makeSound() {  //Method
        System.out.println("Animal makes a sound.");
    }

    //constructor
    SuperKeyword(){
        System.out.println("this is param cons : ");
    }

    public class Test {
        public static void main(String[] args) {
            Car smallCar = new Car();
            smallCar.display();
        }
    }
}
class Car extends SuperKeyword {

    int maxSpeed = 180;
    @Override
    void makeSound() {
        super.makeSound(); // Calls the parent class's method
        System.out.println("Dog barks.");
    }
    // Constructor invocation using super
    Car() {
        super(); // Calls the constructor of the parent class (Vehicle)
        //Call to 'super()' must be a first statement in constructor body
    }
    // Method invocation using super
    void display() {
        System.out.println("Maximum Speed (Car): " + maxSpeed); // Accesses the subclass's maxSpeed
        System.out.println("Maximum Speed (Vehicle): " + super.maxSpeed); // Accesses the parent class's maxSpeed
        System.out.println("Maximum Speed (Vehicle): " + super.maxSpeed2);
    }
}
