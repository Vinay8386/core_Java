package Java14;

/**
 * ============================================================
 * SwitchYieldDemo
 * ============================================================
 *
 * Demonstrates the difference between:
 * 1. Traditional switch statements (before yield) where multi-statement
 *    cases cannot return a value directly.
 * 2. Modern switch expressions (after yield) where multi-statement
 *    cases can return a value directly using 'yield'.
 *
 * Java Version: 14+
 */
class Employee {
    String name;
    String department;
    int experience; // in years

    /**
     * Employee constructor
     * @param name Employee name
     * @param department Employee department
     * @param experience Years of experience
     */
    Employee(String name, String department, int experience) {
        this.name = name;
        this.department = department;
        this.experience = experience;
    }
}

public class SwitchYieldDemo {

    public static void main(String[] args) {
        var emp = new Employee("Alice", "IT", 6);

        // -----------------------------
        // Before yield: Traditional switch
        // -----------------------------
        var gradeOld = traditionalSwitchBeforeYield(emp);
        System.out.println("Grade (Traditional Switch): " + gradeOld);

        // -----------------------------
        // After yield: Modern switch expression
        // -----------------------------
        var gradeNew = switchExpressionWithYield(emp);
        System.out.println("Grade (Switch Expression with yield): " + gradeNew);
    }

    /**
     * Traditional switch statement (Before yield)
     *
     * Multi-statement cases are allowed, but returning a value directly
     * from the case is NOT allowed.
     * Instead, we must store the result in a variable and return it after the switch.
     *
     * @param emp Employee object
     * @return Employee grade based on experience
     */
    public static String traditionalSwitchBeforeYield(Employee emp) {
        String grade; // variable to store result

        switch (emp.experience) {
            case 0, 1, 2:
                grade = "Junior";
                break;
            case 3, 4, 5:
                System.out.println(emp.name + " has mid-level experience"); // multi-statement
                grade = "Mid-level"; // store result in variable
                break;
            case 6, 7, 8:
                System.out.println(emp.name + " is senior in " + emp.department); // multi-statement
                grade = "Senior"; // store result in variable
                break;
            default:
                grade = "Legend";
        }

        return grade; // return after switch
    }

    /**
     * Modern switch expression with yield (Java 12+)
     *
     * Multi-statement cases are allowed and can return a value directly
     * using the 'yield' keyword.
     *
     * @param emp Employee object
     * @return Employee grade based on experience
     */
    public static String switchExpressionWithYield(Employee emp) {
        return switch (emp.experience) {

            // Single-expression case: no yield needed
            case 0, 1, 2 -> "Junior";

            // Multi-statement case: yield required
            case 3, 4, 5 -> {
                System.out.println(emp.name + " has mid-level experience");
                yield "Mid-level"; // returns value directly from block
            }

            case 6, 7, 8 -> {
                System.out.println(emp.name + " is senior in " + emp.department);
                yield "Senior"; // returns value directly from block
            }

            // Default single-expression case
            default -> "Legend";
        };
    }
}

