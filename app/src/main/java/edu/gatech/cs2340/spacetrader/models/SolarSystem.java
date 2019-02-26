package edu.gatech.cs2340.spacetrader.models;

public class SolarSystem {
    private String name;
    private int x;
    private int y;
    private String techLevel;
    private String resources;

    public SolarSystem(String name) {
        this.name = name;
    }

    public SolarSystem(String name, int x, int y, String techLevel, String resources) {
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

    public void setTechLevel(String techLevel) {
        this.techLevel = techLevel;
    }

    public void setResources(String resources) {
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

    public String getTechLevel() {
        return techLevel;
    }

    public String getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return String.format("Solar System Name: %s \n At position: (%d, %d) \n Tech Level: %s \n Resources: %s", name, x, y, techLevel, resources);
    }

}
