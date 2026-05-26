package Singleton;

public class DynamicLazyImprovedSingleton {

    private static DynamicLazyImprovedSingleton instance;

    private DynamicLazyImprovedSingleton() {
    }

    public static synchronized DynamicLazyImprovedSingleton getInstance() {

        if (instance == null) {
            instance = new DynamicLazyImprovedSingleton();
        }

        return instance;
    }
}
