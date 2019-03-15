package edu.gatech.cs2340.spacetrader.models;

import java.io.Serializable;

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
