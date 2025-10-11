package MultiThreading;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableTask {
    public static void main(String[] args) {
        //Create a task in which tell the current thread to sleep or pause for 2 sec or 2 milliseconds
        Callable<String> callableTask=()->{
                TimeUnit.MILLISECONDS.sleep(2000);
                return "Current time: "+LocalDateTime.now();
        };
        //now execute this task using an Executer framework
        //s-1)Create executor service instance
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        //collect the list of task
        List<Callable<String>> taskList= Arrays.asList(callableTask,callableTask,callableTask);

        //execute the task using invokeAll method
        List<Future<String>> results= null;
        try {
            results = executorService.invokeAll(taskList);
            for(Future<String> result:results){
                System.out.println(result.get());
            }
        } catch (ExecutionException|InterruptedException e) {
            e.printStackTrace();
        }
        //execute an individual task using submit method
        Future<String> result = executorService.submit(callableTask);

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
