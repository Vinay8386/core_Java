package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Fetch top 3 salaried employee details
public class FetchTop3SalaryEmpDetails {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","HR","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));

        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}
