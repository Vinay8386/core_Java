package MultiThreading;

public class CreateThreadUsingRunnable implements Runnable{

    public static void main(String[] args) {
        CreateThreadUsingRunnable t1=new CreateThreadUsingRunnable();
        Thread t=new Thread(t1);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("Executing Thread by using Runnable interface");
    }
}
