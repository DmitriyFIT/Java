import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();

        List<Employee> employeeManagers = new ArrayList<>();
        List<Employee> employeeTopManagers = new ArrayList<>();
        List<Employee> employeeOperator = new ArrayList<>();

        for (int i = 0; i < 180; i++) {
            employeeOperator.add(new Operator());
        }

        for (int i = 0; i < 80; i++) {
            employeeManagers.add(new Manager());
        }

        for (int i = 0; i < 10; i++) {
            employeeTopManagers.add(new TopManager(company));
        }

        company.hireAll(employeeOperator);
        company.hireAll(employeeManagers);
        company.hireAll(employeeTopManagers);
        company.hire(new Manager());

        printList(company);

        List<Employee> employees = company.getEmployeeList();
        int size = employees.size() / 2;
        for (int i = 0; i < size; i++) {
            company.fire(employees.get(i));
        }

        printList(company);
    }

    private static void printList(Company company) {
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        for (Employee emp : topSalaryStaff) {
            System.out.println(emp.getMonthSalary());
        }
        System.out.println("--------------------------------------");

        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(15);
        for (Employee emp : lowestSalaryStaff) {
            System.out.println(emp.getMonthSalary());
        }
        System.out.println("--------------------------------------");
    }
}
