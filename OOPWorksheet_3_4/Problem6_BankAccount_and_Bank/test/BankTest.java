import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    @Test
    public void testDeposit_valid() {
        BankAccount acc = new BankAccount("Alice", 100.0);
        acc.deposit(50.0);
        assertEquals(150.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testDeposit_negativeIgnored() {
        BankAccount acc = new BankAccount("Bob", 100.0);
        acc.deposit(-20.0);
        assertEquals(100.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_valid() {
        BankAccount acc = new BankAccount("Carol", 200.0);
        acc.withdraw(75.0);
        assertEquals(125.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw_tooMuchIgnored() {
        BankAccount acc = new BankAccount("Dana", 50.0);
        acc.withdraw(100.0);
        assertEquals(50.0, acc.getBalance(), 0.001);
    }

    @Test
    public void testGetTotalDeposits() {
        Bank bank = new Bank();
        bank.addAccount(new BankAccount("Eve", 500.0));
        bank.addAccount(new BankAccount("Frank", 300.0));
        assertEquals(800.0, bank.getTotalDeposits(), 0.001);
    }

    @Test
    public void testGetTotalDeposits_empty() {
        Bank bank = new Bank();
        assertEquals(0.0, bank.getTotalDeposits(), 0.001);
    }
}
