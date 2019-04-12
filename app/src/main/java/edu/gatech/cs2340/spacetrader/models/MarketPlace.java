package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Marketplace for selling and buying
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class MarketPlace implements Parcelable {
    HashMap<String, Double> buyMap = new HashMap<>();
    HashMap<String, Double> sellMap = new HashMap<>();
    HashMap<String, Integer> quantMap = new HashMap<>();

    private SolarSystem solar;
    private PriceResources priceRes;
    /**
     * Constructor
     * @param solar the planet
     * @param priceRes the price of the resources
     * @return String
     */
    public MarketPlace(SolarSystem solar, PriceResources priceRes) {
        this.solar = solar;
        this.priceRes = priceRes;
        quantityTechLevel(solar);

        for (Resources res : Arrays.asList(Resources.values())) {
            buyMap.putIfAbsent(res.getType(), (double)res.getBasePrice());
        }
        for (Resources res : Arrays.asList(Resources.values())) {
            sellMap.putIfAbsent(res.getType(), (double)res.getBasePrice());
        }
        calculateBuyPrice(priceRes);
        calculateSellPrice(priceRes);
    }
    /**
     * Constructor
     * @param in
     */
    protected MarketPlace(Parcel in) {
        solar = in.readParcelable(SolarSystem.class.getClassLoader());
        buyMap = (HashMap<String, Double>) in.readSerializable();
        sellMap = (HashMap<String, Double>) in.readSerializable();
        quantMap = (HashMap<String, Integer>) in.readSerializable();
        priceRes = (PriceResources) in.readSerializable();
    }

    public static final Creator<MarketPlace> CREATOR = new Creator<MarketPlace>() {
        /**
         * create parcel
         * @param in the in
         * @return String
         */
        @Override
        public MarketPlace createFromParcel(Parcel in) {
            return new MarketPlace(in);
        }
        /**
         * create newArray
         * @param size the size
         * @return array marketplace
         */
        @Override
        public MarketPlace[] newArray(int size) {
            return new MarketPlace[size];
        }
    };
    /**
     * display the cargo type
     * @return String
     */
    public String displayType() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resource(s)");
        sb.append("\n\n");
        for (String res : buyMap.keySet()) {
//            sb.append(res.getType());
            sb.append(res);
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * display the prices of cargo
     * @return String
     */
    public String displayPrice() {
        StringBuilder sb = new StringBuilder();
        sb.append("Price");
        sb.append("\n\n");
        for (String res : buyMap.keySet()) {
            sb.append(buyMap.get(res));
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * display the contents of cargo
     * @return String
     */
    public String displayQuant() {
        StringBuilder sb = new StringBuilder();
        sb.append("Quantity");
        sb.append("\n\n");
        //System.out.printf("%-20s %-20s %s%n", column1, column2, column3);
        for (String res : buyMap.keySet()) {
            //System.out.printf("%-20s %-20.2f %d%n", res.getType(), buyMap.get(res), quantMap.get(res));
            sb.append(quantMap.get(res));
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * sell method
     *
     * @param player the player
     * @param res the res
     * @param cargo the cargo
     * @param count the amount
     * @param priceRes the price res
     * @return cargo
     */
    public Cargo sell(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        if (solar.getTechLevel().getValue() >= res.getMTLP()) {
            calculateSellPrice(priceRes);
            cargo.removeCargo(res, count);
            if (buyMap.keySet().contains(res.getType())) {
                player.setCredits(player.getCredits() + sellMap.get(res.getType())*count);
                quantMap.put(res.getType(), quantMap.get(res.getType()) + count);
            } else {
                throw new NoSuchElementException("Cannot sell input resource on this planet");
            }
        } else {
            throw new IllegalArgumentException("This solar system’s tech level is below the requirement");
        }
        return cargo;
    }
    /**
     * buy method
     *
     * @param player the player
     * @param res the res
     * @param cargo the cargo
     * @param count the amount
     * @param priceRes the price res
     * @return cargo
     */
    public Cargo buy(player player, Resources res, Cargo cargo, int count, PriceResources priceRes) {
        if (solar.getTechLevel().getValue() >= res.getMTLP()) {
            calculateBuyPrice(priceRes);

<<<<<<< HEAD
            if (buyMap.keySet().contains(res.getType()) && player.getCredits() >= buyMap.get(res.getType())*count) {
                if (count > quantMap.get(res.getType())) {
                    throw new IllegalArgumentException("Insufficient resource to buy");
=======
            if (buyMap.keySet().contains(res) && player.getCredits() >= buyMap.get(res)*count) {
                if (count > quantMap.get(res)) {
                    throw new IllegalArgumentException("Insufficient number of specific resource available for purchase");
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
                }
                cargo.addCargo(res, count);
                player.setCredits(player.getCredits() - buyMap.get(res.getType())*count);
                quantMap.put(res.getType(), quantMap.get(res.getType()) - count);
            } else if (player.getCredits() < buyMap.get(res.getType())*count) {
                throw new IllegalArgumentException("Not enough credits");
            } else {
                throw new NoSuchElementException("The resource is not available");
            }
        } else {
            throw new IllegalArgumentException("This solar system’s tech level is below the requirement");
        }
        return cargo;
    }
    /**
     * calculate prices
     * @param change the price
     *
     */
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
        for (String item : buyMap.keySet()) {
            List<Resources> list = Arrays.asList(Resources.values());
            Resources check = null;
            for (Resources res : list) {
                if (item.equals(res.getType())) {
                    check = res;
                }
            }
            double price = (check.getBasePrice()) + (check.getIPL() *
                    (solar.getTechLevel().getValue() - check.getMTLP())) + (check.getVariance());
            if (check.getiE().equals(change.getTypePrice()) ||
                    check.getcR().equals(change.getTypePrice()) ||
                    check.geteR().equals(change.getTypePrice())) {
                    price = price * increase;
            }
            buyMap.put(item, price);
        }
    }
    /**
     * calc some stuff
     * @param change price changes
     *
     */
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
        for (String item : sellMap.keySet()) {
            List<Resources> list = Arrays.asList(Resources.values());
            Resources check = null;
            for (Resources res : list) {
                if (item.equals(res.getType())) {
                    check = res;
                }
            }

            double price = (check.getBasePrice()) + (check.getIPL() *
                    (solar.getTechLevel().getValue() - check.getMTLP())) + (check.getVariance());
            price = price * increase;
            sellMap.put(item, price);
        }
    }
    /**
     * Tech level quantity
     * @param solar the system
     *
     */
    public void quantityTechLevel(SolarSystem solar) {
        List<Resources> list = Arrays.asList(Resources.values());
        for (Resources res : list) {
            if (res.getTTP() == solar.getTechLevel().getValue()) {
                quantMap.putIfAbsent(res.getType(), 50);
            } else {
                quantMap.putIfAbsent(res.getType(), 10);
            }
        }
    }
    /**
     * describe contents
     * @return num
     */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * write to Parcel
     *
     * @param dest location
     * @param flags the flag
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(solar, flags);
        dest.writeSerializable(buyMap);
        dest.writeSerializable(sellMap);
        dest.writeSerializable(quantMap);
        dest.writeSerializable(priceRes);
    }

}