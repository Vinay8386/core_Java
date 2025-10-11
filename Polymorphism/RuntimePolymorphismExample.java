package Polymorphism;

public class RuntimePolymorphismExample extends MethodOverriding {
    @Override
    public void method() {
        System.out.println("It's my way");
    }

    public static void main(String[] args) {
        MethodOverriding test = new RuntimePolymorphismExample();
        test.method();  // Calls the overridden method in RuntimePolymorphismExample
    }
}
