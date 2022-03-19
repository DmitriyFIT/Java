import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Company {

    private ArrayList<Employee> employeeList;

    public Company() {
        employeeList = new ArrayList<>();
    }

    public int getIncomeCompany() {
        return (int) (9_000_000 + (1_800_000 * Math.random()));
    }

    public void hire(Employee employee) {
        employee.getMonthSalary();
        employeeList.add(employee);
    }

    public void hireAll(Employee employee, int count) {
        for (int i = 0; i < count; i++) {
            employee.getMonthSalary();
            employeeList.add(employee);
        }
    }

    public void fire() {
        int fireCount = employeeList.size() / 2;
        while (employeeList.size() > fireCount) {
            employeeList.remove(fireCount);
        }
    }

    public void printListEmployee(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(employeeList.get(i));
        }
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getMonthSalary(), o2.getMonthSalary());
            }
        });

        if (count > 0 && count <= employeeList.size()) {
            printListEmployee(count);
            return employeeList;
        }
        else {
            return null;
        }
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare((o2.getMonthSalary()), o1.getMonthSalary());
            }
        });
        if (count > 0 && count <= employeeList.size()) {
            printListEmployee(count);
            return employeeList;
        }
        else {
            return null;
        }
    }
}
