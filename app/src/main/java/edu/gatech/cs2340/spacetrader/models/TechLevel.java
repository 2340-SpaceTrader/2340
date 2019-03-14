package edu.gatech.cs2340.spacetrader.models;

public enum TechLevel {
    PreAgriculture("Pre-Agriculture", 0),
    Agriculture("Agriculture", 1),
    Medieval("Medieval", 2),
    Renaissance("Renaissance", 3),
    EarlyIndustrial("Early Industrial", 4),
    Industrial("Industrial", 5),
    PostIndustrial("Post-Industrial", 6),
    HiTech("Hi-Tech", 7);

    String name;
    int value;
    TechLevel(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}
