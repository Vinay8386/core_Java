package Java8;

public class RunnableImplementation {
    public static void main(String[] args) {
        //Implementation without Lambda expression
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable implement without Lambda expression");
            }
        });
        t.start();

        /*//Implementation with Lambda expression
        new Thread(() -> System.out.println("Runnable implement without Lambda expression")).start();*/
    }
}
