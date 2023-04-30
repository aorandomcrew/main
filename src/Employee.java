import java.util.Objects;

public class Employee {
    public static int id;
    public String name;
    public int department;
    public double salary;

    public Employee( String name, int department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double setSalary(double salary) {
        return salary;
    }

    @Override
    public String toString() {
        return "id: " + id++ + "\nФИО: " + name + ", отдел: " + department + ", зарплата: $" + salary ;
    }

}
