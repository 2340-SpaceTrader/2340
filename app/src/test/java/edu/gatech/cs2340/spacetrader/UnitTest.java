package edu.gatech.cs2340.spacetrader;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import edu.gatech.cs2340.spacetrader.models.player;

import java.util.ArrayList;

public class UnitTest {

    private player player = new player("Tester", gameDifficulty.Easy);

    @Test
    public void negativeNumAssertNonNeg16Test() {

        // testing that assertNonNeg16() returns false when one of the Integers is negative
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(-2);
        list1.add(5);
        list1.add(6);

        assertFalse(player.assertNonNeg16(list1));

    }

    @Test
    public void greaterThan16NumAssertNonNeg16Test() {

        // testing that assertNonNeg16() returns false when one of the Integers is greater than 16
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(7);
        list2.add(10);
        list2.add(17);

        assertFalse(player.assertNonNeg16(list2));
    }

    @Test
    public void assertNonNeg16Test() {

        // testing that assertNonNeg16() returns true otherwise
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(1);
        list3.add(0);
        list3.add(16);

        assertTrue(player.assertNonNeg16(list3));
    }
}
