package edu.gatech.cs2340.spacetrader.models;
public enum Resources {
    Water(0,0,2,30,3,4,30,50),
    Furs(0, 0, 0, 250, 10, 10, 230, 280),
    Food(1, 0,1, 100, 5, 5, 90, 160),
    Ore(2, 2, 3, 350, 20, 10, 350, 420),
    Games(3, 1, 6, 250, -10, 5, 160, 270),
    Firearm(3, 1, 5, 1250, -75, 100, 600, 1100),
    Medicine(4, 1, 6, 650, -20, 10, 400, 700),
    Machines(4, 3, 5, 900, -30, 5, 600, 800),
    Narcotics(5, 0, 5, 3500, -125, 150, 2000, 3000),
    Robots(6, 4, 7, 5000, -150, 100, 3500, 5000);



    int mTLP;
    int mTLU;
    int tTP;
    int basePrice;
    int iPL;
    int variance;
    int mTL;
    int mTH;

    Resources(int mTLP, int mTLU, int tTP, int basePrice, int iPL, int variance,int mTL, int mTH) {
    this.mTLP = mTLP;
    this.mTLU = mTLU;
    this.tTP = tTP;
    this.basePrice = basePrice;
    this.iPL = iPL;
    this.variance = variance;
    this.mTL = mTL;
    this.mTH = mTH;
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

}
