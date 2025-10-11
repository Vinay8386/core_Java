package Basic_concept;

public class Test {

    private int id;
    private String name;
    private long salary;

    public Test(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Test(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Test(int i) {
        this.id=i;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
