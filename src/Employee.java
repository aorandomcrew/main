public class Employee {
    private static int id;
    public String name;
    public int department;
    public double salary;

    private final int  idName;

    public Employee(String name, int department, double salary) {
        idName=id++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static int getId() {
        return id;
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
        return "id: " + idName+ "\nФИО: " + name + ", отдел: " + department + ", зарплата: $" + salary;
    }

}
