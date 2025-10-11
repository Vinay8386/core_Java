package MultiThreading;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        // Thread A
        new Thread(() -> {
            try {
                resource.waitForCondition();
                System.out.println("Thread A resumes after condition is met.");
            } catch (InterruptedException e) {Thread.currentThread().interrupt();}
        }).start();
        // Thread B
        new Thread(() -> {
            resource.changeCondition();
            System.out.println("Thread B changed the condition and notified all.");
        }).start();
        // Simulate some delay
        try {
            Thread.sleep(100); // Wait for 100 milliseconds
        } catch (InterruptedException e) {Thread.currentThread().interrupt();}
        // Thread C
        new Thread(() -> {
            resource.changeCondition();
            System.out.println("Thread C changed the condition and notified all.");
        }).start();
    }
}
