package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MarketPlace implements Parcelable {
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

    protected MarketPlace(Parcel in) {
        solar = in.readParcelable(SolarSystem.class.getClassLoader());
        buyMap = (HashMap<Resources, Double>) in.readSerializable();
        sellMap = (HashMap<Resources, Double>) in.readSerializable();
        quantMap = (HashMap<Resources, Integer>) in.readSerializable();
        priceRes = (PriceResources) in.readSerializable();
    }

    public static final Creator<MarketPlace> CREATOR = new Creator<MarketPlace>() {
        @Override
        public MarketPlace createFromParcel(Parcel in) {
            return new MarketPlace(in);
        }

        @Override
        public MarketPlace[] newArray(int size) {
            return new MarketPlace[size];
        }
    };

    public String displayType() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resource(s)");
        sb.append("\n\n");
        for (Resources res : buyMap.keySet()) {
            sb.append(res.getType());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String displayPrice() {
        StringBuilder sb = new StringBuilder();
        sb.append("Price");
        sb.append("\n\n");
        for (Resources res : buyMap.keySet()) {
            sb.append(buyMap.get(res));
            sb.append("\n");
        }
        return sb.toString();
    }

    public String displayQuant() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quantity");
        sb.append("\n\n");
        //System.out.printf("%-20s %-20s %s%n", column1, column2, column3);
        for (Resources res : buyMap.keySet()) {
            //System.out.printf("%-20s %-20.2f %d%n", res.getType(), buyMap.get(res), quantMap.get(res));
            sb.append(quantMap.get(res));
            sb.append("\n");
        }
        return sb.toString();
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
            if (res.getiE().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.getcR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            } else if (res.geteR().equals(change.getTypePrice())) {
                increase = change.getIncrease();
            }
        }
        for (Resources item : buyMap.keySet()) {
            double price = (item.getBasePrice()) + (item.getIPL() *
                    (solar.getTechLevel().getValue() - item.getMTLP())) + (item.getVariance());
            if (item.getiE().equals(change.getTypePrice()) ||
                    item.getcR().equals(change.getTypePrice()) ||
                    item.geteR().equals(change.getTypePrice())) {
                    price = price * increase;
            }
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
        for (Resources res : list) {
            if (res.getTTP() == solar.getTechLevel().getValue()) {
                quantMap.putIfAbsent(res, 50);
            } else {
                quantMap.putIfAbsent(res, 10);
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(solar, flags);
        dest.writeSerializable(buyMap);
        dest.writeSerializable(sellMap);
        dest.writeSerializable(quantMap);
        dest.writeSerializable(priceRes);
    }

}