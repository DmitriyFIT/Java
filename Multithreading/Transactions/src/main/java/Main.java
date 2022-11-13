public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        bank.fillAccounts();

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(
                    () -> {
                        for (int j = 0; j < (bank.getNumberAccounts() - 1); j++) {
                            long amount = (long) (40_000 + 20_000 * Math.random());
                            try {
                                bank.transfer(String.valueOf(j), String.valueOf(j+1), amount);
                                System.out.println(Thread.currentThread().getName());
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
            );
        }
        System.out.println("Сумма в банке на всех счетах - " + bank.getSumAllAccounts());
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Сумма в банке на всех счетах - " + bank.getSumAllAccounts());
    }
}