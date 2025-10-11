package MultiThreading;

public class DeadlockCondition {
    public static void main(String[] args) {
        DeadlockCondition d=new DeadlockCondition();
        d.t1.start();
        d.t2.start();
    }
    String s1="Vinay";
    String s2="Mishra";
    Thread t1= new Thread(() -> {
        while (true){
            synchronized (s1){ //Thread t1 locks s1
                try {
                    System.out.println(Thread.currentThread().getName()+" locked "+s1);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (s2){
                    System.out.println(Thread.currentThread().getName()+" locked "+s2);
                    System.out.println(s1+s2);
                }
            }
        }
    });
    Thread t2= new Thread(() -> {
        while (true){
            synchronized (s2){ //Thread t2 locks s2
                System.out.println(Thread.currentThread().getName()+" locked "+s2);
                synchronized (s1){
                    System.out.println(Thread.currentThread().getName()+" locked "+s1);
                    System.out.println(s1+s2);
                }
            }
        }
    });
}
