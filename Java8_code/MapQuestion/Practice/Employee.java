package Java8_code.MapQuestion.Practice;

import java.time.LocalDate;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private String city;
    private double salary;
    private String designation;
    private int experience;
    private boolean active;
    private LocalDate joiningDate;
    private String manager;
    private double rating;
    private String project;
    private String email;

    public Employee(int id,
                    String name,
                    int age,
                    String gender,
                    String department,
                    String city,
                    double salary,
                    String designation,
                    int experience,
                    boolean active,
                    LocalDate joiningDate,
                    String manager,
                    double rating,
                    String project,
                    String email) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.city = city;
        this.salary = salary;
        this.designation = designation;
        this.experience = experience;
        this.active = active;
        this.joiningDate = joiningDate;
        this.manager = manager;
        this.rating = rating;
        this.project = project;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public String getManager() {
        return manager;
    }

    public double getRating() {
        return rating;
    }

    public String getProject() {
        return project;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", experience=" + experience +
                ", active=" + active +
                ", joiningDate=" + joiningDate +
                ", manager='" + manager + '\'' +
                ", rating=" + rating +
                ", project='" + project + '\'' +
                '}';
    }
}

