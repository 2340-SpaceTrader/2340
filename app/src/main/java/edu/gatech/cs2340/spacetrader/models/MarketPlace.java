package edu.gatech.cs2340.spacetrader.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MarketPlace {
    private HashMap<Resources, Double> buyList;
    private HashMap<Resources, Double> sellList;
    SolarSystem planet;
    public MarketPlace(SolarSystem solar){
    this.planet = solar;
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
            double price = item.getBasePrice() + (item.getIPL()* (planet.getTechLevel().getValue() - item.getMTLP())) + item.getVariance();

        }

        return 0.0;
    }

    public void comparingTechLevel() {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getMTLP() >= planet.getTechLevel().getValue()) {
                buyList.put(res, 0.0);
            }
            if (res.getMTLU() >= planet.getTechLevel().getValue()) {
                sellList.put(res, 0.0);
            }
        }
    }
}
