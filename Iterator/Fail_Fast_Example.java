package Iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Fail_Fast_Example {
    public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        Iterator<String> iterator = cityCode.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));
            // Modifying the collection while iterating
            cityCode.put("Istanbul", "Turkey");
        }
    }
}
