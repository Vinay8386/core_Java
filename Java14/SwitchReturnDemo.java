package Java14;

/**
 * ============================================================
 * SwitchReturnDemo
 * ============================================================
 *
 * Demonstrates how values are returned in:
 * 1. Traditional switch statements (Before switch expressions)
 * 2. Modern switch expressions (Java 12+)
 *
 * Key Points:
 * - In traditional switch, a value cannot be returned directly from a case.
 *   You must store it in a variable and return it after the switch block.
 * - In switch expressions, each case can directly return a value using the -> syntax.
 * - Switch expressions are safer and cleaner than traditional switch statements.
 */
public class SwitchReturnDemo {

    public static void main(String[] args) {

        int day = 2;

        // Using traditional switch statement
        String dayNameTraditional = getDayNameTraditional(day);
        System.out.println("Traditional Switch: " + dayNameTraditional);

        // Using switch expression (Java 12+)
        String dayNameExpression = getDayNameExpression(day);
        System.out.println("Switch Expression: " + dayNameExpression);
    }

    /**
     * Traditional switch statement (Before switch expressions)
     *
     * Multi-statement cases are allowed, but you cannot return a value
     * directly from a case. You must assign the result to a variable
     * and return it after the switch block.
     *
     * @param day integer representing the day of the week
     * @return the name of the day as a String
     */
    public static String getDayNameTraditional(int day) {
        String dayName; // variable to store the result

        switch (day) {
            case 1:
                dayName = "Monday";
                break; // prevent fall-through
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default:
                dayName = "Other day";
        }

        // Return the stored value after the switch
        return dayName;
    }

    /**
     * Modern switch expression (Java 12+)
     *
     * Each case can directly return a value using the -> syntax.
     * Multi-statement blocks can use 'yield' to return a value.
     *
     * @param day integer representing the day of the week
     * @return the name of the day as a String
     */
    public static String getDayNameExpression(int day) {
        return switch (day) {
            case 1 -> "Monday";      // single-expression case
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other day";
        };
    }
}

