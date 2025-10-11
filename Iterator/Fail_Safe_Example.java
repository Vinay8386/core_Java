package Iterator;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fail_Safe_Example {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("Delhi");
        list.add("Moscow");
        list.add("New York");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // Modifying the collection while iterating
            list.add("Istanbul");
        }
    }
}
