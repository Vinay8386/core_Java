package Java8.InterviewQuestion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//Java program to find a first non-repeated element from a given String.
public class FourthQ {
    public static void main(String[] args) {
        String str="iLoveJava";

        System.out.println("First Non-repeated element without using LinkedHashMap");
        String firstUnique=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(input->input.getValue()==1)
                .findFirst().get().getKey();
        System.out.println(firstUnique);

        System.out.println("First Non-repeated element using LinkedHashMap");
        String first_non_repeated_element=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(input->input.getValue()==1)
                .findFirst().get().getKey();
        System.out.println(first_non_repeated_element);

        System.out.println("First Non-repeated element using LinkedHashMap and map");
        String first_non_repeated_element_using_map=Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(input->input.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst().get();
        System.out.println(first_non_repeated_element_using_map);

        System.out.println("Non-repeated element using set");
        Set<String> set=new LinkedHashSet<>();
        Set<String> non_repeated=new LinkedHashSet<>();
        for (String s:str.split("")) {
            if(set.add(s)){
                non_repeated.add(s);
            }else {
                non_repeated.remove(s);
            }
        }
        System.out.println(non_repeated.stream().findFirst().get());
    }
}
    /*While using groupingBy method always remember, Java will consider whole expression as HashMap and
        in HashMap insertion order is not preserved and It may be possible you will get wrong answer
        so for this you can create LinkedHashMap object in groupingBy method so that Java will consider
        it as LinkedHashMap not HashMap and you will get correct answer. In LinkedHashMap insertion order
        is preserved.*/