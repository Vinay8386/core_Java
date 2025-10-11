package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Fetch salary less than the third-highest salary
public class FetchSalryLessThanThirdHighest {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","HR","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));

        //Method-1
        //find the third-highest salary
        Double thirdHighestSalary=
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(2)  // Skip the top 2 (highest earners)
                .limit(1) // Get only the 3rd highest salary
                .mapToDouble(Employee::getSalary) // Extract salary as double
                .findFirst()
                .orElse(0.0);

        System.out.println("======================");
        System.out.println("Third highest salary is : "+thirdHighestSalary);
        System.out.println("=====================");

        List<Employee> employeeList1=
        employeeList.stream()
                .filter(employee -> employee.getSalary()<thirdHighestSalary)
                .collect(Collectors.toList());
        System.out.println(employeeList1);

        //Method-2
        System.out.println("===================================================");
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(3)
                .forEach(System.out::println);
    }
}
