package Java21;

public class PatternMatchingInstanceOfExample {
    public static void main(String[] args) {
        withoutPatternMatching();
        withPatternMatching();
    }

    public static void withoutPatternMatching() {
        Object obj = "Hello, World!";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println("It's a string: " + s);
        } else if (obj instanceof Integer) {
            Integer i = (Integer) obj;
            System.out.println("It's an integer: " + i);
        } else {
            System.out.println("Unknown type");
        }
    }

    public static void withPatternMatching() {
        Object obj = "Hello, World!";
        if (obj instanceof String s) {  // both type check and cast in one step
            System.out.println("It's a string: " + s);
        } else if (obj instanceof Integer i) {
            System.out.println("It's an integer: " + i);
        } else {
            System.out.println("Unknown type");
        }
    }
    
}

/*
-> Here "obj instanceof String s" perform two operations:
            -> first it checks if obj is an instance of String (type check: obj instanceof String)
            -> second it casts the object to String and assigns it to the variable s (cast: (String) obj)
*/