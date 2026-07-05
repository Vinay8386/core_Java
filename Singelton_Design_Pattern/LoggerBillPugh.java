package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class LoggerBillPugh {

    // 1. Private constructor to prevent external object creation
    private LoggerBillPugh() {
        System.out.println("LoggerBillPugh Instance Created");
    }

    // 2. Static Inner Helper Class (loaded only when getInstance() is called)
    private static class Holder {
        private static final LoggerBillPugh INSTANCE = new LoggerBillPugh();
    }

    // 3. Global access point — returns the same instance every time
    public static LoggerBillPugh getInstance() {
        return Holder.INSTANCE;
    }

    // 4. Business logic method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

