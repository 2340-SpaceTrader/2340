package edu.gatech.cs2340.spacetrader.models;
public class Ship {
    private ShipType ship_type;
    Cargo storage;
    //no arg constructor
    public Ship() {
        ship_type = ShipType.GnatSpaceShip;
        storage = new Cargo(ship_type.spaceCapacity());
    }

    public ShipType getShipType() {
        return ship_type;
    }

    public Cargo getCargoStorage() {return storage; }


}
