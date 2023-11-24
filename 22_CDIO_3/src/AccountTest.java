import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountTest {
  @Test
  public void testWithdraw () {
    Account account = new Account(1000);
        account.withdraw(200);
        assertEquals(800, account.GetBalance());
    }
    
    @Test

    public void testDeposit() {
        Account account = new Account(1000);
        account.deposit(300);
        assertEquals(1300, account.GetBalance());
    }
}
