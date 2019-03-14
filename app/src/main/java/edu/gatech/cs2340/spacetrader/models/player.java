package edu.gatech.cs2340.spacetrader.models;

import java.util.ArrayList;


public class player {
    private String name;
    private int skillPoints;
    private double credits;
    private Ship ship;
    private gameDifficulty gameDifficulty;
    private ArrayList SPAllocation;



    /**
     * Constructor of a player
     * @param name
     * @param gameDifficulty
     */

    public player(String name, gameDifficulty gameDifficulty) {
        this.name = name;
        this.gameDifficulty = gameDifficulty;
        skillPoints = 16;
        credits = 100000.0;
        ship = new Ship();
        SPAllocation = new ArrayList<Integer>(4);
    }

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


    public Ship getShip() {
        return ship;

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
                "Credits: %d \n ShipType: %s \n" +
                " Pilot points: %d \n Fighter points: %d \n Trader points: %d \n Engineer points: %d \n"
                , name, gameDifficulty.toString(), credits, ship.getShipType().getShipName(), SPAllocation.get(0), SPAllocation.get(1),
                SPAllocation.get(2), SPAllocation.get(3));
    }
}
