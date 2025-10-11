package Java8.MapQuestion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a HashMap<String, Integer>,
// write a Java 8 code snippet to count the number of keys that start with the letter "A"
public class CountKeyStartWithSpecificLetter {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<>();
        map.put("Apple", "Fruit");
        map.put("Banana", "Fruit");
        map.put("Ananas", "Fruit");
        map.put("Date", "Fruit");
        map.put("Elderberry", "Fruit");
        System.out.println(countKey(map));
        System.out.println(printKey(map));
        System.out.println(printMap(map));
    }

    private static long countKey(Map<String, String> map) {
        return map.keySet()
                .stream()
                .filter(e->e.startsWith("A"))
                .count();
    }
    private static List<String> printKey(Map<String, String> map) {
        return map.keySet()
                .stream()
                .filter(e->e.startsWith("A"))
                .collect(Collectors.toList());
    }
    private static Map<String,String> printMap(Map<String, String> map) {
        return map.entrySet()
                .stream()
                .filter(e->e.getKey().startsWith("A"))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b)->a, LinkedHashMap::new
                ));
    }

}
