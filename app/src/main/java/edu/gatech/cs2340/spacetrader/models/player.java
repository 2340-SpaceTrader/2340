package edu.gatech.cs2340.spacetrader.models;

import java.util.ArrayList;

public class player {
    private String name;
    private int skillPoints;
    private int credits;
    private boolean GnatSpaceShip;
    private gameDifficulty gameDifficulty;
    private ArrayList SPAllocation;

    public player(String name, gameDifficulty gameDifficulty) {
        this.name = name;
        this.gameDifficulty = gameDifficulty;
        skillPoints = 16;
        credits =1000;
        GnatSpaceShip = true;
        SPAllocation = new ArrayList<Integer>(3);
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
    public void setName(String name) {
        this.name = name;
    }
    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }
    public void setGameDifficulty(gameDifficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }
    public boolean assertSP(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            if (list.get(i) < 0) {
                throw new IllegalArgumentException("Input cannot be negative");
            }
            sum += list.get(i);
        }
        if (sum == 16) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("Player's name: %s \n Game mode:  \n " +
                "Pilot points: %d \n Fighter points: %d \n Trader points: %d \n Engineer points: %d \n"
                , name, gameDifficulty, SPAllocation.get(0), SPAllocation.get(1),
                SPAllocation.get(2), SPAllocation.get(3));
    }
}
