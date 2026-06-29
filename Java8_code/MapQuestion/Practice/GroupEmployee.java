package Java8_code.MapQuestion.Practice;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupEmployee {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

            new Employee(101,"Vinay",27,"Male","IT","Bangalore",
            85000,"Software Engineer",4,true,
            LocalDate.of(2022,1,10),"Rajesh",4.5,"Banking","vinay@gmail.com"),

            new Employee(102,"Rahul",30,"Male","HR","Delhi",
            65000,"HR Executive",6,true,
            LocalDate.of(2019,5,15),"Anita",4.0,"Recruitment","rahul@gmail.com"),

            new Employee(103,"Neha",29,"Female","Finance","Hyderabad",
            90000,"Finance Analyst",7,true,
            LocalDate.of(2018,8,20),"Vikas",4.8,"Payroll","neha@gmail.com"),

            new Employee(104,"Amit",26,"Male","IT","Pune",
            78000,"Software Engineer",3,true,
            LocalDate.of(2023,2,5),"Rajesh",4.2,"Insurance","amit@gmail.com"),

            new Employee(105,"Priya",31,"Female","IT","Bangalore",
            120000,"Tech Lead",9,true,
            LocalDate.of(2016,3,18),"Suresh",4.9,"Banking","priya@gmail.com"),

            new Employee(106,"Karan",35,"Male","Sales","Mumbai",
            70000,"Sales Manager",10,false,
            LocalDate.of(2015,7,25),"Deepak",3.9,"Retail","karan@gmail.com"),

            new Employee(107,"Sneha",28,"Female","IT","Delhi",
            88000,"Backend Developer",5,true,
            LocalDate.of(2021,10,1),"Rajesh",4.7,"Healthcare","sneha@gmail.com"),

            new Employee(108,"Rohit",32,"Male","Finance","Mumbai",
            98000,"Senior Analyst",8,true,
            LocalDate.of(2017,11,11),"Vikas",4.3,"Audit","rohit@gmail.com"),

            new Employee(109,"Pooja",25,"Female","HR","Pune",
            60000,"HR Executive",2,true,
            LocalDate.of(2024,1,8),"Anita",4.1,"Recruitment","pooja@gmail.com"),

            new Employee(110,"Arjun",29,"Male","IT","Hyderabad",
            93000,"Full Stack Developer",6,true,
            LocalDate.of(2020,6,14),"Suresh",4.6,"E-Commerce","arjun@gmail.com")
        );

        /*
        1. Group employees by department

            Expected Output:
            IT -> [Vinay, Amit, Priya, Sneha, Arjun]
            HR -> [Rahul, Pooja]
            Finance -> [Neha, Rohit]
            Sales -> [Karan]
        */
        Map<String, List<Employee>> employeeByDepartment =
                employees.stream()
                         .collect(Collectors.groupingBy(Employee::getDepartment));

        employeeByDepartment.forEach((dept,empList)->{
            System.out.println(dept+"->"+
                empList.stream()
                        .map(Employee::getName)
                        .toList()
            );
        });

        System.out.println("===========================================================================================");

        /*
        2. Count employees by department

            Expected Output:
            IT -> 5
            HR -> 2
            Finance -> 2
            Sales -> 1
        */
       Map<String,Long> countEmployeeByDepartment = employees.stream()
                                                            .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        countEmployeeByDepartment.forEach((dept,count)->{
            System.out.println(dept+"->"+count);
        });

        System.out.println("===========================================================================================");
        /*
        3. Group employees by city

            Expected Output:
            Bangalore -> [Vinay, Priya]
            Delhi -> [Rahul, Sneha]
            Hyderabad -> [Neha, Arjun]
            Pune -> [Amit, Pooja]
            Mumbai -> [Karan, Rohit]
        */
       Map<String, List<Employee>> employeeNameGroupByCity =
       employees.stream().collect(Collectors.groupingBy(Employee::getCity));

       employeeNameGroupByCity.forEach((city,empList)->{
        System.out.println(city+" -> "+empList.stream().map(Employee::getName).toList());
       });
        
        System.out.println("===========================================================================================");
        /*
        4. Find employees with salary greater than 80,000

            Expected Output: [Vinay, Neha, Priya, Sneha, Rohit, Arjun]
    
        */
       System.out.println(
                            employees.stream()
                                .filter(e->e.getSalary()>80000)
                                .map(Employee::getName)
                                .toList() 
       );

        System.out.println("===========================================================================================");
        /*
        5. Find active employees

        Expected Output:
        [Vinay, Rahul, Neha, Amit, Priya, Sneha, Rohit, Pooja, Arjun]
        */
       System.out.println(
                            employees.stream()
                                .filter(e->e.isActive())
                                .map(Employee::getName)
                                .toList() 
       );
        System.out.println("===========================================================================================");
        /*
        5. Find inactive employees

        Expected Output:
        [Vinay, Rahul, Neha, Amit, Priya, Sneha, Rohit, Pooja, Arjun]
        */
       System.out.println(
                            employees.stream()
                                .filter(e->!e.isActive())
                                .map(Employee::getName)
                                .toList() 
       );

       System.out.println("===========================================================================================");
       /*
       7. Sort employees by salary ascending

            Expected Output: 
                [Pooja, Rahul, Karan, Amit, Vinay, Sneha, Neha, Arjun, Rohit, Priya]
                [Priya, Rohit, Arjun, Neha, Sneha, Vinay, Amit, Karan, Rahul, Pooja]
       */
      System.out.println(employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .map(Employee::getName)
                .toList());

       System.out.println(employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()))
                .map(Employee::getName)
                .toList());

       System.out.println("===========================================================================================");
       /*
       9. Find highest salary employee

            Expected Output:
            Priya -> 120000
       */
        Map<String, Double> empWithHighestSalary =
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()))
                .findFirst()
                .map(e->Map.of(e.getName(),e.getSalary()))
                .orElse(Map.of());
        System.out.println(empWithHighestSalary);

       System.out.println("===========================================================================================");
       /*
       10. Find Second highest salary employee

            Expected Output:
            Rohit -> 98000
       */
        Map<String, Double> empWithSecondHighestSalary =
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()))
                .skip(1)
                .findFirst()
                .map(e->Map.of(e.getName(),e.getSalary()))
                .orElse(Map.of());
        System.out.println(empWithSecondHighestSalary);

       System.out.println("===========================================================================================");
       /*
       11. Find average salary by department

            Expected Output:
            IT -> 92800.0
            HR -> 62500.0
            Finance -> 94000.0
            Sales -> 70000.0
       */
      Map<String, Double> averageSalaryByDepartment =
      employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalaryByDepartment);

       System.out.println("===========================================================================================");
       /*
       12. Find maximum salary by department

            Expected Output:
            IT -> Priya -> 120000
            HR -> Rahul -> 65000
            Finance -> Rohit -> 98000
            Sales -> Karan -> 70000
       */
      Map<String, List<Employee>> maxSalaryByDepartment =
      employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        maxSalaryByDepartment.forEach((dept,empList)->{
            System.out.println(dept+" -> "
                    +empList.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName).orElse(null)
                    +" -> "+empList.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).orElse(null));
        });

       System.out.println("===========================================================================================");
       /*
       13. Find employees with experience greater than 5 years

            Expected Output: [Rahul, Neha, Priya, Karan, Rohit, Arjun]
       */
       System.out.println(employees.stream()
                                .filter(e -> e.getExperience() > 5)
                                .map(Employee::getName)
                                .collect(Collectors.toList())
                            );

       System.out.println("===========================================================================================");
       /*
       14. Find distinct cities

        Expected Output: [Bangalore, Delhi, Hyderabad, Pune, Mumbai]
       */
       System.out.println(employees.stream()
                                .map(Employee::getCity)
                                .distinct()  //If you apply this before map, it wn't work because it will compare Employee object not city
                                .collect(Collectors.toList())
                            );

       System.out.println("===========================================================================================");
       /*
       15. Find distinct departments

            Expected Output: [IT, HR, Finance, Sales]
       */
       System.out.println(employees.stream()
                                .map(Employee::getDepartment)
                                .distinct()  //If you apply this before map, it wn't work because it will compare Employee object not city
                                .collect(Collectors.toList())
                            );

       System.out.println("===========================================================================================");
       /*
       16. Employees joined after 2022

            Expected Output: [Amit, Pooja]
       */
       System.out.println(employees.stream()
                                .filter(e->e.getJoiningDate().isAfter(LocalDate.of(2022,12,31)))
                                .map(Employee::getName)
                                .collect(Collectors.toList())
                            );

       System.out.println("===========================================================================================");
       /*
       17. Partition employees by active status

            Expected Output:
            true -> [Vinay, Rahul, Neha, Amit, Priya, Sneha, Rohit, Pooja, Arjun]
            false -> [Karan]
       */
       Map<Boolean,List<Employee>> activeInactiveEmployee =
       employees.stream().collect(Collectors.partitioningBy(e->e.isActive()));

       activeInactiveEmployee.forEach((status,empList)->{
        System.out.println(status+" : "+empList.stream().map(Employee::getName).toList());
       });

       System.out.println("===========================================================================================");
       /*
        18. Top 3 highest salary employees

        Expected Output: [Priya, Rohit, Arjun]
       */
       employees.stream().sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()))
                .map(Employee::getName)
                .limit(3)
                .forEach(System.out::println);


       System.out.println("===========================================================================================");
       /*
       19. Group employees by manager

            Expected Output:
            Rajesh -> [Vinay, Amit, Sneha]
            Anita -> [Rahul, Pooja]
            Vikas -> [Neha, Rohit]
            Suresh -> [Priya, Arjun]
            Deepak -> [Karan]
       */
      Map<String, List<Employee>> groupEmployeeByManager =
      employees.stream()
                .collect(Collectors.groupingBy(Employee::getManager));
        groupEmployeeByManager.forEach((Manager,empList)->{
            System.out.println(Manager+" -> "+empList.stream().map(Employee::getName).toList());
        });

       System.out.println("===========================================================================================");
       /*
       20. Join all employee names with comma

            Expected Output:
            Vinay, Rahul, Neha, Amit, Priya, Karan, Sneha, Rohit, Pooja, Arjun
       */
        System.out.println(employees.stream().map(Employee::getName).collect(Collectors.joining(", ")));

       System.out.println("===========================================================================================");
       /*
       21. Count employees in each city

            Expected Output:
            Bangalore -> 2
            Delhi -> 2
            Hyderabad -> 2
            Pune -> 2
            Mumbai -> 2
       */
      Map<String, Long> employeeCountInEachCity =
                    employees.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.counting()));
        employeeCountInEachCity.forEach((city,empCount)-> System.out.println(city+" -> "+empCount));

       System.out.println("===========================================================================================");
       /*
       22. Find all employee names

            Expected Output:[Vinay, Rahul, Neha, Amit, Priya, Karan, Sneha, Rohit, Pooja, Arjun]
       */
        System.out.println(employees.stream().map(Employee::getName).toList());

       System.out.println("===========================================================================================");
       /*
       23. Convert List<Employee> to Map<Integer, Employee>

            Expected Output:
            101 -> Employee(...)
            102 -> Employee(...)
            ...
            110 -> Employee(...)
       */
       Map<Integer, Employee> employeeMap = employees.stream()
        .collect(Collectors.toMap(
                Employee::getId,
                Function.identity()
        ));

        System.out.println(employeeMap);


       System.out.println("===========================================================================================");
       /*
       24. Convert List<Employee> to Map<String, Double> (Name -> Salary)

            Expected Output:
            Vinay -> 85000
            Rahul -> 65000
            Neha -> 90000
            ...
            Arjun -> 93000
       */
        Map<String, Double> employeeNameAndSalary = employees.stream()
                                    .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
        System.out.println(employeeNameAndSalary);

       System.out.println("===========================================================================================");
       /*
       25. Find employee having highest experience

            Expected Output: Karan -> 10 Years
       */
       Map<String,Integer> nameWithHighestExperience = 
       employees.stream().sorted(Comparator.comparing(Employee::getExperience,Comparator.reverseOrder()))
                .limit(1)
                .collect(Collectors.toMap(Employee::getName, Employee::getExperience));

        nameWithHighestExperience.forEach((name,experience)-> System.out.println(name+" -> "+experience+" Years"));

       System.out.println("===========================================================================================");
       /*
       26. Find employee having lowest experience

            Expected Output: Pooja -> 2 Years
       */
        Map<String,Integer> nameWithLowestExperience = 
       employees.stream().sorted(Comparator.comparing(Employee::getExperience)).limit(1)
                .collect(Collectors.toMap(Employee::getName, Employee::getExperience));

        nameWithLowestExperience.forEach((name,experience)-> System.out.println(name+" -> "+experience+" Years"));

        System.out.println("===========================================================================================");
        /*
        27. Sort employees by Experience, then Salary

            Expected Output:
            Pooja
            Amit
            Vinay
            Sneha
            Rahul
            Arjun
            Neha
            Rohit
            Priya
            Karan

        */
       employees.stream().sorted(Comparator.comparing(Employee::getExperience)
                                            .thenComparing(Employee::getSalary))
                        .map(Employee::getName)
                        .forEach(System.out::println);

        System.out.println("===========================================================================================");
        /*
        28. Find employees with Rating > 4.5

            Expected Output:
            Neha
            Priya
            Sneha
            Arjun
        */
       employees.stream().filter(e->e.getRating()>4.5).map(Employee::getName).forEach(System.out::println);

        System.out.println("===========================================================================================");
        /*
        29. Find all unique Managers

            Expected Output:
            [Rajesh, Anita, Vikas, Suresh, Deepak]
        */
        employees.stream().map(Employee::getManager).distinct().forEach(System.out::println);

        System.out.println("===========================================================================================");
        /*
            30. Total salary paid by company

            Expected Output: 849000.0
        */
       double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);
    }
}
