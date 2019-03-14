package edu.gatech.cs2340.spacetrader.models;

public enum PriceResources {
    //expesive
    Desert("Expensive", 5.0),
    Lifeless("Expensive", 5.0),
    PoorSoil("Expensive", 5.0),
    MineralPoor("Expensive", 5.0),

    //cheap
    LotsOfWater("Cheap", 0.5),
    RichFauna("Cheap", 0.5),
    RichSoil("Cheap", 0.5),
    MineralRich("Cheap", 0.5),
    Artistic("Cheap", 0.5),
    Warlike("Cheap", 0.5),
    LotsOfHerbs("Cheap", 0.5),
    WeirdMushrooms("Cheap", 0.5),

    //increase event
    Drought("Super Expensive", 10.0),
    Cold("Super Expensive", 10.0),
    Cropfailure("Super Expensive", 10.0),
    War("Super Expensive", 10.0),
    Boredom("Super Expensive", 10.0),
    Plague("Super Expensive", 10.0),
    Lackofworkers("Super Expensive", 10.0);
    String typePrice;
    double increase;

    PriceResources(String typePrice, double increase) {
        this.typePrice = typePrice;
        this.increase = increase;
    }

    public String getTypePrice() {
        return typePrice;
    }

    public double getIncrease() {
        return increase;
    }
}
