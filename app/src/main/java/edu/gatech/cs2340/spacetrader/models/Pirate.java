package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.List;

public enum Pirate {
BlackBeard,JohnnyDepp,RedBeard;

    public static Pirate getRandPirate() {
        List<Pirate> list = Arrays.asList(Pirate.values());
        return list.get((int) (Math.random()*list.size()));
    }
}
