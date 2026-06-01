package Latest_Feature_Practice.Module1;

public class CheckEmployeeTypeAndPrint {
    public static void main(String[] args) {
        EmployeeHierarchy  PE = new PermanentEmployee("Vinay", "HR", 10, 555550);
        EmployeeHierarchy  CE = new ContractEmployee("Vinay", "HR", 10, 555550);
        EmployeeHierarchy  IE = new Intern("Vinay", "HR", 10, 555550);

        switch(PE){
            case PermanentEmployee emp -> System.out.println("Permanent Employee : "+emp.getName());
            case ContractEmployee emp1 -> System.out.println("Contractual Employee : "+emp1.getId());
            case Intern emp2 -> System.out.println("Interns : "+emp2.getDepartment());
            default -> System.out.println("Invalid Employee");
        }

        switch(CE){
            case PermanentEmployee emp -> System.out.println("Permanent Employee : "+emp.getName());
            case ContractEmployee emp1 -> System.out.println("Contractual Employee : "+emp1.getId());
            case Intern emp2 -> System.out.println("Interns : "+emp2.getDepartment());
            default -> System.out.println("Invalid Employee");
        }

        switch(IE){
            case PermanentEmployee emp -> System.out.println("Permanent Employee : "+emp.getName());
            case ContractEmployee emp1 -> System.out.println("Contractual Employee : "+emp1.getId());
            case Intern emp2 -> System.out.println("Interns : "+emp2.getDepartment());
            default -> System.out.println("Invalid Employee");
        }
    }
}
