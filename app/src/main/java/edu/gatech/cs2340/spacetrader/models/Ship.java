package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;
/**
 * Ship class holds a player and ship type
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class Ship implements Parcelable {
    private ShipType ship_type;
    private Cargo storage;
    /**
     * Constructor
     * */
    public Ship() {
        ship_type = ShipType.GnatSpaceShip;
        storage = new Cargo(ship_type.spaceCapacity());
    }
    /**
     * constructor
     *
     * @param in the in
     * */
    Ship(Parcel in) {
        storage = in.readParcelable(Cargo.class.getClassLoader());
        ship_type = (ShipType) in.readSerializable();
    }

    public static final Creator<Ship> CREATOR = new Creator<Ship>() {
        /**
         * create parcel
         * @param in a in
         * @return Ship
         * */
        @Override
        public Ship createFromParcel(Parcel in) {
            return new Ship(in);
        }
        /**
         * create new Array
         * @param size a size
         * @return Ship array
         * */
        @Override
        public Ship[] newArray(int size) {
            return new Ship[size];
        }
    };
    /**
     * get ship type
     * @return Ship type
     * */
    public ShipType getShipType() {
        return ship_type;
    }

    /**
     * get Cargo
     * @return Ship
     * */
    public Cargo getCargoStorage() {return storage; }

    /**
     * describe contents
     * @return num
     * */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * write parcel
     * @param dest a dest
     * @param flags a flag
     * */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(storage, flags);
        dest.writeSerializable(ship_type);
    }
}
