package Java14;

/**
 * ============================================================
 * SwitchEnhancementDemo
 * ============================================================
 *
 * Demonstrates the enhancement of switch statements to
 * switch expressions (Java 14+), including:
 * - Traditional switch (pre-Java 14)
 * - Switch expression with arrow syntax (Java 14+)
 * - Using 'var' for local variable type inference
 */
public class SwitchEnhancementDemo {

    public static void main(String[] args) {

        // Using 'var' (Java 10+) for local variable type inference
        var day = 2;

        // -----------------------------------------------
        // Traditional switch demonstration (pre-Java 14)
        // -----------------------------------------------
        traditionalSwitch(day);

        // -----------------------------------------------
        // Switch expression demonstration (Java 14+)
        // -----------------------------------------------
        // No fallthrough with arrow syntax (->)
        var dayName = switchExpression(day);
        System.out.println("Switch Expression Result: " + dayName);
    }

    /**
     * Traditional switch statement (Java 7–13)
     * @param day integer representing the day
     */
    public static void traditionalSwitch(int day) {
        System.out.println("Traditional Switch Output:");

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;  // ❌ Break required to prevent fallthrough
            case 2:
                System.out.println("Tuesday");
                break;  // ❌ Break required to prevent fallthrough
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }
    }

    /**
     * Switch expression (Java 14+)
     * @param day integer representing the day
     * @return name of the day
     *
     * Features:
     * - Arrow syntax '->' prevents fallthrough
     * - Can return a value directly
     * - Beginner-friendly and concise
     */
    public static String switchExpression(int day) {
        return switch (day) {
            case 1 -> "Monday";      // ✅ No fallthrough
            case 2 -> "Tuesday";     // ✅ No fallthrough
            case 3 -> "Wednesday";   // ✅ No fallthrough
            default -> "Other day";  // ✅ Default case
        };
    }
}
