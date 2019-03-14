package edu.gatech.cs2340.spacetrader.models;
import java.util.ArrayList;
import java.util.HashMap;

public class Cargo {
    public Cargo(int spaceCapacity) {
        this.spaceCapacity = spaceCapacity;
        cargo = new HashMap<>();
    }

    private final int hashsize = 16;
    private int spaceCapacity;
    private int size;
    private HashMap<Resources, Integer> cargo;

    private int hashValue(Integer key) {
        return Math.abs(key.hashCode() % hashsize);
    }

    public void addCargo(Resources item, int count) {
        if ((occupiedSpace() + count) > spaceCapacity) {
            throw new IllegalArgumentException("Your input surpass the space capacity");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (cargo.keySet().contains(item)) {
            int a = cargo.get(item);
            a += count;
            cargo.put(item, a);
        } else {
            cargo.putIfAbsent(item, count);
        }

    }

    public void removeCargo(Resources item, int count) {
        if (count <= 0) {
             throw new IllegalArgumentException("Invalid input");
        }
         if (!cargo.keySet().contains(item)) {
            throw new java.util.NoSuchElementException("The item does not exists");
        }
        if (cargo.get(item) < count) {
            throw new IllegalArgumentException("Cannot sell more than the amount of item in the cargo");
        }
        int a = cargo.get(item);
        a -= count;
        cargo.put(item, a);

    }
    private ArrayList<String> displayCargo() {
        ArrayList<String> list = new ArrayList<>();
        for (Resources item : cargo.keySet()) {
            list.add(item.getType());
        }
        return list;
    }

    public void clear() {
        cargo = new HashMap<>();
    }
    public int occupiedSpace() {
        int sum = 0;
        for(Resources item : cargo.keySet()) {
            sum += cargo.get(item);
        }
        return sum;
    }

    public int getCapacity() {
        return spaceCapacity;
    }

}
