package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

public class SolarSystem implements Parcelable {
    private String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private PriceResources resources;

    public SolarSystem(String name) {
        this.name = name;
    }

    public SolarSystem(String name, int x, int y, TechLevel techLevel, PriceResources resources) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resources = resources;
    }

    protected SolarSystem(Parcel in) {
        name = in.readString();
        x = in.readInt();
        y = in.readInt();
        techLevel = (TechLevel) in.readSerializable();
        resources = (PriceResources) in.readSerializable();
    }

    public static final Creator<SolarSystem> CREATOR = new Creator<SolarSystem>() {
        @Override
        public SolarSystem createFromParcel(Parcel in) {
            return new SolarSystem(in);
        }

        @Override
        public SolarSystem[] newArray(int size) {
            return new SolarSystem[size];
        }
    };

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public void setResources(PriceResources resources) {
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public PriceResources getPriceResources() {
        return resources;
    }

    @Override
    public String toString() {
        return String.format("Planet Name: %s \n At: (%d, %d)", name, x, y);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeSerializable(techLevel);
        dest.writeSerializable(resources);
    }
}
