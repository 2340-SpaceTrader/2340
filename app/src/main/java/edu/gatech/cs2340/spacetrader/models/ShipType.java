package edu.gatech.cs2340.spacetrader.models;

import java.io.Serializable;
/**
 * enum class for ship types
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public enum ShipType implements Serializable {

    GnatSpaceShip("GnatSpaceShip", 10);

    private String shipName;
    private int spaceCapacity;
    /**
     * Constructor
     * @param shipName a ship
     * @param spaceCapacity a ship
     * */
    ShipType(String shipName, int spaceCapacity) {
        this.shipName = shipName;
        this.spaceCapacity = spaceCapacity;
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
