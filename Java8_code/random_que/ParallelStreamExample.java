package Java8;

import java.util.stream.IntStream;

//Iterate 50 records in both normal/sequential stream & Parallel Stream
public class ParallelStreamExample {
    public static void main(String[] args) {

        long start=0; long end=0;
        start=System.currentTimeMillis();
        IntStream.range(1,50).forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("sequential execution took time :"+(end-start));

        System.out.println("===================================");

        start=System.currentTimeMillis();
        IntStream.range(1,50).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();
        System.out.println("Parallel execution took time :"+(end-start));
    }
}
