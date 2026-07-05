package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class LoggerThreadSafe {
    private static LoggerThreadSafe instance;

    private LoggerThreadSafe(){
        System.out.println("Thread-Safe Logger Created");
        System.out.println("Instance Created By: " + Thread.currentThread().getName());
    }

    // synchronized → only one thread can access this method at a time
    public static synchronized LoggerThreadSafe getInstance(){
        if(instance==null){
            instance=new LoggerThreadSafe();
        }
        return instance;
    }

    public void log(String message){
        System.out.println("thread safe logger : "+message);
    }
    /*
        DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern.LoggerThreadSafe@789bdba
        DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern.LoggerThreadSafe@789bdba
        DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern.LoggerThreadSafe@789bdba
        Same address → same object
        Created only once → correct behavior
     */
}
