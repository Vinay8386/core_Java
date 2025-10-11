package Java8.InterviewQuestion;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//Java program to find a first repeated element from a given String.
public class FifthQ {
    public static void main(String[] args) {
        String str="iLoveJava";
        System.out.println("First repeated element without using LinkedHashMap");
        String first_repeated_element_without_LHM=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(input->input.getValue()>1)
                .findFirst().get().getKey();
        System.out.println(first_repeated_element_without_LHM);

        System.out.println("First repeated element using LinkedHashMap");
        String first_repeated_element=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(input->input.getValue()>1)
                .findFirst().get().getKey();
        System.out.println(first_repeated_element);

        System.out.println("First repeated element using set");
        Set<String> set=new LinkedHashSet<>();
        Set<String> first_time=new LinkedHashSet<>();
        Set<String> repeated=new LinkedHashSet<>();
        for (String s:str.split("")) {
            if(set.add(s)){
                first_time.add(s);
            }else {
                repeated.add(s);
            }
        }
        System.out.println(repeated.stream().findFirst().get());
    }
}
/*
In groupingBy method, we have used constructor reference of LinkedHashMap to create LinkedHashMap object. If you don't
use LinkedHashMap, then groupingBy method will consider this as HashMap object and insertion order not preserve in
HashMap. So, In place of the first repeated string maybe you will get second or different repeated String.
 */
