package MultiThreading;

public class ThreadUsingLambda{
    public static void main(String[] args) {
        new Thread(
                ()->System.out.println("Executing Thread by using Lambda expression")
        ).start();
    }
}
/*
When using Lambda expression to create a thread in Java, you essentially provide the implementation of Runnable interface run
method directly as a parameter of Thread constructor. run method is abstract method of Runnable interface.
 */