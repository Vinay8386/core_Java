package Java8.MapQuestion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Given a HashMap<String, String>, write a Java 8 code snippet
// to filter entries where the key length is greater than 5 and collect them into a new Map.
public class FilterEntriesBasedOnKeyLength {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<>();
        map.put("Apple", "Fruit");
        map.put("Banana", "Fruit");
        map.put("Cherry", "Fruit");
        map.put("Date", "Fruit");
        map.put("Elderberry", "Fruit");
        System.out.println(keyLengthGreaterThan5(map));
    }

    private static Map<String, String> keyLengthGreaterThan5(Map<String, String> map){
        /*return map.entrySet()
                .stream()
                .filter(entry->entry.getKey().length()>5)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));*/

        //To preserve insertion order
        return map.entrySet()
                .stream()
                .filter(entry->entry.getKey().length()>5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldKey,newKey)->oldKey, // Merge function (for key conflicts)
                        LinkedHashMap::new));
    }
}
/*
By default, Collectors.toMap() would create a regular HashMap, which doesn't preserve insertion order.
Since you want to preserve the insertion order, you need a LinkedHashMap.
(oldValue, newValue) -> oldValue:
        This lambda function means "if there's a conflict, keep the old value and ignore the new one."
If a key collision occurs, this function tells Java how to handle it.
 */