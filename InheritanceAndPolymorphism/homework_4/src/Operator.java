public class Operator implements Employee{

    private static final int FIXPARTSALARY = 80_000;

    public Operator() {
        getMonthSalary();
    }

    @Override
    public int getMonthSalary() {
        return FIXPARTSALARY;
    }

    @Override
    public String getInfoSalary() {
        return "Operator - зарплата складывается только из фиксированной части.";
    }

    @Override
    public String toString() {
        return FIXPARTSALARY + " руб.";
    }
}
