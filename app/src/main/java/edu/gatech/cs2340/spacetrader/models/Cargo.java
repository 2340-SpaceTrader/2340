package edu.gatech.cs2340.spacetrader.models;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Cargo implements Parcelable {


    private int spaceCapacity;
    private int size;
    private HashMap<String, Integer> cargo;

    public Cargo() {
        spaceCapacity = 10;
        size = 0;
        cargo = new HashMap<>();
    }
//    public Cargo(int spaceCapacity) {
//        this.spaceCapacity = spaceCapacity;
//        size = 0;
//        cargo = new HashMap<>();
//    }

    protected Cargo(Parcel in) {
        spaceCapacity = in.readInt();
        size = in.readInt();
        cargo = (HashMap<String, Integer>) in.readSerializable();
    }

    public static final Creator<Cargo> CREATOR = new Creator<Cargo>() {
        @Override
        public Cargo createFromParcel(Parcel in) {
            return new Cargo(in);
        }

        @Override
        public Cargo[] newArray(int size) {
            return new Cargo[size];
        }
    };

    public void addCargo(Resources item, int count) {

//        System.out.println("Space: " + occupiedSpace());
        if ((size + count) > spaceCapacity) {
            throw new IllegalArgumentException("Your input surpass the space capacity");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        cargo.putIfAbsent(item.getType(), 0);
        cargo.put(item.getType(), cargo.get(item.getType()) + count);
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

    public void removeCargo(Resources item, int count) {

//        System.out.println("Space: " + occupiedSpace());
        if (count <= 0) {
             throw new IllegalArgumentException("Invalid input");
        }
         if (!cargo.keySet().contains(item.getType())) {
            throw new java.util.NoSuchElementException("The item does not exists");
        }
        if (cargo.get(item.getType()) < count) {
            throw new IllegalArgumentException("Cannot sell more than the amount of item in the cargo");
        }
        cargo.put(item.getType(), cargo.get(item.getType()) - count);
        size -= count;
    }
    private ArrayList<String> displayCargo() {
        ArrayList<String> list = new ArrayList<>();
        for (String item : cargo.keySet()) {
            list.add(item);
        }
        return list;
    }

    public void clear() {
        cargo = new HashMap<>();
        size = 0;
    }
    public int occupiedSpace() {
        int sum = 0;
        for(String item : cargo.keySet()) {
            sum += cargo.get(item);
        }
        return sum;
    }

    public int getCapacity() {
        return spaceCapacity;
    }

    public int getSize() {return size;}

    public HashMap getCargo() {
        return cargo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(spaceCapacity);
        dest.writeInt(size);
        dest.writeSerializable(cargo);
    }
}
