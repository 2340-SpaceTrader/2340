package edu.gatech.cs2340.spacetrader.models;

import java.io.Serializable;
/**
 * enum class for shiptypes
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public enum ShipType implements Serializable {

    GnatSpaceShip("GnatSpaceShip", 10);

    private String shipName;
    private int spaceCapacity;
    ShipType(String shipName, int spaceCapacity) {
        this.shipName = shipName;
        this.spaceCapacity = spaceCapacity;
    }
    public String getShipName() {
        return shipName;
    }
    public int spaceCapacity() {
        return spaceCapacity;
    }

}
