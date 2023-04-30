import java.util.Objects;

public class Main {

    private static final Employee[] worker = new Employee[10];


    public static void main(String[] args) {
        worker[0] = new Employee("Богомолов Данил Игоревич", 1, getSalary());
        worker[1] = new Employee("Белов Святослав Феликсович", 1, getSalary());
        worker[2] = new Employee("Осипов Ярослав Феликсович", 2, getSalary());
        worker[3] = new Employee("Павлова Лидия Донатовна", 2, getSalary());
        worker[4] = new Employee("Морозова Нина Пётровна", 3, getSalary());
        worker[5] = new Employee("Дроздова Харитина Прокловна", 3, getSalary());
        worker[6] = new Employee("Прохоров Антон Глебович", 4, getSalary());
        worker[7] = new Employee("Титов Феликс Альвианович", 4, getSalary());
        worker[8] = new Employee("Блинов Гарри Геласьевич", 5, getSalary());
        worker[9] = new Employee("Субботин Роман Анатольевич", 5, getSalary());
        System.out.println(getEmployee());
        System.out.println();
        System.out.println("сумма затрат на зарплаты: $" + sumExpenses(worker));
        System.out.println();
        System.out.println("минимальная зп сотрудника: $" + minSalary());
        System.out.println();
        System.out.println("максимальная зп сотрудника: $" + maxSalary());
        System.out.println();
        System.out.println("средняя зп сотрудников: $" + avgSalary());
        System.out.println();
        System.out.println("ФИО сотрудников:");
        System.out.println(workersName());
        System.out.println("повышенная сложность");
        System.out.println(salaryIndexing());
        System.out.println();
        System.out.println("далее задачи выполнены с учетом индексации:");
        System.out.println();
        System.out.println("* минимальная зп сотрудника 2ого отдела: $" + minSalaryDepartment());
        System.out.println();
        System.out.println("* максимальная зп сотрудника 4ого отдела: $" + maxSalaryDepartment());
        System.out.println();
        System.out.println("* сумма затрат на зп 4ого отдела: $" + sumSalaryDepartment());
        System.out.println();
    }

    public static char getEmployee() {
        for (int i = 0; i < 10; i++) {
            System.out.println(worker[i]);
        }
        return 32;
    }

    public static double getSalary() {
        double start = 1000.0d;
        double end = 4000.0d;
        double roundOff = Math.round(((Math.random() * (end - start)) + start) * 100.0) / 100.0;
        return roundOff;
    }

    public static double sumExpenses(Employee[] arr) {
        double sum = 0d;
        for (Employee element : arr) {
            sum = sum + element.getSalary();
        }
        double roundOff = Math.round(sum * 100.0) / 100.0;
        return roundOff;
    }

    public static double minSalary() {
        double min = worker[0].salary;
        for (int i = 0; i < worker.length; i++) {
            if (min > worker[i].getSalary()) {
                min = worker[i].salary;
            }
        }
        return min;
    }

    public static double maxSalary() {
        double max = worker[0].salary;
        for (int i = 0; i < worker.length; i++) {
            if (max < worker[i].getSalary()) {
                max = worker[i].salary;
            }
        }
        return max;
    }

    public static double avgSalary() {
        double avg = 0;
        for (int i = 0; i < worker.length; i++) {
            avg = avg + worker[i].getSalary();
        }
        avg = avg / worker.length;
        double roundOff = Math.round(avg * 100.0) / 100.0;
        return roundOff;
    }

    public static char workersName() {
        for (int i = 0; i < worker.length; i++) {
            System.out.println((i + 1) + ". " + worker[i].name);
        }
        return 32;
    }

    //повышенная сложность
    public static double salaryIndexing() {
        for (int i = 0; i < worker.length; i++) {
            worker[i].salary = worker[i].salary * 1.2;
            worker[i].salary = Math.round(worker[i].salary * 100.0) / 100.0;
            System.out.println("зп сотрудника №" + (i + 1) + " после индексации - " + worker[i].salary);
        }
        return 0;
    }

    public static double minSalaryDepartment() {
        double min = worker[0].getSalary();
        for (int i = 0; i < worker.length; i++) {
            if (worker[i].getDepartment() == 2) {
                if (min > worker[i].getSalary()) {
                    min = worker[i].getSalary();
                }
            }
        }
        return min;
    }

    public static double maxSalaryDepartment() {
        double max = worker[0].getSalary();
        for (int i = 0; i < worker.length; i++) {
            if (worker[i].getDepartment() == 4) {
                if (max < worker[i].getSalary()) {
                    max = worker[i].getSalary();
                }
            }
        }
        return max;
    }

    public static double sumSalaryDepartment() {
        double sum = 0d;
        for (int i = 0; i < worker.length; i++) {
            if (worker[i].getDepartment() == 4) {
                sum = sum + worker[i].getSalary();
            }
        }
        double roundOff = Math.round(sum * 100.0) / 100.0;
        return roundOff;
    }
}
