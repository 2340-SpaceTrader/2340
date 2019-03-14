package edu.gatech.cs2340.spacetrader.models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MarketPlace {
    HashMap<Resources, Double> buyMap = new HashMap<>();
    HashMap<Resources, Double> sellMap = new HashMap<>();
    HashMap<Resources, Integer> quantMap = new HashMap<>();

    private SolarSystem solar;
    private PriceResources priceRes;

    public MarketPlace(SolarSystem solar, PriceResources priceRes) {
        this.solar = solar;
        this.priceRes = priceRes;
        quantityTechLevel(solar);

        for (Resources res : Arrays.asList(Resources.values())) {
            buyMap.putIfAbsent(res, (double)res.getBasePrice());
        }
        for (Resources res : Arrays.asList(Resources.values())) {
            sellMap.putIfAbsent(res, (double)res.getBasePrice());
        }
        calculateBuyPrice(priceRes);
        calculateSellPrice(priceRes);
    }

    public void display() {
        String column1 = "Resource(s)";
        String column2 = "Price";
        String column3 = "Quanitity";
        System.out.printf("%-20s %-20s %s%n", column1, column2, column3);
        for (Resources res : buyMap.keySet()) {
            System.out.printf("%-20s %-20.2f %d%n", res.getType(), buyMap.get(res), quantMap.get(res));
        }
//        for (Resources res : sellMap.keySet()) {
//            System.out.printf("%-20s %-20.2f %d%n", res.getType(), sellMap.get(res), quantMap.get(res));
//        }
    }

    public Cargo sell(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        if (solar.getTechLevel().getValue() >= res.getMTLP()) {
            calculateSellPrice(priceRes);
            cargo.removeCargo(res, count);
            if (buyMap.keySet().contains(res)) {
                player.setCredits(player.getCredits() + sellMap.get(res));
                quantMap.put(res, quantMap.get(res) + count);
            } else {
                throw new NoSuchElementException("Cannot sell input resource on this planet");
            }
        } else {
            throw new IllegalArgumentException("Level Tech of this solar is below the requirement");
        }
        return cargo;
    }

    public Cargo buy(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        if (solar.getTechLevel().getValue() >= res.getMTLP()) {
            calculateBuyPrice(priceRes);
//        System.out.println("Buy Set: " + buyMap.keySet());
//        System.out.println("Water Cost: " + buyMap.get(Resources.Water));
//        System.out.println("Sell Set: " + sellMap.keySet());
//        System.out.println("Credits: " + player.getCredits());
//        System.out.println(quantMap.get(Resources.Water));
            cargo.addCargo(res, count);
            if (buyMap.keySet().contains(res) && player.getCredits() >= buyMap.get(res)) {
                if (count > quantMap.get(res)) {
                    throw new IllegalArgumentException("Insufficient resource to buy");
                }
                player.setCredits(player.getCredits() - buyMap.get(res));
                quantMap.put(res, quantMap.get(res) - count);
            } else if (player.getCredits() < buyMap.get(res)) {
                throw new IllegalArgumentException("Not enough credits");
            } else {
                throw new NoSuchElementException("The resource is not available");
            }
        } else {
            throw new IllegalArgumentException("Level Tech of this solar is below the requirement");
        }
        return cargo;
    }

    public void calculateBuyPrice(PriceResources change) {
        double increase = 1.0;
        for (Resources res : Arrays.asList(Resources.values())) {
//            System.out.println("Check: " + res);
//            System.out.println("Check: " + res.getiE());
//            System.out.println("Check: " + change.getTypePrice());
            if (res.getiE().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.getcR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.geteR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            }
        }
        System.out.println("Increase: " + increase);
        for (Resources item : buyMap.keySet()) {
            double price = (item.getBasePrice()) + (item.getIPL() *
                    (solar.getTechLevel().getValue() - item.getMTLP())) + (item.getVariance());
            if (item.getiE().equals(change.getTypePrice()) ||
                    item.getcR().equals(change.getTypePrice()) ||
                    item.geteR().equals(change.getTypePrice())) {
                    price = price * increase;
            }
            System.out.println("Price: " + price);
            buyMap.put(item, price);
        }
    }

    public void calculateSellPrice(PriceResources change) {
        double increase = 1.0;
        for (Resources res : Arrays.asList(Resources.values())) {
            if (res.getiE().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.getcR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.geteR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            }
        }
        for (Resources item : sellMap.keySet()) {
            double price = (item.getBasePrice()) + (item.getIPL() *
                    (solar.getTechLevel().getValue() - item.getMTLP())) + (item.getVariance());
            price = price * increase;
            sellMap.put(item, price);
        }
    }

    public void quantityTechLevel(SolarSystem solar) {
        List<Resources> list = Arrays.asList(Resources.values());

//        System.out.println(Arrays.toString(list));
//        System.out.println(solar.getTechLevel().getValue());
        for (Resources res : list) {
//            System.out.println(res.getTTP());

            if (res.getTTP() == solar.getTechLevel().getValue()) {
                quantMap.putIfAbsent(res, 50);
            } else {
//                System.out.println(res);
                quantMap.putIfAbsent(res, 10);
            }
        }
    }

//    public static void main(String[] args) {
//        SolarSystem solar = new SolarSystem("Tu", 2, 3, TechLevel.Agriculture, PriceResources.Cold);
//        MarketPlace market = new MarketPlace(solar, solar.getPriceResources());
//        player player = new player("New player", gameDifficulty.Beginner);
//        market.buy(player, Resources.Water, player.getShip().getCargoStorage(), 1, solar.getPriceResources());
//        market.sell(player, Resources.Ore, player.getShip().getCargoStorage(), 1, solar.getPriceResources());
//        market.display();
//    }
}