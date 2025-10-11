package MultiThreading;

public class Synchronization {
    public static void main(String[] args) {
        //create first thread
        Thread t1=new Thread(
                ()-> System.out.println("Thread one")
        );
        //create second thread
        Thread t2=new Thread(
                ()-> System.out.println("Second Thread")
        );

        t1.run();
        t2.run();
    }

    //create a method
    public void run(){
        synchronized (this){
            System.out.println("execute run method");
        }
    }
}
