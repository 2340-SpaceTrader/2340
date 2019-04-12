package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;
import java.util.List;

/**
 * Solar system class that creates a universe
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class SolarSystem implements Parcelable {
    private final String name;
    private int x;
    private int y;
    private TechLevel techLevel;
    private PriceResources resources;
<<<<<<< HEAD
    private Events event;
    private Random rand;

    public SolarSystem() {
    }
=======
    // --Commented out by Inspection (4/8/2019 5:11 PM):private Events event;
    // --Commented out by Inspection (4/8/2019 5:11 PM):private Random rand;
    /**
     * Construct
     * @param name the name
     * */
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
    public SolarSystem(String name) {
        this.name = name;
    }
    /**
     * Construct
     * @param name the name
     * @param x the x
     * @param y the y
     * @param techLevel the tech level
     * @param resources the resources
     * */
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
    /**
     * constructor
     * @param in the in
     *  */
    protected SolarSystem(Parcel in) {
        name = in.readString();
        x = in.readInt();
        y = in.readInt();
        techLevel = (TechLevel) in.readSerializable();
        resources = (PriceResources) in.readSerializable();
    }

    public static final Creator<SolarSystem> CREATOR = new Creator<SolarSystem>() {
        /**
         * create parcel
         * @param in the in
         * @return solar system
         * */
        @Override
        public SolarSystem createFromParcel(Parcel in) {
            return new SolarSystem(in);
        }
        /**
         * new Array
         * @param size the size
         * @return solar system
         * */
        @Override
        public SolarSystem[] newArray(int size) {
            return new SolarSystem[size];
        }
    };
// --Commented out by Inspection START (4/8/2019 5:11 PM):
//    /**
//     * set name
//     * @param name the name
//     * */
//    public void setName(String name) {
//        this.name = name;
//    }
// --Commented out by Inspection STOP (4/8/2019 5:11 PM)
// --Commented out by Inspection START (4/8/2019 5:11 PM):
//    /**
//     * set x
//     * @param x the x
//     * */
//    public void setX(int x) {
//        this.x = x;
//    }
// --Commented out by Inspection STOP (4/8/2019 5:11 PM)
// --Commented out by Inspection START (4/8/2019 5:11 PM):
//    /**
//     * set y
//     * @param y the y
//     * */
//    public void setY(int y) {
//        this.y = y;
//    }
// --Commented out by Inspection STOP (4/8/2019 5:11 PM)
// --Commented out by Inspection START (4/8/2019 5:11 PM):
//    /**
//     * set tech level
//     * @param techLevel the tech level
//     * */
//    public void setTechLevel(TechLevel techLevel) {
//        this.techLevel = techLevel;
//    }
// --Commented out by Inspection STOP (4/8/2019 5:11 PM)
// --Commented out by Inspection START (4/8/2019 5:11 PM):
//    /**
//     * set resources
//     * @param resources the resource
//     * */
//    public void setResources(PriceResources resources) {
//        this.resources = resources;
//    }
// --Commented out by Inspection STOP (4/8/2019 5:11 PM)
    /**
     * get name
     * @return  name
     * */
    public String getName() {
        return name;
    }
    /**
     * get x
     * @return x
     * */
    public int getX() {
        return x;
    }
    /**
     * get y
     * @return y
     * */
    public int getY() {
        return y;
    }
    /**
     * get tech level
     * @return tech level
     * */
    public TechLevel getTechLevel() {
        return techLevel;
    }
    /**
     * get resources
     * @return resources
     * */
    public PriceResources getPriceResources() {
        return resources;
    }
    /**
     * get events
     * @return a list of events
     * */
    public Events getRandEvent() {
        List<Events> list = Arrays.asList(Events.values());
        return list.get((int) (Math.random()*list.size()));
    }
    /**
     * get resources
     * @return list resources
     * */
    public Resources getRandResource() {
        List<Resources> list = Arrays.asList(Resources.values());
        return list.get((int) (Math.random()*list.size()));
    }
    /**
     * to String for planet
     * @return toString of the planet name
     * */
    @Override
    public String toString() {
        return String.format("Planet Name: %s \n", name);
    }
    /**
     * describe contents
     * @return num
     * */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * write to pracel
     * @param dest the dest
     * @param  flags the flags
     * */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeSerializable(techLevel);
        dest.writeSerializable(resources);
    }
}
