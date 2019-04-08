package edu.gatech.cs2340.spacetrader.models;
/**
 * Your implementation of various sorting algorithms.
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
/**
 * Enum class for random events
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public enum Events {
    Stolen_Cargo(10),
    Stolen_Credit(9),
    Leak_Fuel(8),

    Free_Resource(20),
    Free_Credit(19),
    Free_Fuel(18);

    //no_event(21);

    int randomValue;
    Events(int randomValue) {
        this.randomValue = randomValue;
    }
    public int getRandomValue() {
        return randomValue;
    }

}
