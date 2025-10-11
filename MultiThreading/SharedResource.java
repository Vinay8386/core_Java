package MultiThreading;

public class SharedResource {
    private boolean isConditionMet = false;

    public synchronized void waitForCondition() throws InterruptedException {
        while (!isConditionMet) {
            wait(); // Thread A waits here
        }
        // Proceed with the work after the condition is met
    }

    public synchronized void changeCondition() {
        isConditionMet = true; // Change the condition
        notifyAll(); // Notify all waiting threads
    }
}


