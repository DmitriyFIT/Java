public class Manager implements Employee{

    private static final int FIXPARTSALARY = 120_000;
    private static final double BONUS = 0.05;
    protected int salary = 0;
    protected double bonusPart = 0;

    @Override
    public int getMonthSalary() {
        bonusPart =  (115_000 + (25_000 * Math.random())) * BONUS;
        salary = (int) (FIXPARTSALARY + bonusPart);
        return salary;
    }

    @Override
    public String getInfoSalary() {
        return "Manager - зарплата складывается из фиксированной части " +
                "и бонуса в виде 5% от заработанных для компании денег. ";
    }

    @Override
    public String toString() {
        return salary + " руб.";
    }
}
