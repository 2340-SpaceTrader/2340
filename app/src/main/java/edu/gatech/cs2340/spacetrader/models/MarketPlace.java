package edu.gatech.cs2340.spacetrader.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MarketPlace {
    private HashMap<Resources, Double> buyList;
    private HashMap<Resources, Double> sellList;
    public MarketPlace(){

    }

    public void display() {

    }

    public void sell() {

    }

    public void buy() {

    }

    public double calculatePrice(Enum... E) {
//        30 (the base price) + 3*2 (the IPL * (Planet Tech Level - MTLP)) + (variance)
//        buyList.keySet();
//        sellList.keySet();
        for (Resources item: buyList.keySet()) {
            
        }

        return 0.0;
    }

    public void comparingTechLevel(SolarSystem solar) {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getMTLP() >= solar.getTechLevel().getValue()) {
                buyList.put(res, 0.0);
            }
            if (res.getMTLU() >= solar.getTechLevel().getValue()) {
                sellList.put(res, 0.0);
            }
        }
    }
}
