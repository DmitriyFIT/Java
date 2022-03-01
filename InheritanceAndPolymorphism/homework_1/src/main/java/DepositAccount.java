import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private static LocalDate lastIncome;
    private static LocalDate now;

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        now = LocalDate.now();
        if (now.isAfter(lastIncome.plusMonths(1))) {
            super.take(amountToTake);
        }
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }
}
