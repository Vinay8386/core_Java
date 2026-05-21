package Java21;

class SwitchExample {
    public static void main(String[] args) {

        traditionalSwitch(); //traditional switch example

        modernSwitchExpression(); //pattern matching switch example

        patternMatchingSwitch(); //pattern matching switch example
    }

    public static void patternMatchingSwitch() {
        Object obj = "Hello, World!";
        String result = switch (obj) {
            case String s -> "It's a string: " + s;  // Pattern matching for String
            case Integer i -> "It's an integer: " + i; // Pattern matching for Integer
            default -> "Unknown type"; // Default case for other types
        };
        System.out.println(result); 
    }

    public static void modernSwitchExpression() {
        String day = "Monday";
        String result = switch (day) {
            case "Monday" -> "Start of the work week!";
            case "Friday" -> "End of the work week!";
            case "Saturday", "Sunday" -> "It's the weekend!";
            default -> "Midweek days.";
        };
        System.out.println(result); 
    }

    public static void traditionalSwitch() {
        String day = "Monday";
        String result;

        switch (day) {
            case "Monday":
                result = "Start of the work week!";
                break;
            case "Friday":
                result = "End of the work week!";
                break;
            case "Saturday":
            case "Sunday":
                result = "It's the weekend!";
                break;
            default:
                result = "Midweek days.";
        }

        System.out.println(result);
    }
}

//Using Pattern Matching with switch (Preview Feature in Java 21)
