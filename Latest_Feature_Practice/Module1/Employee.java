package Latest_Feature_Practice.Module1;

public record Employee(int id, String name, String department, double salary) {

    //Validate id and salary in compact constructor
    public Employee{
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
        if (salary < 0) throw new IllegalArgumentException("Salary cannot be negative");
    }
}
