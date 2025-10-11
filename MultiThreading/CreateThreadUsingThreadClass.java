package MultiThreading;

// By extending Thread class
public class CreateThreadUsingThreadClass extends Thread{
    public static void main(String[] args) {
        CreateThreadUsingThreadClass t=new CreateThreadUsingThreadClass();
        t.start();
    }
    public void run(){
        System.out.println("Thread t is executing : ");
    }
}
