package totaliserAnswers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import totaliserQuestion.Totaliser;

public class TotaliserTest {

    @Test
    public void constructATotaliser(){
        Totaliser total = new Totaliser();
        assertEquals(0, total.getSum());
    }

    @Test
    public void testEnterValue(){
        Totaliser total = new Totaliser();

        total.enterValue(1);
        assertEquals(1, total.getSum());

        total.enterValue(2);
        assertEquals(3, total.getSum());
    }

    @Test
    public void testReset(){
        Totaliser total = new Totaliser();

        total.enterValue(1);
        total.reset();
        assertEquals(0, total.getSum());

        total.enterValue(2);
        total.enterValue(5);
        total.enterValue(7);
        total.reset();
        assertEquals(0, total.getSum());
    }

    @Test
    public void finalTest(){
        Totaliser a = new Totaliser();
        Totaliser b = new Totaliser();

        a.enterValue(1);
        b.enterValue(2);
        assertEquals(1, a.getSum());
        assertEquals(2, b.getSum());
    }
}
