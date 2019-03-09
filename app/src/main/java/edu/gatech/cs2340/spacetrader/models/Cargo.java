//package edu.gatech.cs2340.lab3newcomponents.entity;
public class Cargo {

    private int spaceCapacity;
    private int size;
    private Resources cargo[];
    public Cargo(int spaceCapacity) {
        this.spaceCapacity = spaceCapacity;
        cargo = new Resources[spaceCapacity];
    }

    public int getCapacity() {
        return spaceCapacity;
    }


    public void addCargo(Resources item) {
        if (cargo.length >= spaceCapacity) {
            for (int i = 0; i < spaceCapacity; i++ ) {
                if(cargo[i] != null) {
                    cargo[i] = item;
                    size++;
                }
            }
        } else {
            System.out.println("Cargo space is full");
        }
    }

    public Resources getResources(Resources item) {
        for (int i = 0; i < spaceCapacity; i++ ) {
            if (cargo[i] != null) {
                if (cargo[i] == item) {
                    return cargo[i];
                }
            }
        }
        return null;
    }


    public Resources removeCargo(Resources item) {
        Resources remove = null;
        if (size != 0) {
            for (int i = 0; i < spaceCapacity; i++ ) {
                if (cargo[i] != null) {
                    if (cargo[i] == item) {
                    remove = cargo[i];
                    cargo[i] = null;
                    size--;
                    return remove;
                    }
                }
            }
        }
        System.out.println("There's nothing left to remove");

        return remove;
    }
    // this returns the current occuiped occupied Space
    // on the space ship
    public int occupiedSpace() {
        return size;
    }



}
