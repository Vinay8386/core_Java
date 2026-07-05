package LLD_DesignPattern.Creational_Design_Pattern.Singelton_Design_Pattern;

public class TestEager {
    public static void main(String[] args) {

        LoggerEager loggerEager1 = LoggerEager.getInstance();
        LoggerEager loggerEager2 = LoggerEager.getInstance();

        LoggerLazy loggerLazy1 = LoggerLazy.getInstance();
        LoggerLazy loggerLazy2 = LoggerLazy.getInstance();

        System.out.println(loggerLazy1==loggerLazy2);
        loggerLazy1.log("Hi Vinay");

        //================================================================================================
        //Testing LoggerThreadSafe
        /*
            Passing the same Runnable does NOT make threads share the same instance.
            Each thread independently calls getInstance().
            Without thread safety, multiple threads can create multiple objects.
         */
        Runnable task = () -> {
            LoggerThreadSafe logger = LoggerThreadSafe.getInstance();
            System.out.println(logger);
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        //================================================================================================

        //================================================================================================
        //Testing Double locking
        /*
            Passing the same Runnable does NOT make threads share the same instance.
            Each thread independently calls getInstance().
            Without thread safety, multiple threads can create multiple objects.
         */
        Runnable taskDL = () -> {
            LoggerDoubleCheckedLocking logger2 = LoggerDoubleCheckedLocking.getInstance();
            System.out.println(logger2);
        };

        Thread dl1 = new Thread(taskDL);
        Thread dl2 = new Thread(taskDL);
        Thread dl3 = new Thread(taskDL);

        dl1.start();
        dl2.start();
        dl3.start();
        //================================================================================================

        LoggerBillPugh logger1 = LoggerBillPugh.getInstance();
        LoggerBillPugh logger2 = LoggerBillPugh.getInstance();

        logger1.log("Hello Vinay!");
        logger2.log("Singleton working!");

        System.out.println(logger1 == logger2); // true
    }
}
