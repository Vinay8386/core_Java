package Latest_Feature_Practice.Module1;

public class GenerateEmployeeOL {
    public static void main(String[] args) {
        //Generate offer letter for Intern
        //Get name, id and department of intern
        EmployeeHierarchy emp = new Intern("Ashmita", "HR", 101, 55000);

        String name = emp.getName();
        int id = emp.getId();
        double salary = emp.getSalary();
        String dept = emp.getDepartment();

        System.out.println(generateOfferLetter(name,id,salary,dept));

    }

    private static String generateOfferLetter(String name, int id, double salary, String dept) {
        String letter = """
                Dear %s,

                Welcome to ABC Company.

                Department : %s
                ID : %d             
                Salary     : %.2f
                """.formatted(name,dept,id,salary);

        return letter;
    }
}
