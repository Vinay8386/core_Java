package Java8.CollectorWithJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionBasedOnGender {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();

        employeeList.add(new Employee(1,"Aditi",30,10000,"F","HR","Mumbai"));
        employeeList.add(new Employee(2,"Rahul",25,20000,"M","ER","Bangalore"));
        employeeList.add(new Employee(3,"Vishal",35,30000,"M","ER","Mumbai"));
        employeeList.add(new Employee(4,"Lakshmi",28,15000,"F","HR","Bangalore"));
        employeeList.add(new Employee(5,"Priya",24,90000,"F","Marketing","Delhi"));

        Map<Boolean,List<Employee>> map=
        employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getGender().equals("M")));
        List<Employee> maleList=map.get(true);
        System.out.println("Male employee");
        for (Employee e:maleList) {
            System.out.println(e.getName());
        }
        System.out.println("Female employee");
        List<Employee> femaleList=map.get(false);
        for (Employee e:femaleList) {
            System.out.println(e.getName());
        }

        //partition based on even and odd age
        Map<Boolean,List<Employee>> agePart=
        employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge()%2==0));
        System.out.println("Employee with even age");
        for (Employee e:agePart.get(true)) {
            System.out.println(e.getName());
        }
        System.out.println("Employee with odd age");
        for (Employee e:agePart.get(false)) {
            System.out.println(e.getName());
        }
    }
}
