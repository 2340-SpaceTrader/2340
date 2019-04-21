package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.List;

/**
 * police
 */
public enum Police {
    GoodCop,MeanCop,Cop;

    /**
     * a police
     * @return random police
     */
    public static Police getRandCop() {
        List<Police> list = Arrays.asList(Police.values());
        return list.get((int) (Math.random()*list.size()));
    }
}
