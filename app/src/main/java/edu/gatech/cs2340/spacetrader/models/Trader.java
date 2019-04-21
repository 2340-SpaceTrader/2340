package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.List;

public enum Trader {
    Trader1,Trader2, Trader3;

    public static Trader getRandTrader() {
        List<Trader> list = Arrays.asList(Trader.values());
        return list.get((int) (Math.random()*list.size()));
    }

}
