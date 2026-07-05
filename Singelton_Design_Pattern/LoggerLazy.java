package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class LoggerLazy {

    // Instance is NOT created at class loading
    private static LoggerLazy instance;

    //private constructor(no one can create object)
    private LoggerLazy(){
        System.out.println("Lazy Logger Created");
    }

    //object created only when this ,method will be called
    public static LoggerLazy getInstance(){
        if(instance==null){
            instance=new LoggerLazy(); //Lazy creation
        }
        return instance;
    }

    public void log(String message){
        System.out.println("Lazy initialization : " + message);
    }
}
