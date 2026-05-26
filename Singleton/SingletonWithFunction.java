package Singleton;

public class SingletonWithFunction {

    // Singleton instance
    private static final SingletonWithFunction instance =
            new SingletonWithFunction();

    // Private constructor prevents external object creation
    private SingletonWithFunction() {
    }

    // Global access point
    public static SingletonWithFunction getInstance() {
        return instance;
    }

    // Example function
    public void showMessage() {
        System.out.println("Singleton method called");
    }
}
