package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Group employees by city and calculate average age
public class GroupByCityAndCalAvgAge {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","HR","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));

        Map<String, Double> map=
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCity,Collectors.averagingInt(Employee::getAge)));
        System.out.println(map);
    }
}
