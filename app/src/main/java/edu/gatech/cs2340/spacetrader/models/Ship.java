package edu.gatech.cs2340.spacetrader.models;
public class Ship {
    private int spaceCapacity;
    private ShipType ship_type;
    //no arg constructor
    public Ship() {
        ship_type = ShipType.GnatSpaceShip;
        Cargo storage = new Cargo(ship_type.spaceCapacity());
    }

    public ShipType getShipType() {
        return ship_type;
    }



}
