package edu.gatech.cs2340.spacetrader;

import edu.gatech.cs2340.spacetrader.models.player;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

public class AssertSum16Test {

    private ArrayList<Integer> falseTest = new ArrayList<>();
    falseTest.add(0);
    falseTest.add(0);
    falseTest.add(0);
    falseTest.add(0);

    private ArrayList<Integer> trueTest = new ArrayList<>();
    trueTest.add(4);
    trueTest.add(4);
    trueTest.add(4);
    trueTest.add(4);

    @Test
    public void not16SPTest() {
        assertFalse(player.assertSum16(falseTest));
    }

    @Test
    public void is16SPTest() {
        assertTrue(player.assertSum16(trueTest));
    }
}