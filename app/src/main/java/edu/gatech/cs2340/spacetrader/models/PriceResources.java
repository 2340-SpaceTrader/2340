package edu.gatech.cs2340.spacetrader.models;

/**
 * Enum class for prices determination
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public enum PriceResources {
    //expesive
    Desert("Desert", 5.0),
    Lifeless("Lifeless", 5.0),
    PoorSoil("PoorSoil", 5.0),
    MineralPoor("MineralPoor", 5.0),

    //cheap
    LotsOfWater("LotsOfWater", 0.5),
    RichFauna("RichFauna", 0.5),
    RichSoil("RichSoil", 0.5),
    MineralRich("MineralRich", 0.5),
    Artistic("Artistic", 0.5),
    Warlike("Warlike", 0.5),
    LotsOfHerbs("LotsOfHerbs", 0.5),
    WeirdMushrooms("WeirdMushrooms", 0.5),

    //increase event
    Drought("Drought", 10.0),
    Cold("Cold", 10.0),
    Cropfailure("Cropfailure", 10.0),
    War("War", 10.0),
    Boredom("Boredom", 10.0),
    Plague("Plague", 10.0),
    Lackofworkers("Lackofworkers", 10.0),

    //Never
    Never("Nonspecialresources", 1.0);

    final String typePrice;
    final double increase;
    /**
     * Constructor
     * @param typePrice type price
     * @param increase it increase by this value
     */
    PriceResources(String typePrice, double increase) {
        this.typePrice = typePrice;
        this.increase = increase;
    }
    /**
     * get type price
     * @return type price
     */
    public String getTypePrice() {
        return typePrice;
    }
    /**
     * get increase
     * @return increase
     */
    public double getIncrease() {
        return increase;
    }
}
