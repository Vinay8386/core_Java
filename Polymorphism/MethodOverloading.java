package Polymorphism;

//compile time polymorphism
//method name is same but arg will be different
//no of argument, type of argument, order of argument
public class MethodOverloading {
    public static int add(int a, int b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double add(double a) {
        return a ;
    }

    public static double add(int a, double b) {
        return a + b;
    }

    public static double add(double a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));      // Calls the int version
        System.out.println(add(2.0, 3.0));  // Calls the double version
    }
}
