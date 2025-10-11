package Java8.InterviewQuestion;

public class Employee {

    private String name;
    private int employee_id;
    private int age;

    public Employee(int employee_id,String name, int age) {
        this.name = name;
        this.employee_id = employee_id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*@Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employee_id=" + employee_id +
                ", age=" + age +
                '}';
    }*/


}
