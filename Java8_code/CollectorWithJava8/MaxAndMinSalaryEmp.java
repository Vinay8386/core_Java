package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

//Find the employee with the highest salary
public class MaxAndMinSalaryEmp {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","HR","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));

        Map<String,Long> maxSalary=
        employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(employee ->
                        Map.of(employee.getName(),employee.getSalary())
                ).get();
        System.out.println(maxSalary);

        Map<String,Long> minSalary=
        employeeList.stream()
                .min(Comparator.comparing(Employee::getSalary))
                .map(employee -> Map.of(employee.getName(),employee.getSalary()))
                        .get();
        System.out.println(minSalary);
    }
}