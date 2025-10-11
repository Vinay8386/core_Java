package MultiThreading;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class RunnableTask {
    public static void main(String[] args) {
        //Create a task in which tell the current thread to sleep or pause for 2 sec or 2 milliseconds
        Runnable runnableTask=()->{
            try {
                System.out.println("Current time before sleep: "+ LocalDateTime.now());
                TimeUnit.MILLISECONDS.sleep(2000);
                System.out.println("Current time after sleep: "+ LocalDateTime.now());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };
        //now execute this task using Executer framework
        //s-1)Create executor service instance
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        //s-2)task define: Already defined runnable task above

        //s-3)execute runnable task
        //s-3.1)execute task using execute method
        executorService.execute(runnableTask);
        //s-3.2)execute task using submit() method
        Future<String> result=executorService.submit(runnableTask,"task complete");

        //If the task is not complete
        while (result.isDone()==false){
            try {
                //retrieve the result by using get() method or throw exception if occurred
                System.out.println("The method return value : "+result.get());
            } catch (InterruptedException|ExecutionException ex) {
                ex.printStackTrace();
            }
            //after retrieving result or exception throw ask current thread to sleep for 1 second
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        //If a task completes, then shutdown the executor service
        executorService.shutdown();
    }
}
