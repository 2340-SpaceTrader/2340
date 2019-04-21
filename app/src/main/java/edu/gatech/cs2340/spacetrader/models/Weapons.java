package edu.gatech.cs2340.spacetrader.models;

public enum Weapons {
TelsaGun("Telsa Gun"),RayGun("Telsa Gun"),BigBoomGun("Telsa Gun"),WeakGun("Telsa Gun");


    private String name;
    /**
     * Constructor
     * @param name a ship
     * */
    Weapons(String name) {
        this.name = name;
    }

    /**
     * gun name
     * @return name
     */
    public String getName() {
        return name;
    }

}
