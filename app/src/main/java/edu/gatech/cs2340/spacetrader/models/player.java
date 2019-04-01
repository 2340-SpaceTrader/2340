package edu.gatech.cs2340.spacetrader.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;


public class player implements Parcelable {
    private String name;
    private int skillPoints;
    private double credits;
    private Ship ship;
    private gameDifficulty gameDifficulty;
    private ArrayList SPAllocation;
    private double fuel;
    private SolarSystem planet;

    /**
     * Constructor of a player
     * @param name
     * @param gameDifficulty
     */

    public player(String name, gameDifficulty gameDifficulty)

    {
        this.name = name;
        this.gameDifficulty = gameDifficulty;
        skillPoints = 16;
        credits = 1000.0;
        ship = new Ship();
        fuel = 200.0;
        SPAllocation = new ArrayList<Integer>(4);
        CreateUniverse universe = new CreateUniverse();
        ArrayList<SolarSystem> solarList = new ArrayList<>(universe.create());
        planet = solarList.get(0);
    }

    protected player(Parcel in) {
        name = in.readString();
        skillPoints = in.readInt();
        credits = in.readDouble();
        ship = in.readParcelable(Ship.class.getClassLoader());
        fuel = in.readDouble();
        gameDifficulty = (gameDifficulty) in.readSerializable();
        planet = in.readParcelable(SolarSystem.class.getClassLoader());
        SPAllocation = (ArrayList<Integer>) in.readSerializable();
    }

    public static final Creator<player> CREATOR = new Creator<player>() {
        @Override
        public player createFromParcel(Parcel in) {
            return new player(in);
        }

        @Override
        public player[] newArray(int size) {
            return new player[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public gameDifficulty getGameDifficulty() {
        return  gameDifficulty;
    }

    public ArrayList getSPAllocation() {
        return SPAllocation;
    }

    public double getCredits() {
        return credits;
    }

    public double getFuel() {
        return fuel;
    }

    public Ship getShip() {
        return ship;

    }

    public SolarSystem getPlanet() {
        return planet;
    }

    public void setPlanet(SolarSystem planet) {
        this.planet = planet;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public void setGameDifficulty(gameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public void setSPAllocation(ArrayList<Integer> list) {
        SPAllocation = list;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }
    /**
     * To check for negative and number bigger than 16
     * @param list
     * @return boolean
     */
    public boolean assertNonNeg16(ArrayList<Integer> list) {
        for(int i = 0; i < 4; i++) {
            if (list.get(i) < 0 || list.get(i) > 16) {
                return false;
            }
        }
        return true;
    }

    /**
     * To check for sum
     * @param list
     * @return boolean
     */

    public boolean assertSum16(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            sum += list.get(i);
        }
        return sum == 16;
    }

    /**
     * To display player's attributes
     * @return String
     */

    @Override
    public String toString() {
        return String.format("Player's name: %s \n Game mode: %s \n " +
                "Credits: %f \n ShipType: %s \n" +
                " Pilot points: %d \n Fighter points: %d \n Trader points: %d \n Engineer points: %d \n"
                , name, gameDifficulty.toString(), credits, ship.getShipType().getShipName(), SPAllocation.get(0), SPAllocation.get(1),
                SPAllocation.get(2), SPAllocation.get(3));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(skillPoints);
        dest.writeDouble(credits);
        dest.writeParcelable(ship, flags);
        dest.writeDouble(fuel);
        dest.writeSerializable(gameDifficulty);
        dest.writeParcelable(planet, flags);
        dest.writeSerializable(SPAllocation);
    }
}
