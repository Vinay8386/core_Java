package Singleton;

public class StaticEagerSingleton {
    
    private static StaticEagerSingleton instance = new StaticEagerSingleton();

    private StaticEagerSingleton() {
        // Private constructor to prevent instantiation
    }

    public static StaticEagerSingleton getInstance() {
        return instance;
    }
}