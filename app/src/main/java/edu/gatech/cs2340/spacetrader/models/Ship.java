package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Ship implements Parcelable {
    private ShipType ship_type;
    Cargo storage;
    //no arg constructor
    public Ship() {
        ship_type = ShipType.GnatSpaceShip;
        storage = new Cargo();
    }

    protected Ship(Parcel in) {
        storage = in.readParcelable(Cargo.class.getClassLoader());
        ship_type = (ShipType) in.readSerializable();
    }

    public static final Creator<Ship> CREATOR = new Creator<Ship>() {
        @Override
        public Ship createFromParcel(Parcel in) {
            return new Ship(in);
        }

        @Override
        public Ship[] newArray(int size) {
            return new Ship[size];
        }
    };

    public ShipType getShipType() {
        return ship_type;
    }

    public Cargo getCargoStorage() {return storage; }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(storage, flags);
        dest.writeSerializable(ship_type);
    }
}
