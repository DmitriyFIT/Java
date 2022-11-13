import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();

//    public Bank() {
//        //fillAccounts();
//    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        boolean blocked;

        if (fromAccount.isBlocked() || toAccount.isBlocked()) {
            return;
        }

        if (fromAccount.getMoney() >= amount) {
            toAccount.setMoney(toAccount.getMoney() + amount);
            fromAccount.setMoney(fromAccount.getMoney() - amount);
        }

        if (amount > 50_000) {
            blocked = isFraud(fromAccountNum, toAccountNum, amount);
            if (blocked) {
                fromAccount.setBlocked(true);
                toAccount.setBlocked(true);
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum = 0;
        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            sum += account.getValue().getMoney();
        }
        return sum;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    public void getAllAccounts() {
        for (Map.Entry<String, Account> account : accounts.entrySet()) {
            System.out.println(account.getValue());
        }
    }

    public void fillAccounts() {
        long amount = 0;
        for (int i = 0; i < 20; i++) {
            amount = (long) (100_000 + 20_000 * Math.random());
            accounts.put(String.valueOf(i), new Account(amount, String.valueOf(i)));
        }
    }

    public int getNumberAccounts() {
        return accounts.size();
    }
}
