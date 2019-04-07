package edu.gatech.cs2340.spacetrader.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Resources implements Serializable {
    Water("Water",0,0,2,30,3,4,"Drought", "LotsOfWater", "Dessert",30,50),
    Furs("Furs",0, 0, 0, 250, 10, 10, "Cold", "RichFauna", "Lifeless", 230, 280),
    Food("Food",1, 0,1, 100, 5, 5, "CropFail", "RichSoil", "PoorSoil" ,90, 160),
    Ore("Ore",2, 2, 3, 350, 20, 10, "War", "MineralRich", "MineralPoor", 350, 420),
    Games("Games", 3,1,6,250,-10,5,"Boredom", "Artistic", "Nonspecialresources",160, 270),
    Firearms("Firearms", 3, 1, 5, 1250, -75, 100, "War", "Warlike", "Nonspecialresources", 600, 1100),
    Medicine("Medicine",4, 1, 6, 650, -20, 10,"Plague", "LotsOfHerbs", "Nonspecialresources", 400, 700),
    Machines("Machines",4, 3, 5, 900, -30, 5, "LackOfWorkers", "Nonspecialresources", "Nonspecialresources", 600, 800),
    Narcotics("Narcotics",5, 0, 5, 3500, -125, 150,"Boredom", "WeirdMushrooms", "Nonspecialresources", 2000, 3000),
    Robots("Robots",6, 4, 7, 5000, -150, 100,"LackOfWorkers", "Nonspecialresources", "Nonspecialresources", 3500, 5000);

    String type;
    int mTLP;
    int mTLU;
    int tTP;
    int basePrice;
    int iPL;
    int variance;
    String iE;
    String cR;
    String eR;
    int mTL;
    int mTH;

    Resources(String type, int mTLP, int mTLU, int tTP, int basePrice, int iPL, int variance,String iE, String cR, String eR, int mTL, int mTH) {
    this.type = type;
    this.mTLP = mTLP;
    this.mTLU = mTLU;
    this.tTP = tTP;
    this.basePrice = basePrice;
    this.iPL = iPL;
    this.variance = variance;
    this.iE = iE;
    this.cR = cR;
    this.eR = eR;
    this.mTL = mTL;
    this.mTH = mTH;
    }


    public String getType() {
        return type;
    }
    public int getMTLP() {
        return mTLP;
    }
    public int getMTLU() {
        return mTLU;
    }
    public int getTTP() {
        return tTP;
    }
    public int getBasePrice() {
        return basePrice;
    }
    public int getIPL() {
        return iPL;
    }
    public int getVariance() {
        return variance;
    }
    public int getmTL() {
        return mTL;
    }
    public int getmTH() {
        return mTH;
    }
    public String getiE() {
        return iE;
    }
    public String getcR() {
        return cR;
    }
    public String geteR() {
        return eR;
    }

}
