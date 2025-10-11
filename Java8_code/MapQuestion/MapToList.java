package Java8.MapQuestion;

import java.util.*;
import java.util.stream.Collectors;

//Given a HashMap<String, Integer>,
// write a Java 8 code snippet to convert all values in the map to a List<Integer> using streams.
public class MapToList {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("Mango",55);
        map.put("Apple",15);
        map.put("Orange",10);
        map.put("Banana",25);
        map.put("Guava",5);
        System.out.println("=============list of value=============");
        System.out.println(listOfValue(map));
        System.out.println("=============list of key===============");
        System.out.println(listOfKey(map));
    }

    private static List<Integer> listOfValue(Map<String, Integer> map) {
        return map.values()
                .stream()
                .collect(Collectors.toList());
    }

    private static List<String> listOfKey(Map<String, Integer> map) {
        return map.keySet()
                .stream()
                .collect(Collectors.toList());
    }
}
