package Singleton;

public class DoubleCheckedLockingSingleton {

    // volatile prevents instruction reordering issues
    private static volatile DoubleCheckedLockingSingleton instance;

    // Private constructor prevents external object creation
    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {

        // First check without synchronization
        if (instance == null) {

            synchronized (DoubleCheckedLockingSingleton.class) {

                // Second check inside synchronized block
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return instance;
    }
}
