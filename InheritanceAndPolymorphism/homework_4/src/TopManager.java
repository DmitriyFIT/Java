public class TopManager implements Employee{

    private int salary = 60_000;
    private static final double BONUS = 1.5;
    private Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > 10_000_000) {
            return (int) (salary * BONUS);
        }
        return salary;
    }
}
