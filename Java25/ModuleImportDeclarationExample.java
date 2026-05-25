package Java25;

// Import all exported packages from java.base module
import module java.base;

// Import all exported packages from java.sql module
import module java.sql;


public class ModuleImportDeclarationExample {

    public static void main(String[] args) {

        // Classes from java.util package
        List<String> fruits = List.of("Apple", "Banana", "Mango");

        // Stream API from java.util.stream
        Map<String, Integer> fruitLengthMap =
                fruits.stream()
                      .collect(Collectors.toMap(
                              Function.identity(),
                              String::length
                      ));

        System.out.println("Fruit Length Map:");
        System.out.println(fruitLengthMap);

        // Class from java.sql package
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis()); // Using fully qualified name to avoid ambiguity with java.util.Date
        // Date is available from both java.util and java.sql, so we need to specify which one we want to use

        System.out.println("\nCurrent SQL Date:");
        System.out.println(sqlDate);
    }
}