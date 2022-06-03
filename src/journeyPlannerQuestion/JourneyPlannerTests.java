package journeyPlannerQuestion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class JourneyPlannerTests {

    private JourneyPlannerA a;
    private JourneyPlannerB b;

    @BeforeEach
    public void newPlanner() throws Exception {
        a = new JourneyPlannerA(3);
        b = new JourneyPlannerB(3);
    }

    @Test
    //Both axes incremented positively
    public void normalCase1(){
        a.setOrigin(1, 2);
        a.setDestination(3, 4);
        b.setOrigin(1, 2);
        b.setDestination(3, 4);

        assertEquals(12, a.journeyTime());
        assertEquals(12, b.journeyTime());
    }

    @Test
    // x-axis incremented positively, y-axis incremented negatively
    public void normalCase2(){
        a.setOrigin(5, 5);
        a.setDestination(7, 2);
        b.setOrigin(5, 5);
        b.setDestination(7, 2);
        assertEquals(18, a.journeyTime());
        assertEquals(18, b.journeyTime());
    }

    @Test
    // x-axis incremented negatively, y-axis incremented positively
    public void normalCase3(){
        a.setOrigin(8, 2);
        a.setDestination(6, 5);
        b.setOrigin(8, 2);
        b.setDestination(6, 5);
        assertEquals(18, a.journeyTime());
        assertEquals(18, b.journeyTime());
    }

    @Test
    // long, positive distance on x-axis, no y-axis movement
    public void xBorderPos(){
        a.setOrigin(0, 0);
        a.setDestination(10, 0);
        b.setOrigin(0, 0);
        b.setDestination(10, 0);

        assertEquals(30, a.journeyTime());
        assertEquals(30, b.journeyTime());
    }

    @Test
    //long, positive distance on y-axis, no x-axis movement
    public void yBorderPos(){
        a.setOrigin(0, 0);
        a.setDestination(0, 10);
        b.setOrigin(0, 0);
        b.setDestination(0, 10);

        assertEquals(30, a.journeyTime());
        assertEquals(30, b.journeyTime());
    }

    @Test
    // long, negative distance on x-axis, no y-axis movement
    public void xBorderNeg(){
        a.setOrigin(10, 0);
        a.setDestination(0, 0);
        b.setOrigin(10, 0);
        b.setDestination(0, 0);

        assertEquals(30, a.journeyTime());
        assertEquals(30, b.journeyTime());
    }

    @Test
    //long, negative distance on y-axis, no x-axis movement
    public void yBorderNeg(){
        a.setOrigin(0, 10);
        a.setDestination(0, 0);
        b.setOrigin(0, 10);
        b.setDestination(0, 0);

        assertEquals(30, a.journeyTime());
        assertEquals(30, b.journeyTime());
    }

    @Test
    // origin and destination are the same (no movement)
    public void noMove(){
        a.setOrigin(4, 7);
        a.setDestination(4, 7);
        b.setOrigin(4, 7);
        b.setDestination(4, 7);

        assertEquals(0, a.journeyTime());
        assertEquals(0, b.journeyTime());
    }

    @Test
    // can change origin
    public void changeOrigin(){
        a.setOrigin(0, 0);
        a.setOrigin(1, 1);
        a.setDestination(2, 2);
        b.setOrigin(0, 0);
        b.setOrigin(1, 1);
        b.setDestination(2, 2);

        assertEquals(6, a.journeyTime());
        assertEquals(6, b.journeyTime());
    }

    @Test
    // can change destination
    public void changeDestination(){
        a.setOrigin(5, 5);
        a.setDestination(6, 6);
        a.setDestination(7, 7);
        b.setOrigin(5, 5);
        b.setDestination(6, 6);
        b.setDestination(7, 7);

        assertEquals(12, a.journeyTime());
        assertEquals(12, b.journeyTime());
    }
}
