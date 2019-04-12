package BankAcc;

import bankAccount.BankAccount;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;

    @Before
    public void setUp() {
        this.bankAccount = new BankAccount("Pesho", new BigDecimal(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameThrowException() {
        new BankAccount("Op", new BigDecimal(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameThrowExceptionLength() {
        new BankAccount("Oppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp", new BigDecimal(1000));
    }

    @Test
    public void getName() {
        assertEquals("Pesho", this.bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldBalanceThrowExceptionMussBePositive() {
        new BankAccount("Ivan", new BigDecimal(-10000));
    }

    @Test
    public void getBalance() {
        BigDecimal expected = new BigDecimal(1000);
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test
    public void deposit(){
        bankAccount.deposit( new BigDecimal(100));
        assertEquals(this.bankAccount.getBalance(), new BigDecimal(1100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositThrowExceptionWhenNegative() {
        bankAccount.deposit(new BigDecimal(-400.0));

    }
    @Test(expected = UnsupportedOperationException.class)
    public void depositThrowExceptionWhenZero() {
        bankAccount.deposit(new BigDecimal(0));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawExceptTwo() {
        bankAccount.withdraw(new BigDecimal(-1));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawThrowExcept() {
        bankAccount.withdraw(new BigDecimal(1500));
    }

    @Test
    public void withdraw() {
        bankAccount.withdraw(new BigDecimal(500));
        assertEquals(this.bankAccount.getBalance(), new BigDecimal(500));
    }

    @Test
    public void withdrawCorrectlyAmount() {
        BigDecimal balance = bankAccount.withdraw(new BigDecimal(500));
        assertEquals(balance, new BigDecimal(500));
    }
}