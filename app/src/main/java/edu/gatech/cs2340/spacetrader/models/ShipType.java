package edu.gatech.cs2340.spacetrader.models;

/**
 * enum class for ship types
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public enum ShipType {

    GnatSpaceShip();

    private final String shipName;
    private final int spaceCapacity;
    /**
     * Constructor  */
    ShipType() {
        this.shipName = "GnatSpaceShip";
        this.spaceCapacity = 10;
    }
    /**
     * get ship name
     * @return Ship name
     * */
    public String getShipName() {
        return shipName;
    }
    /**
     * get space Capacity
     * @return space Capacity
     * */
    public int spaceCapacity() {
        return spaceCapacity;
    }

}
