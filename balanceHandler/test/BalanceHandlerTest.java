import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BalanceHandlerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    BalanceHandler setUp(int b){
        BalanceControlSystem bcs = new BalanceControlSystem(b);
        return new BalanceHandler(bcs);
    }

    @Test
    public void handleInput_correct_for_listing(){
        BalanceHandler b = setUp(0);

        b.handleInput("L");

        assertEquals("Your current balance is: 0", outContent.toString().trim());
    }

    @Test
    public void handleInput_correct_for_buying(){
        BalanceHandler b = setUp(0);

        b.handleInput("I5");
        assertEquals("Your balance has been increased by 5", outContent.toString().trim());
    }

    @Test
    public void handleInput_correct_for_selling(){
        BalanceHandler b = setUp(7);
        b.handleInput("S5");
        assertEquals("Your balance has been decreased by 5", outContent.toString().trim());
    }

    @Test
    public void handleInput_correct_for_selling_when_balance_too_low(){
        BalanceHandler b = setUp(3);
        b.handleInput("S5");
        assertEquals("You can not sell 5. You only have 3 available.", outContent.toString().trim());
    }

}
