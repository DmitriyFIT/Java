import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

    Bank bank;
    Account accountOne;
    Account accountTwo;
    Account accountThree;

    @Before
    public void setUP() {
        bank = new Bank();
        accountOne = new Account(500_000, "111");
        accountTwo = new Account(1_000_000, "222");
        accountThree = new Account(1_500_000, "333");

        bank.addAccount(accountOne);
        bank.addAccount(accountTwo);
        bank.addAccount(accountThree);
    }

    @Test
    public void testGetSumAllAccounts() {
        long expected = accountOne.getMoney() + accountTwo.getMoney() + accountThree.getMoney();
        long actual = bank.getSumAllAccounts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSumAllAccountsAfterTransfer() throws InterruptedException {
        bank.transfer("111", "222", 100_000);
        long expected = 3_000_000;
        long actual = bank.getSumAllAccounts();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBalanceAfterTransfer() throws InterruptedException {
        bank.transfer("222", "333", 500_000);
        long expected1 = 500_000;
        long actual1 = bank.getBalance("222");
        Assert.assertEquals(expected1, actual1);

        long expected2 = 2_000_000;
        long actual2 = bank.getBalance("333");
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void testGetBalanceAfterWrongSumTransfer() throws InterruptedException {
        bank.transfer("111", "222", 510_000);
        long expected1 = 500_000;
        long actual1 = bank.getBalance("111");
        Assert.assertEquals(expected1, actual1);

        long expected2 = 1_000_000;
        long actual2 = bank.getBalance("222");
        Assert.assertEquals(expected2, actual2);
    }
}
