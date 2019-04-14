package edu.gatech.cs2340.spacetrader.models;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;

/**
 * player info
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class player implements Parcelable {
    private String name;
    private int skillPoints;
    private double credits;
    private Ship ship;
    private gameDifficulty gameDifficulty;
    private ArrayList<Integer> SPAllocation;
    private double fuel;
    private SolarSystem planet;
    private CreateUniverse universe;

    public player() {

    }
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
        fuel = 1000.0;
        SPAllocation = new ArrayList<Integer>(4);
        universe = new CreateUniverse();
        universe.create();
        ArrayList<SolarSystem> solarList = universe.getSolarList();

        planet = solarList.get(0);
    }
    /**
     * Constructor of a player
     * @param in the in
     */
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
        /**
         * player
         * @param in the in
         * @return  player
         */
        @Override
        public player createFromParcel(Parcel in) {
            return new player(in);
        }
        /**
         * player array
         * @param size the size
         * @return  array player
         */
        @Override
        public player[] newArray(int size) {
            return new player[size];
        }
    };
    /**
     * getName
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * get skill points
     * @return skill points
     */
    public int getSkillPoints() {
        return skillPoints;
    }
    /**
     * get game difficulty
     * @return game difficulty
     */
    public gameDifficulty getGameDifficulty() {
        return  gameDifficulty;
    }
    /**
     * get SPALL
     * @return Spal location
     */
    public ArrayList getSPAllocation() {
        return SPAllocation;
    }
    /**
     * get credit
     * @return credit
     */
    public double getCredits() {
        return credits;
    }
    /**
     * get fuel
     * @return fuel
     */
    public double getFuel() {
        return fuel;
    }
    /**
     * get ship
     * @return ship
     */
    public Ship getShip() {
        return ship;

    }
    /**
     * get planet
     * @return planet
     */
    public SolarSystem getPlanet() {
        return planet;
    }

    public CreateUniverse getUniverse() {
        return universe;
    }

    public void setUniverse(CreateUniverse universe) {
        this.universe = universe;
    }


    public void setPlanet(SolarSystem planet) {
        this.planet = planet;
    }
    /**
     * set ship
     * @param ship a ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    /**
     * set fuel
     * @param fuel a fuel
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }
    /**
     * set name
     * @param name a name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * set skill points
     * @param skillPoints a skill point
     */
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
    /**
     * set game difficulty
     * @param gameDifficulty game
     */
    public void setGameDifficulty(gameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
    /**
     * set spal list
     * @param list a list
     */
    public void setSPAllocation(ArrayList<Integer> list) {
        SPAllocation = list;
    }
    /**
     * set credits
     * @param credits the credits
     */
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
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("Player's name: %s \n Game mode: %s \n " +
                "Credits: %f \n ShipType: %s \n" +
                " Pilot points: %d \n Fighter points: %d \n Trader points: %d \n Engineer points: %d \n"
                , name, gameDifficulty.toString(), credits, ship.getShipType().getShipName(), SPAllocation.get(0), SPAllocation.get(1),
                SPAllocation.get(2), SPAllocation.get(3));
    }
    /**
     * describe contents
     * @return num
     */
    @Override
    public int describeContents() {
        return 0;
    }
    /**
     * write to parcel
     * @param dest
     * @param flags
     */
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
