package edu.gatech.cs2340.spacetrader.models;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Cargo for ship
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class Cargo implements Parcelable {


    private int spaceCapacity;
    private int size;
    private HashMap<Resources, Integer> cargo;
    /**
     * constructor
     *
     * @param spaceCapacity storage
     *
     */
    public Cargo(int spaceCapacity) {
        this.spaceCapacity = spaceCapacity;
        size = 0;
        cargo = new HashMap<>();
    }
    /**
     * constructor
     *
     * @param in value
     *
     */
    protected Cargo(Parcel in) {
        spaceCapacity = in.readInt();
        size = in.readInt();
        cargo = (HashMap<Resources, Integer>) in.readSerializable();
    }

    public static final Creator<Cargo> CREATOR = new Creator<Cargo>() {
        /**
         * Cargo stuff
         * @param in the amount
         * @return cargo
         */
        @Override
        public Cargo createFromParcel(Parcel in) {
            return new Cargo(in);
        }
        /**
         * newArray
         * @param size the amount
         * @return cargo[size]
         */
        @Override
        public Cargo[] newArray(int size) {
            return new Cargo[size];
        }
    };
    /**
     * adds to the cargo
     *
     * @param item Resources type
     * @param count the amount
     *
     */
    public void addCargo(Resources item, int count) {

//        System.out.println("Space: " + occupiedSpace());
        if ((size + count) > spaceCapacity) {
            throw new IllegalArgumentException("Your input surpass the space capacity");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        cargo.putIfAbsent(item, 0);
        cargo.put(item, cargo.get(item) + count);
        size += count;

//        if (cargo.keySet().contains(item)) {
//            int a = cargo.get(item);
//            a += count;
//            cargo.put(item, a);
//            size += count;
//        } else {
//            cargo.putIfAbsent(item, count);
//            size += count;
//        }

    }
    /**
     * removes from cargo
     *
     * @param item Resources type
     * @param count the amount
     *
     */
    public void removeCargo(Resources item, int count) {

//        System.out.println("Space: " + occupiedSpace());
        if (count <= 0) {
             throw new IllegalArgumentException("Invalid input");
        }
         if (!cargo.keySet().contains(item)) {
            throw new java.util.NoSuchElementException("The item does not exists");
        }
        if (cargo.get(item) < count) {
            throw new IllegalArgumentException("Cannot sell more than the amount of item in the cargo");
        }
        cargo.put(item, cargo.get(item) - count);
        size -= count;
    }
    /**
     * returns a list of cargo
     * @return list of cargo
     */
    private ArrayList<String> displayCargo() {
        ArrayList<String> list = new ArrayList<>();
        for (Resources item : cargo.keySet()) {
            list.add(item.getType());
        }
        return list;
    }
    /**
     * clears cargo space
     *
     */
    public void clear() {
        cargo = new HashMap<>();
        size = 0;
    }
    /**
     * constructor
     *
     * @return sum the storage amount
     */
    public int occupiedSpace() {
        int sum = 0;
        for(Resources item : cargo.keySet()) {
            sum += cargo.get(item);
        }
        return sum;
    }
    /**
     * capacity
     * @return space capacity
     */
    public int getCapacity() {
        return spaceCapacity;
    }
    /**
     * size
     * @return the size
     */
    public int getSize() {return size;}
    /**
     * constructor
     *
     * @return cargo
     *
     */
    public HashMap getCargo() {
        return cargo;
    }

    /**
     * a method
     * @return describe contents
     *
     */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * write to parcel
     *
     * @param dest Resources type
     * @param flags the amount
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(spaceCapacity);
        dest.writeInt(size);
        dest.writeSerializable(cargo);
    }
}
