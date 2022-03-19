public class Main {
    public static void main(String[] args) {
        Employee employeeOP = new Operator();
        Employee employeeM = new Manager();
        Employee employeeTM = new TopManager();

        Company company = new Company();
        Company company1 = new Company();

        company.hireAll(employeeTM, 10);
        company1.hireAll(employeeM, 10);
        //company.hireAll(employeeOP, 180);
        //company.hireAll(employeeM, 80);
        company.getLowestSalaryStaff(10);
        System.out.println("-------------------------------------------------");
        company1.getTopSalaryStaff(10);
    }
}
