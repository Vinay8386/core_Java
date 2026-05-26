package Singleton;

public class BillPughSingleton {

    // Private constructor prevents external object creation
    private BillPughSingleton() {
    }

    // Public method to provide global access point
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Inner static helper class
    // Loaded only when getInstance() is called
    private static class SingletonHelper {

        // Singleton instance created when inner class is loaded
        private static final BillPughSingleton INSTANCE =
                new BillPughSingleton();
    }
}