package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * Solar system class that creates a universe
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class SolarSystem implements Parcelable {
    private String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private PriceResources resources;
    private Events event;
    private Random rand;

    public SolarSystem(String name) {
        this.name = name;
    }

    public SolarSystem(String name, int x, int y, TechLevel techLevel, PriceResources resources) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.resources = resources;
        //get list of random events
        //if(random)
        //event = random event
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

    public Events getRandEvent() {
        List<Events> list = Arrays.asList(Events.values());
        return list.get((int) (Math.random()*list.size()));
    }

    public Resources getRandResource() {
        List<Resources> list = Arrays.asList(Resources.values());
        return list.get((int) (Math.random()*list.size()));
    }

    @Override
    public String toString() {
        return String.format("Planet Name: %s \n", name);
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
