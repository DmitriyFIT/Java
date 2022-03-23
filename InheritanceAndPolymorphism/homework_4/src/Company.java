import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private List<Employee> employeeList = new ArrayList<>();

    public int getIncome() {
        int income = 0;
        for (Employee emp : employeeList){
            if (emp instanceof Manager) {
                income += ((Manager) emp).getSalesCompany();
            }
        }
        return income;
    }

    public void hire(Employee employee) {
        employeeList.add(employee);
    }

    public void hireAll(List<Employee> employeeList) {
        for (Employee emp: employeeList) {
            hire(emp);
        }
    }

    public void fire(Employee employee){
        employeeList.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 && count < employeeList.size()){
            Collections.sort(employeeList);
            Collections.reverse(employeeList);
            return employeeList.subList(0, count);
        }
        else {
            System.out.println("Введено неверное количество сотрудников!");
            return Collections.emptyList();
        }
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 && count < employeeList.size()) {
            Collections.sort(employeeList);
            return employeeList.subList(0, count);
        }
        else {
            System.out.println("Введено неверное количество сотрудников!");
            return Collections.emptyList();
        }
    }

    public List<Employee> getEmployeeList() {
        return new ArrayList<>(employeeList);
    }
}
