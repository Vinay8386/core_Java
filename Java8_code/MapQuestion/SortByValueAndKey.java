package Java8.MapQuestion;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

//Given a HashMap<String, Integer>,
// writes a Java8 code snippet to convert all values in the map to a List<Integer> using streams.
public class SortByValueAndKey {
    public static void main(String[] args) {
        Map<String, Integer> map=new HashMap<>();
        map.put("Mango",55);
        map.put("Apple",15);
        map.put("Orange",10);
        map.put("Banana",25);
        map.put("Guava",5);
        System.out.println("=============sort by value=============");
        System.out.println(sortByValue(map));
        System.out.println("=============sort by key===============");
        System.out.println(sortByKey(map));
        System.out.println("=============sort by value and return a map in natural Order===============");
        System.out.println(sortByValInNatural(map));
        System.out.println("=============sort by value and return a map in reverse Order===============");
        System.out.println(sortByValInReverse(map));
    }

    private static List<Integer> sortByValue(Map<String, Integer> map) {
        //Natural order
        return map.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> sortByKey(Map<String, Integer> map) {
        //reverse order
        return map.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static Map<String, Integer> sortByValInNatural(Map<String, Integer> map) {
        //Natural order
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()) // Sort by value
                .collect(Collectors.toMap(
                        entry -> entry.getKey(), // Use a lambda expression to get the key
                        entry -> entry.getValue(), // Use a lambda expression to get the value
                        (oldValue, newValue) -> oldValue,  // Handle value conflicts
                        LinkedHashMap::new  // Maintain the order
                ));

    }

    private static Map<String, Integer> sortByValInReverse(Map<String, Integer> map) {
        //Reverse order
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) // Sort by value
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,  // Handle value conflicts
                        LinkedHashMap::new  // Maintain the order
                ));

    }
}
