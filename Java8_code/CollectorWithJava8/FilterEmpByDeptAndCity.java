package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FilterEmpByDeptAndCity {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","ER","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));
        employeeList.add(new Employee(6,"Vinay",28,110000,"M","ER","Mumbai"));

        ////filter the names of employees who belong to the "ER" department and have the city "Bangalore."
        employeeList.stream()
                .filter(employee -> employee.getDeptName().equals("ER") && employee.getCity().equals("Mumbai"))
                .map(Employee::getName)
                .forEach(System.out::println);

        //filter the names, id and age of employees who belong to the "ER" department and have the city "Bangalore".
        employeeList.stream()
                .filter(employee -> employee.getDeptName().equals("ER") && employee.getCity().equals("Mumbai"))
                .map(employee -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name",employee.getName());
                    map.put("Age",employee.getAge());
                    map.put("id",employee.getId());
                    return map;
                }).forEach(System.out::println);
        //OR
        employeeList.stream()
                .filter(employee -> employee.getDeptName().equals("ER") && employee.getCity().equals("Mumbai"))
                .map(employee ->
                    Map.of("name",employee.getName(),"Age",employee.getAge(),"id",employee.getId())
                ).forEach(System.out::println);
    }
}
