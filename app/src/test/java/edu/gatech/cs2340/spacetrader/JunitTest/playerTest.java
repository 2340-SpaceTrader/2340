package edu.gatech.cs2340.spacetrader.JunitTest;
import org.junit.Test;
import java.util.ArrayList;
import edu.gatech.cs2340.spacetrader.models.*;
import static org.junit.Assert.*;

/**
 * Player Test
 */
public class playerTest {
    private player playerTest = new player("Christine", gameDifficulty.Easy);

    /**
     * not16SPTest
     */
    @Test
    public void not16SPTest() {
        ArrayList<Integer> falseTest1 = new ArrayList<>(4);
        falseTest1.add(0);
        falseTest1.add(0);
        falseTest1.add(0);
        falseTest1.add(0);

        assertFalse(playerTest.assertSum16(falseTest1));
    }

    /**
     * shortList16SPTest
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void shortList16SPTest() {
        ArrayList<Integer> shortTest = new ArrayList<>(4);
        shortTest.add(1);
        shortTest.add(2);

        playerTest.assertSum16(shortTest);
    }

    /**
     * emptyList16SPTest
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void emptyList16SPTest() {
        ArrayList<Integer> emptyTest = new ArrayList<>(4);

        playerTest.assertSum16(emptyTest);
    }

    /**
     * is16SPTest
     */
    @Test
    public void is16SPTest() {
        ArrayList<Integer> trueTest = new ArrayList<>(4);
        trueTest.add(4);
        trueTest.add(4);
        trueTest.add(4);
        trueTest.add(4);
        assertTrue(playerTest.assertSum16(trueTest));
    }
}