package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.List;

public enum Mercenaries {
    BOB,DAVE,KELY;


    public static Mercenaries getRandMercenaries() {
        List<Mercenaries> list = Arrays.asList(Mercenaries.values());
        return list.get((int) (Math.random()*list.size()));
    }
}
