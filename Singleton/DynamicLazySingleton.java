package Singleton;

public class DynamicLazySingleton {
    private static DynamicLazySingleton instance;

    private DynamicLazySingleton() {
        // Private constructor to prevent instantiation
    }

    public static DynamicLazySingleton getInstance() {
        if (instance == null) {
            instance = new DynamicLazySingleton();
        }
        return instance;
    }
}
