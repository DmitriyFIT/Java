public class TopManager implements Employee{

    private static final int FIXPARTSALARY = 180_000;
    private static final double BONUS = 1.5;
    private int salary;
    Company companyInCome = new Company();

    @Override
    public int getMonthSalary() {
        if (companyInCome.getIncomeCompany() > 10_000_000) {
            return salary = (int) (FIXPARTSALARY * BONUS);
        }
        else {
            return salary = FIXPARTSALARY;
        }
    }

    @Override
    public String getInfoSalary() {
        return "TopManager - зарплата складывается из фиксированной части " +
                "и бонуса в виде 150% от заработной платы, " +
                "если доход компании более 10 млн рублей.";
    }

    @Override
    public String toString() {
        return salary + " руб.";
    }
}
