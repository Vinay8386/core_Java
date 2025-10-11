package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListToOptional {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList();
        Optional<List<String>> optionalList = Optional.of(myList);
        if (optionalList.isPresent()) {
            System.out.println("value is present");
        } else {
            System.out.println("value is not present");
        }
    }
}
