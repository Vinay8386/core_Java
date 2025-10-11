package Basic_concept;

public class DeriveFromBaseClass extends Base {

    // This method overrides add() of Base class
    // because it not a static method
    @Override
    public int add(int a, int b) {
        System.out.println("child class override add method : ");
        return a + b;
    }

    // This method is hidden by print() in Base
    public static void print() {
        System.out.println("child class print method of same signature");
    }
}
