package Java21.Sequenced_Collection;

import java.util.*;
import java.util.stream.Collectors;

public class BankingSystem {
    public static void main(String[] args){
        List<String> list = new ArrayList<>(List.of("TXN103","TXN101","TXN105","TXN102","TXN104"));

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.addFirst("TXN100");

        list.addLast("TXN106");

        System.out.println(list);

        list.removeFirst();

        list.removeLast();

        System.out.println(list.reversed());

        System.out.println(list);

        
        System.out.println("=================! second question  !=======================");

        SequencedSet<String> set = new LinkedHashSet<>(List.of("TXN103","TXN101","TXN105","TXN103","TXN102","TXN101","TXN104"));

        System.out.println(set);

        System.out.println(set.getFirst());

        System.out.println(set.getLast());

        set.addFirst("TXN105");

        set.addLast("TXN103");

        System.out.println(set.reversed());

        set.removeFirst();

        System.out.println(set);

        System.out.println("=================! Third question  !=======================");

        SequencedSet<Integer> sortedSet = new TreeSet<>(List.of(30,10,40,10,25,20));

        System.out.println(sortedSet);

        System.out.println(sortedSet.getFirst());

        System.out.println(sortedSet.getLast());

        System.out.println(sortedSet.reversed());

        System.out.println(sortedSet.removeFirst());

        System.out.println(sortedSet.removeLast());

        //sortedSet.addFirst(5); //throw java.lang.UnsupportedOperationException and ordering was maintained internally

        System.out.println("=================! Fourth question  !=======================");

        SequencedMap<String, String> map = new LinkedHashMap<>();

        map.put("TXN103","Success");
        map.put("TXN101","Failed");
        map.put("TXN105","Pending");
        map.put("TXN102","Success");
        map.put("TXN104","Failed");
        
        System.out.println(map);

        System.out.println(map.firstEntry());

        System.out.println(map.lastEntry());

        map.putFirst("TXN100", "URGENT");

        map.putLast("TXN106", "PENDING");

        System.out.println(map);

        System.out.println(map.pollFirstEntry());

        System.out.println(map.pollLastEntry());

        System.out.println(map.reversed());

        System.out.println("=================! Fifth question  !=======================");

        map.putFirst("TXN102", "RETRY_SUCCESS");  //value will be updated and place value will be change to avoid duplicacy

        map.putLast("TXN101", "RETRY_PENDING"); //value will be updated and place value will be change to avoid duplicacy

        System.out.println(map);

        System.out.println(map.firstEntry());

        System.out.println(map.lastEntry());

        System.out.println(map.reversed());

        System.out.println("=================! Sixth question  !=======================");

        SequencedMap<Integer, String> sortedMap = new TreeMap<>();

        sortedMap.put(305, "TXN305");
        sortedMap.put(101, "TXN101");
        sortedMap.put(250, "TXN250");
        sortedMap.put(150, "TXN150");

        System.out.println(sortedMap);

        System.out.println(sortedMap.firstEntry());

        System.out.println(sortedMap.lastEntry());

        System.out.println(sortedMap.reversed());

        sortedMap.pollFirstEntry();

        //sortedMap.putFirst(50, "TXN050"); //UnsupportedOperationException - TreeMap maintains order according to sorted keys

        System.out.println("=================! Seventh question  !=======================");

        SequencedMap<String, String> q7Map = new LinkedHashMap<>();

        q7Map.put("TXN101", "SUCCESS");
        q7Map.put("TXN102", "FAILED");
        q7Map.put("TXN103", "SUCCESS");
        q7Map.put("TXN104", "CLOSED");
        q7Map.put("TXN105", "SUCCESS");

        SequencedSet<String> keys = q7Map.sequencedKeySet();

        SequencedCollection<String> values = q7Map.sequencedValues();

        SequencedSet<Map.Entry<String, String>> entries = q7Map.sequencedEntrySet();

        System.out.println(keys.getFirst());
        System.out.println(keys.getLast());
        System.out.println(keys.reversed());

        System.out.println(values.getFirst());
        System.out.println(values.getLast());
        System.out.println(values.reversed());

        System.out.println(entries.getFirst());
        System.out.println(entries.getLast());
        System.out.println(entries.reversed());

        //In map key should always be unique but value can be duplicate 
        //key view is like a set because both map and set has same rules key will be unique in map and elements in set should be unique 
        //entry in map and elements in set both should be unique 
        //value in map allows duplicates so not views like a set 

        System.out.println("=================! Eighth question  !=======================");

        SequencedMap<String, String> q8Map = new LinkedHashMap<>();

        q8Map.put("T101","SUCCESS");
        q8Map.put("T102","FAILED");
        q8Map.put("T103","SUCCESS");
        q8Map.put("T104","PENDING");

        SequencedSet<String> keySet = q8Map.sequencedKeySet();

        SequencedCollection<String> vs = q8Map.sequencedValues();

        SequencedSet<Map.Entry<String, String>> allEntries = q8Map.sequencedEntrySet();

        System.out.println(keySet.getFirst());

        System.out.println(keySet.getLast());

        System.out.println(allEntries.getFirst());

        System.out.println(allEntries.getLast());

        q8Map.putFirst("T103", "SUCCESS");

        System.out.println(q8Map);

        q8Map.putLast("T105", "PENDING");

        System.out.println(q8Map);

        q8Map.pollFirstEntry();

        System.out.println(q8Map);

        System.out.println(keySet.reversed());

        System.out.println(allEntries.reversed());

        System.out.println(keySet.getFirst());
        System.out.println(keySet.getLast());
        System.out.println(keySet.reversed());

        System.out.println(vs.getFirst());
        System.out.println(vs.getLast());
        System.out.println(vs.reversed());

        System.out.println(allEntries.getFirst());
        System.out.println(allEntries.getLast());
        System.out.println(allEntries.reversed());

        SequencedCollection<Integer> sortedCollections = new TreeSet<>(List.of(30,10,40,20,30));

        System.out.println(sortedCollections.getFirst()); //smallest priority

        System.out.println(sortedCollections.getLast()); //largest priority

        System.out.println(sortedCollections.reversed());

        sortedCollections.removeFirst(); //remove 10

        sortedCollections.removeLast(); //remove 40

        System.out.println(sortedCollections);

    }
}
