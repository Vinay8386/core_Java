package Java8.InterviewQuestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Filter employee having age more than 20
public class EmployeeFilter {

    public static void main(String[] args) {
        List<Employee> employees=new ArrayList<>();
        // Adding employees to the list
        employees.add(new Employee(1, "John Doe", 25));
        employees.add(new Employee(2, "Jane Smith", 30));
        employees.add(new Employee(3, "Mike Johnson", 19)); // This employee is under 20
        employees.add(new Employee(4, "Sarah Parker", 22));

        // Now filter and print the employees with age greater than 20
        List<Employee> employeeAgeGreaterThan20= employees.stream()
                .filter(emp->emp.getAge()>20)
                .collect(Collectors.toList());

        System.out.println(employeeAgeGreaterThan20);
        employeeAgeGreaterThan20.forEach(System.out::println);

        System.out.println("=================================================");

        for (Employee e:employeeAgeGreaterThan20) {
            System.out.println(e.getName()+", "+e.getEmployee_id()+", "+e.getAge()); //If we don't override toString method in Employee class
        }

        System.out.println("=================================================");

        //Print the name of the employee having age greater than 20
        /*List<String> nameOfEmployeeHavingAgeGreaterThan20= employees.stream()
                .filter(emp->emp.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());*/
        List<String> nameOfEmployeeHavingAgeGreaterThan20= employees.stream()
                .filter(emp->emp.getAge()>20)
                .map(name->name.getName())
                .collect(Collectors.toList());
        nameOfEmployeeHavingAgeGreaterThan20.forEach(System.out::println);

        System.out.println("================================================");

        //Print details of employee using id given, don't print id
        int searchId=2;
        Employee result=employees.stream()
                .filter(e->e.getEmployee_id()==searchId)
                .findFirst()
                .orElse(null);
        if(result!=null){
            System.out.println(result);
        }else {
            System.out.println("No employee available with this particular id ");
        }

        System.out.println("================================================");

        //sort employee based on their name and age in ascending
        List<Employee> list=employees.stream()
                .sorted(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getAge))
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("================================================");

        //sort employee based on their name and age in ascending
        List<Employee> list2=employees.stream()
                .sorted(Comparator.comparing(Employee::getName,Comparator.naturalOrder())
                        .thenComparing(Employee::getAge,Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(list2);

        //sort employee based on their name and age in descending order
        List<Employee> list3=employees.stream()
                .sorted(Comparator.comparing(Employee::getName,Comparator.reverseOrder())
                        .thenComparing(Employee::getAge,Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(list3);
    }
}
