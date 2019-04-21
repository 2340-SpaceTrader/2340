package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.List;

public enum Politics {
    MrOrange,MrsBlue,MrRed;

    public static Politics getRandPolitics() {
        List<Politics> list = Arrays.asList(Politics.values());
        return list.get((int) (Math.random()*list.size()));
    }
}
