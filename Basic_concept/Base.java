package Basic_concept;

public class Base {

    // Non-static method which will be overridden in derived class
    public int add(int a, int b) {
        System.out.println("Base class add instance method : ");
        return a + b;
    }
    // static method which will not be overridden
    //in the derived class
    public static void print() {
        System.out.println("Base class print static method");
    }
}
