import org.junit.Test;
import static org.junit.Assert.*;

public class BalanceControlSystemTest {
    
    @Test
    public void get_balance_with_non_zero_startBalance(){
        BalanceControlSystem b = new BalanceControlSystem(5);
        assertEquals(b.getBalance(), 5);
    }

    @Test
    public void get_balance_with_zero_startBalance(){
        BalanceControlSystem b = new BalanceControlSystem(0);
        assertEquals(b.getBalance(), 0);
    }

    @Test
    public void get_balance_with_no_startBalance(){
        BalanceControlSystem b = new BalanceControlSystem();
        assertEquals(b.getBalance(), 0);
    }

    @Test
    public void increaseBalance_updates_balance(){
        BalanceControlSystem b = new BalanceControlSystem();
        b.increaseBalance(5);
        assertEquals(b.getBalance(), 5);
    }

    @Test
    public void decreaseBalance_updates_balance(){
        BalanceControlSystem b = new BalanceControlSystem(5);
        b.decreaseBalance(2);
        assertEquals(b.getBalance(), 3);
    }

    @Test
    public void decreaseBalance_input_too_big_decreases_to_0(){
        BalanceControlSystem b = new BalanceControlSystem(5);
        b.decreaseBalance(7);
        assertEquals(b.getBalance(), 0);
    }

    @Test
    public void canSell_true_when_balance_high_enough(){
        BalanceControlSystem b = new BalanceControlSystem(5);
        assertTrue(b.canSell(3));
    }

    @Test
    public void canSell_false_when_balance_too_low(){
        BalanceControlSystem b = new BalanceControlSystem(5);
        assertFalse(b.canSell(7));
    }
}
