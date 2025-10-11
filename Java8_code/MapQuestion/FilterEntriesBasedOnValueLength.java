package Java8.MapQuestion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Given a HashMap<String, String>, write a Java 8 code snippet
// to filter entries where the value length is greater than 5 and collect them into a new Map.
public class FilterEntriesBasedOnValueLength {
    public static void main(String[] args) {
        Map<String, String> map=new HashMap<>();
        map.put("Fruit1", "Apple");
        map.put("Fruit2", "Banana");
        map.put("Fruit3", "Cherry");
        map.put("Fruit4", "Date");
        map.put("Fruit5", "Elderberry");
        System.out.println(valLengthGreaterThan5(map));
    }

    private static Map<String, String> valLengthGreaterThan5(Map<String, String> map){
        /*return map.entrySet()
                .stream()
                .filter(entry->entry.getValue().length()>5)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));*/

        //To preserve insertion order
        return map.entrySet()
                .stream()
                .filter(entry->entry.getValue().length()>5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue,newValue)->oldValue, // Merge function (for value conflicts)
                        LinkedHashMap::new));
    }
}
/*
By default, Collectors.toMap() would create a regular HashMap, which doesn't preserve insertion order.
Since you want to preserve the insertion order, you need a LinkedHashMap.
(oldValue, newValue) -> oldValue:
        This lambda function means "if there's a conflict, keep the old value and ignore the new one."
If a key collision occurs, this function tells Java how to handle it.

Here you may get output like {Fruit5=Elderberry, Fruit2=Banana, Fruit3=Cherry} ,insertion order is not preserved?
Reason: LinkedHashMap preserves the order of elements as they are encountered in the stream.
When you create a stream from a Map using map.entrySet().stream(),
the order of entries in the stream is determined by the internal structure of the original Map.
For a HashMap, this order is not guaranteed to be the insertion order; it may appear random or based on the hash codes of keys.

So, to avoid this, replace Map<String, String> map=new HashMap<>(); with Map<String, String> map=new LinkedHashMap<>();
 */