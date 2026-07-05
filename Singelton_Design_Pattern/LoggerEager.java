package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class LoggerEager {

    //1. Instance created at class loading
    private static final LoggerEager INSTANCE = new LoggerEager();

    //2. Private constructor (restrict external creation)
    private LoggerEager(){
        System.out.println("Eager Logger Created");
    }

    //3. public accessor
    public static LoggerEager getInstance(){
        return INSTANCE;
    }

    public void log(String message){
        System.out.println("[EAGER]" +message);
    }
}
