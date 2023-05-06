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
        System.out.println("минимальная зп сотрудника: " + minSalary());
        System.out.println();
        System.out.println("максимальная зп сотрудника: " + maxSalary());
        System.out.println();
        System.out.println("средняя зп сотрудников: $" + avgSalary());
        System.out.println();
        System.out.println("ФИО сотрудников:");
        workersName();
        System.out.println("повышенная сложность");
        System.out.println();
        salaryIndexing();
        System.out.println();
        System.out.println("* минимальная зп сотрудника 2ого отдела: " + minSalaryDepartment());
        System.out.println();
        System.out.println("* максимальная зп сотрудника 4ого отдела: " + maxSalaryDepartment());
        System.out.println();
        int depCounter = 2;
        System.out.println("* сумма затрат на зп " + depCounter + " отдела: $" + sumSalaryDepartment(depCounter));
        System.out.println();
        int departmentCounter = 0;
        for (int i = 0; i < 5; i++) {
            departmentCounter++;
            System.out.println("* средняя зп " + departmentCounter + " отдела: $" + avgSalaryDepartment(departmentCounter));
        }
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

    public static Employee minSalary() {
        Employee min = worker[0];
        for (Employee employee : worker) {
            if (min.getSalary() > employee.getSalary()) {
                min = employee;
            }
        }
        return min;
    }

    public static Employee maxSalary() {
        Employee max = worker[0];
        for (Employee employee : worker) {
            if (max.getSalary() < employee.getSalary()) {
                max = employee;
            }
        }
        return max;
    }

    public static double avgSalary() {
        double avg = 0;
        for (Employee emplyee : worker) {
            avg = avg + emplyee.getSalary();
        }
        avg = avg / worker.length;
        double roundOff = Math.round(avg * 100.0) / 100.0;
        return roundOff;
    }

    public static void workersName() {
        for (int i = 0; i < worker.length; i++) {
            System.out.println((i + 1) + ". " + worker[i].getName());
        }
    }

    //повышенная сложность
    public static void salaryIndexing() {
        double indexing = 1.2;
        double tmp;
        System.out.println("процент индексации: " + Math.round((indexing - 1) * 100) + "%");
        for (int i = 0; i < worker.length; i++) {
            tmp = worker[i].getSalary() * indexing;
            tmp = Math.round(tmp * 100.0) / 100.0;
            System.out.println("зп сотрудника №" + (i + 1) + " после индексации - $" + tmp);
        }
    }

    public static Employee minSalaryDepartment() {
        Employee minDep = maxSalary();
        for (Employee employee : worker) {
            if (employee.getDepartment() == 2) {
                if (minDep.getSalary() > employee.getSalary()) {
                    minDep = employee;
                }
            }
        }
        return minDep;
    }

    public static Employee maxSalaryDepartment() {
        Employee maxDep = minSalary();
        for (Employee employee : worker) {
            if (employee.getDepartment() == 4) {
                if (maxDep.getSalary() < employee.getSalary()) {
                    maxDep = employee;
                }
            }
        }
        return maxDep;
    }

    public static double sumSalaryDepartment(int depCounter) {
        double sum = 0d;
        for (Employee employee : worker) {
            if (employee.getDepartment() == depCounter) {
                sum = sum + employee.getSalary();
            }
        }
        double roundOff = Math.round(sum * 100.0) / 100.0;
        return roundOff;
    }

    public static double avgSalaryDepartment(int departmentNumber) {
        double sum = 0d;
        int departmentCounter = 0;
        for (Employee employee : worker) {
            if (employee.getDepartment() == departmentNumber) {
                departmentCounter++;
                sum = sum + employee.getSalary();
            }
        }
        double roundOff = Math.round((sum / departmentCounter) * 100.0) / 100.0;
        return roundOff;
    }
}
