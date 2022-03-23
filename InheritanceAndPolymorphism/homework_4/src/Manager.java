public class Manager implements Employee{

    private int salary = 50_000;
    private static final double BONUS = 0.05;
    private int salesCompany;

    public Manager() {
        salesCompany = (int) (115_000 + (25_000 * Math.random()));
        salary += salesCompany * BONUS;
    }

    @Override
    public int getMonthSalary() {
        return salary;  
    }

    public int getSalesCompany() {
        return salesCompany;
    }
}
