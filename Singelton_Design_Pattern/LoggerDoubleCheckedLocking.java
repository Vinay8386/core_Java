package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class LoggerDoubleCheckedLocking {

    private static volatile LoggerDoubleCheckedLocking instance;

    private LoggerDoubleCheckedLocking(){
        System.out.println("Double checked Locking Created");
    }

    public static LoggerDoubleCheckedLocking getInstance(){
        if(instance==null){
            synchronized (LoggerDoubleCheckedLocking.class){
                if(instance==null){
                    instance =new LoggerDoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
