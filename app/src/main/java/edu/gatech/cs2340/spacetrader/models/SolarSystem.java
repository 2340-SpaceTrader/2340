package edu.gatech.cs2340.spacetrader.models;

public class SolarSystem {
    private String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private PriceResources resources;

    public SolarSystem(String name) {
        this.name = name;
    }

    public SolarSystem(String name, int x, int y, TechLevel techLevel, PriceResources resources) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resources = resources;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public void setResources(PriceResources resources) {
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public PriceResources getPriceResources() {
        return resources;
    }

    @Override
    public String toString() {
        return String.format("Solar System Name: %s \n At position: (%d, %d) \n Tech Level: %s \n Resources: %s", name, x, y, techLevel.getName(), resources);
    }

}
