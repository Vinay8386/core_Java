package Latest_Feature_Practice.Module1;

public sealed class EmployeeHierarchy permits PermanentEmployee, ContractEmployee, Intern{
    private final int id;
    private final String name;
    private final String Department;
    private final double salary;
    
    
    public EmployeeHierarchy(String name, String department, int id, double salary) {
        this.name = name;
        Department = department;
        this.id = id;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return Department;
    }

    public int getId() {
        return id;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((Department == null) ? 0 : Department.hashCode());
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EmployeeHierarchy other = (EmployeeHierarchy) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Department == null) {
            if (other.Department != null)
                return false;
        } else if (!Department.equals(other.Department))
            return false;
        if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
            return false;
        return true;
    }
}

final class PermanentEmployee extends EmployeeHierarchy{
    public PermanentEmployee(String name, String department, int id, double salary){
        super(name, department, id, salary);
    }
}

final class ContractEmployee extends EmployeeHierarchy{
    public ContractEmployee(String name, String department, int id, double salary){
        super(name, department, id, salary);
    }
}

final class Intern extends EmployeeHierarchy{
    public Intern(String name, String department, int id, double salary){
        super(name, department, id, salary);
    }
}