package edu.gatech.cs2340.spacetrader.JunitTest;
import java.util.NoSuchElementException;
import edu.gatech.cs2340.spacetrader.models.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CargoTest
 */
public class CargoTest {
    Cargo testingCargo = new Cargo(10);

    /**
     * addCargo
     */
    @Test (expected = IllegalArgumentException.class)
    public void addCargo() {
        testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water, 11);
        testingCargo.addCargo(Resources.Water, 0);
        testingCargo.addCargo(Resources.Water, 1);
        assertEquals(1, testingCargo.getCargo().get(Resources.Water.getType()));
        assertEquals(1, testingCargo.getSize());
    }

    /**
     * testRemoveCargo
     */
    @Test
    public void testRemoveCargo() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water, 2);
        testingCargo.removeCargo(Resources.Water, 1);
        assertEquals(1, testingCargo.getSize());
        assertEquals(1, testingCargo.getCargo().get(Resources.Water));
        assertTrue(testingCargo.getCargo().containsKey(Resources.Water));
    }

    /**
     * testNegativeRemoveCargo
     */
    @Test (expected = IllegalArgumentException.class)
    public void testNegativeRemoveCargo() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water, 1);
        testingCargo.removeCargo(Resources.Water, -1);
    }

    /**
     * testRemoveMoreResourceInputRemoveCargo
     */
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveMoreResourceInputRemoveCargo() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water, 1);
        testingCargo.removeCargo(Resources.Water, 3);
    }

    /**
     * testNoSuchElementRemoveCargo
     */
    @Test (expected = NoSuchElementException.class)
    public void testNoSuchElementRemoveCargo() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.removeCargo(Resources.Water, 1);
    }

    /**
     * clear
     */
    @Test
    public void clear() {
        testingCargo.addCargo(Resources.Water,10);
        assertEquals(10, testingCargo.getSize());
        testingCargo.clear();
        assertEquals(0, testingCargo.getSize());
    }

    /**
     * occupiedSpace
     */
    @Test
    public void occupiedSpace() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water,8);
        assertEquals(8, testingCargo.occupiedSpace());
    }

    /**
     * getCapacity
     */
    @Test
    public void getCapacity() {
        Cargo testingCargo = new Cargo(10);
        assertEquals(10, testingCargo.getCapacity());
    }

    /**
     * getSize
     */
    @Test
    public void getSize() {
        Cargo testingCargo = new Cargo(10);
        testingCargo.addCargo(Resources.Water,8);
        assertEquals(8, testingCargo.getSize());
    }



}