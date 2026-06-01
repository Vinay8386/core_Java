package Java16.Record_Rule_Verification;

record RecordRulesVerification(
        int id,
        String name,
        double salary) {

    // =====================================================
    // Static Variable (Allowed)
    // =====================================================
    static String COMPANY = "Vinay Dev Studio";

    // =====================================================
    // Static Block (Allowed)
    // Executes once when Record class is loaded
    // =====================================================
    static {
        System.out.println("Record Class Loaded...");
    }

    // =====================================================
    // Compact Constructor (Allowed)
    // Used for validation
    // =====================================================
    public RecordRulesVerification {

        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Id must be greater than 0");
        }

        if (salary < 0) {
            throw new IllegalArgumentException(
                    "Salary cannot be negative");
        }
    }

    // =====================================================
    // Instance Method (Allowed)
    // =====================================================
    public boolean isHighPaidEmployee() {
        return salary > 100000;
    }

    // =====================================================
    // Another Instance Method (Allowed)
    // =====================================================
    public String employeeInfo() {
        return id + " - " + name + " - " + salary;
    }

    // =====================================================
    // Override Generated Accessor (Allowed)
    // Compiler already generates name()
    // We are overriding it
    // =====================================================
    @Override
    public String name() {
        return name.toUpperCase();
    }

    // =====================================================
    // Static Method (Allowed)
    // =====================================================
    public static void printCompanyName() {
        System.out.println("Company : " + COMPANY);
    }

    // =====================================================
    // Main Method
    // =====================================================
    public static void main(String[] args) {

        RecordRulesVerification employee =
                new RecordRulesVerification(
                        101,
                        "Vinay",
                        120000
                );

        System.out.println("\n===== Generated Accessors =====");

        System.out.println(employee.id());

        // Calls overridden accessor
        System.out.println(employee.name());

        System.out.println(employee.salary());

        System.out.println("\n===== Instance Methods =====");

        System.out.println(
                employee.isHighPaidEmployee()
        );

        System.out.println(
                employee.employeeInfo()
        );

        System.out.println("\n===== Static Members =====");

        System.out.println(
                RecordRulesVerification.COMPANY
        );

        RecordRulesVerification
                .printCompanyName();

        System.out.println("\n===== Generated Methods =====");

        // Generated toString()
        System.out.println(employee);

        // Generated hashCode()
        System.out.println(employee.hashCode());

        // Generated equals()
        System.out.println(
                employee.equals(
                        new RecordRulesVerification(
                                101,
                                "Vinay",
                                120000
                        )
                )
        );
    }
}
