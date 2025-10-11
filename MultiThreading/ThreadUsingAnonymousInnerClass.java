package MultiThreading;

public class ThreadUsingAnonymousInnerClass {
    public static void main(String[] args) {
        Thread t=new Thread(){
            public void run() {
                System.out.println("Executing Thread by using Anonymous inner class");
            }
        };
        t.start();
    }
}
