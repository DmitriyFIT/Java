import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {

    private ArrayList<Employee> employeeList;

    public Company() {
        employeeList = new ArrayList<>();
        getIncomeCompany();
    }

    public int getIncomeCompany() {
        return (int) (9_000_000 + (1_800_000 * Math.random()));
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(Employee employee, int count) {
        for (int i = 0; i < count; i++) {
            if (employee.getClass().equals(Manager.class)) {
                Employee employeeM = new Manager();
                employeeList.add(employeeM);
            } else if (employee.getClass().equals(Operator.class)) {
                Employee employeeOP = new Operator();
                employeeList.add(employeeOP);
            } else {
                Employee employeeTM = new TopManager();
                employeeList.add(employeeTM);
            }
        }
    }

    public void fire() {
        int fireCount = employeeList.size() / 2;
        while (employeeList.size() > fireCount) {
            employeeList.remove(fireCount);
        }
    }

    public void enter(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(employeeList.get(i));
        }
        System.out.println(employeeList.size());
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });
        enter(count);
        return employeeList;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        return null;
    }
}
