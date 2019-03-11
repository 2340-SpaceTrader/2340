
import java.util.ArrayList;
//package edu.gatech.cs2340.lab3newcomponents.entity;
public class Cargo {
    public class MapEntry<K, V> {
        private K key;
        private V value;

        private MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int hashsize = 16;
    private int spaceCapacity;
    private int size;
    private MapEntry<Resources, Integer>[]cargo;

    private int hashValue(Integer key) {
        return Math.abs(key.hashCode() % hashsize);
    }
    public void addCargo(Resources item) {
        if (size < spaceCapacity) {
            int keySpot = hashValue(item.getHash());
            MapEntry<Resources,Integer> newValue;
            if (cargo[keySpot] != null) {
                int val = cargo[keySpot].value;
                val = val + 1;
                cargo[keySpot] = new MapEntry<>(item,val);
            } else {
                cargo[keySpot] = new MapEntry<>(item,1);
            }
            size++;
        } else {
            System.out.println("You have no more room in your cargo bay for: " + item);
        }
    }

    public Resources removeCargo(Resources item) {
        int keySpot = hashValue(item.getHash());
        MapEntry<Resources,Integer> newValue;
        Resources remove = null;
        if (cargo[keySpot] != null) {
            int val = cargo[keySpot].value;
            val = val - 1;

            if (val == 0) {
                remove = cargo[keySpot].key;
                cargo[keySpot] = null;
                size--;
            } else if (val > 0) {
                remove = cargo[keySpot].key;
                cargo[keySpot] = new MapEntry<>(item,val);
                size--;
            } else {
                remove = null;
                System.out.println("You can't remove " + item.getType() + " because you have nothing else to sell.");
            }
        } else {
            remove = null;
            System.out.println("You can't remove " + item.getType() + " because you have nothing else to sell.");
        }

        return remove;
    }
    private ArrayList<String> displayCargo() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < hashsize; i++) {
            if (cargo[i] != null) {
                int val = cargo[i].value;
                while(val != 0) {
                    list.add(cargo[i].key.getType());
                    val--;
                }

            }
        }
        return list;
    }



    public Cargo(int spaceCapacity) {
        this.spaceCapacity = spaceCapacity;
        cargo = new MapEntry[hashsize];
        // System.out.println("Water: "+hashValue(Resources.Water.getHash()));
        // System.out.println("Furs: "+hashValue(Resources.Furs.getHash()));
        // System.out.println("Food: "+hashValue(Resources.Food.getHash()));
        // System.out.println("Ore: "+hashValue(Resources.Ore.getHash()));
        // System.out.println("Games: "+hashValue(Resources.Games.getHash()));
        // System.out.println("Firearm: "+hashValue(Resources.Firearm.getHash()));
        // System.out.println("Medicine: "+hashValue(Resources.Medicine.getHash()));
        // System.out.println("Machines: "+hashValue(Resources.Machines.getHash()));
        // System.out.println("Narcotics: "+hashValue(Resources.Narcotics.getHash()));
        // System.out.println("Robots: "+hashValue(Resources.Robots.getHash()));

    }
    public void clear() {
        cargo = new MapEntry[hashsize];
        size = 0;
    }
    public int occupiedSpace() {
        return size;
    }

    public int getCapacity() {
        return spaceCapacity;
    }
    // public Resources getItem(Resources item) {
    //     int keyspot = hashValue(item);
    //     Resources get = null;
    //     if (cargo[keyspot] != null) {
    //         if (cargo[keyspot].val != 0) {
    //             get = cargo[keyspot].key;
    //         }
    //     }
    //     return get;
    // }

    // public static void main(String[] args) {
    //     Cargo ship = new Cargo(10);
    //     ship.addCargo(Resources.Water);
    //     ship.addCargo(Resources.Furs);
    //     ship.addCargo(Resources.Food);
    //     ship.addCargo(Resources.Ore);
    //     ship.addCargo(Resources.Games);
    //     ship.addCargo(Resources.Firearm);
    //     ship.addCargo(Resources.Medicine);
    //     ship.addCargo(Resources.Machines);
    //     ship.addCargo(Resources.Narcotics);
    //     ship.addCargo(Resources.Robots);
    //     ship.addCargo(Resources.Robots);


    //     // System.out.println(ship.getItem(Resources.Robots));
    //     //should have ten items
    //     System.out.println("Should have ten items: "+ship.displayCargo());
    //     //should be ten
    //     System.out.println("size should eqaul 10: "+ship.occupiedSpace());

    //     //clears it
    //     ship.clear();
    //     System.out.println(ship.displayCargo());
    //     System.out.println(ship.occupiedSpace());
    //     for (int i = 0; i < 10; i++) {
    //         ship.addCargo(Resources.Water);
    //     }
    //     System.out.println(ship.displayCargo());
    //     System.out.println(ship.occupiedSpace());
    //     for (int i = 0; i < 10; i++) {
    //         System.out.println("Removed: "+ship.removeCargo(Resources.Water));
    //     }
    //     System.out.println("Should be empty: "+ship.displayCargo());
    //     System.out.println(ship.removeCargo(Resources.Water));
    //     System.out.println(ship.occupiedSpace());


    // }


}
