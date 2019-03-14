package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MarketPlace {
    private HashMap<Resources, Double> buyMap;
    private HashMap<Resources, Double> sellMap;
    private HashMap<Resources, Integer> quantMap;

    private SolarSystem solar;

    public MarketPlace(SolarSystem solar) {
        this.solar = solar;
        quantityTechLevel(solar);
    }

    public void display() {
        String column1 = "Resource(s)";
        String column2 = "Price";
        String column3 = "Quanitity";
        System.out.printf("%-30.30s  %-30.30s %-30.30s /n", column1, column2, column3);
        for (Resources res : buyMap.keySet()) {
            System.out.printf("%-30.30s  %-30.30d %-30.30d /n", res.getType(), buyMap.get(res), quantMap.get(res));
        }
        for (Resources res : sellMap.keySet()) {
            System.out.printf("%-30.30s  %-30.30d %-30.30d /n", res.getType(), sellMap.get(res), quantMap.get(res));
        }
    }

    public Cargo sell(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        comparingSellTechLevel();
        calculateSellPrice(priceRes);
        cargo.removeCargo(res, count);
        if (buyMap.keySet().contains(res)) {
            player.setCredits(player.getCredits() + sellMap.get(res));
            quantMap.put(res, quantMap.get(res) + count);
        } else {
            throw new NoSuchElementException("Cannot sell input resource on this planet");
        }
        return cargo;
    }

    public Cargo buy(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        comparingBuyTechLevel();
        calculateBuyPrice(priceRes);
        cargo.addCargo(res, count);
        if (buyMap.keySet().contains(res) && player.getCredits() >= buyMap.get(res)) {
            player.setCredits(player.getCredits() - buyMap.get(res));
            if (count > quantMap.get(res)) {
                throw new IllegalArgumentException("Insufficient resource to buy");
            }
            quantMap.put(res, quantMap.get(res) - count);
        } else {
            throw new NoSuchElementException("Cannot buy input resource on this planet");
        }
        return cargo;
    }

    public void calculateBuyPrice(PriceResources change) {
        double increase = 0.0;
        if (change == null) {
            increase = 1.0;
        } else if (change.getIncrease() == 10.0) {
            increase = change.getIncrease();
        } else if (change.getIncrease() == 5.0) {
            increase = change.getIncrease();
        } else if (change.getIncrease() == 0.5) {
            increase = change.getIncrease();
        }

        for (Resources item : buyMap.keySet()) {
            double price = (item.getBasePrice()) + (item.getIPL() *
                    (solar.getTechLevel().getValue() - item.getMTLP())) + (item.getVariance());
            price = price * increase;
            buyMap.put(item, price);
        }
    }

    public void calculateSellPrice(PriceResources change) {

        double increase = 0.0;
        if (change == null) {
            increase = 1.0;
        } else if (change.getIncrease() == 10.0) {
            increase = change.getIncrease();
        } else if (change.getIncrease() == 5.0) {
            increase = change.getIncrease();
        } else if (change.getIncrease() == 0.5) {
            increase = change.getIncrease();
        }

        for (Resources item : sellMap.keySet()) {
            double price = (item.getBasePrice()) + (item.getIPL() *
                    (solar.getTechLevel().getValue() - item.getMTLP())) + (item.getVariance());
            price = price * increase;
            sellMap.put(item, price);
        }
    }

    public void comparingBuyTechLevel() {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getMTLP() >= solar.getTechLevel().getValue()) {
                buyMap.put(res, 0.0);
            }
        }
    }

    public void comparingSellTechLevel() {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getMTLU() >= solar.getTechLevel().getValue()) {
                sellMap.put(res, 0.0);
            }
        }
    }

    public void quantityTechLevel(SolarSystem solar) {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getTTP() == solar.getTechLevel().getValue()) {
                quantMap.put(res, 50);
            } else {
                quantMap.put(res, 10);
            }
        }
    }
}