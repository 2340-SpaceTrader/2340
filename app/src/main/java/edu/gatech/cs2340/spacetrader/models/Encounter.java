package edu.gatech.cs2340.spacetrader.models;

import java.util.Random;

/**
 * Encounter
 */
public class Encounter {
    private static Random rand = new Random();
    private static Mercenaries mercenaries;
    private static Politics politics;
    private static Trader trader;
    private static Pirate pirate;
    private static Police police;
    private static Enum[] encounter;

    //random value
    private static double[] numRand = new double[5];
    private static boolean[] active = new boolean[5];


    /**
     * A random event for encountering people while traveling
     * @param player a player
     * @param planet a planet
     */
    public static void getEncounter(player player, SolarSystem planet) {
        //assigning random values
        for (int i = 0; i < numRand.length; i++) {
            numRand[i] = rand.nextDouble();
            active[i] = false;
        }
        //getting random person
        mercenaries = Mercenaries.getRandMercenaries();
        politics = Politics.getRandPolitics();
        trader = Trader.getRandTrader();
        pirate = Pirate.getRandPirate();
        police = Police.getRandCop();

        //mercenaries
        //steal money or fuel or gives currency
        if(numRand[0] <= .4) {
            active[0] = true;
            encounter[0] = mercenaries;
            if (mercenaries.equals(Mercenaries.BOB)) {
                if (player.getCredits() <= 99) {
                    throw new IllegalArgumentException("Too broke to steal from");
                }
                player.setCredits(player.getCredits() - 100);
            }
            if (mercenaries.equals(Mercenaries.DAVE)) {
                if (player.getFuel() < 50) {
                    player.setFuel(0);
                } else {
                    player.setFuel(player.getFuel() - 50);
                }
            }
            if (mercenaries.equals(Mercenaries.KELY)) {
                player.setCredits(player.getCredits() + 1000);
            }
        }
        //politics
        //give fuel or take fuel or resources
        else if(numRand[1] <= .4) {
            active[1] = true;
            encounter[1] = politics;
            if (politics.equals(Politics.MrOrange)) {
                player.getShip().getCargoStorage().clear();
            }
            if (politics.equals(Politics.MrsBlue)) {
                player.setFuel(player.getFuel() + 50);
            }
            if (politics.equals(Politics.MrRed)) {
                if (player.getFuel() < 50) {
                    player.setFuel(0);
                } else {
                    player.setFuel(player.getFuel() - 50);
                }
            }
        }
        //Trader
        //give resources or steal resources
        else if(numRand[2] <= .4) {
            active[2] = true;
            encounter[2] = trader;
            if (trader.equals(Trader.Trader1)) {
                Resources res = planet.getRandResource();
                player.getShip().getCargoStorage().addCargo(res, 1);
            }
            if (trader.equals(Trader.Trader2)) {
                Resources res = planet.getRandResource();
                player.getShip().getCargoStorage().addCargo(res, 2);
            }
            if (trader.equals(Trader.Trader3)) {
                player.getShip().getCargoStorage().clear();
            }
        }
        //Pirates
        //steal cargo or give cargo
         else if(numRand[3] <= .4) {
            active[3] = true;
            encounter[3] = pirate;
            if (pirate.equals(Pirate.BlackBeard)) {
                player.getShip().getCargoStorage().clear();
            }
            if (pirate.equals(Pirate.JohnnyDepp)) {
                Resources res = planet.getRandResource();
                player.getShip().getCargoStorage().addCargo(res, 1);
            }
            if (pirate.equals(Pirate.RedBeard)) {
                player.getShip().getCargoStorage().clear();
            }
        }
        //police
        //steals money or gives you money
        else if(numRand[4] <= .4) {
            active[4] = true;
            encounter[4] = police;
            if (police.equals(Police.Cop)) {
                player.setCredits(player.getCredits() + 100);
            }
            if (police.equals(Police.GoodCop)) {
               player.setCredits(player.getCredits() + 1000);
            }
            if (police.equals(Police.MeanCop)) {
                if (player.getCredits() <= 99) {
                    throw new IllegalArgumentException("Too broke to steal from");
                }
                player.setCredits(player.getCredits() - 100);
            }
        }

    }

    /**
     * the random
     * @return random numbers
     */
    public static double[] getRand() {
        return numRand;
    }
    /**
     * is its active
     * @return if its active
     */
    public static boolean[] getActive() {
        return active;
    }
    /**
     * the encounter
     * @return the encounter
     */
    public static Enum[] getEncounter() {
        return encounter;
    }
}
