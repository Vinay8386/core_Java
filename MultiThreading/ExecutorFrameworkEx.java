package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkEx {
    public static void main(String[] args) {
        //create an ExecutorService with fixed size thread pool
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        //submit the task for execution
        executorService.execute(()->{
                    System.out.println("First task executed by : "+Thread.currentThread().getName());
        });
        executorService.execute(()->{
            System.out.println("Second task executed by :"+Thread.currentThread().getName());
        });
        //shutdown the executor when done
        executorService.shutdown();
    }
}
