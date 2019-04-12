package edu.gatech.cs2340.spacetrader.viewmodel;

import java.util.Random;

import edu.gatech.cs2340.spacetrader.models.Events;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;
/**
 * Travels to anoter planet
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class Travel {
//    private player player;
//    private SolarSystem planet;

//    public Travel(player player, SolarSystem planet) {
//        this.player = player;
//        this.planet = planet;
//    }
    private Random rand = new Random();
    private Events event;
    private double numRand;
    /**
     * calculates distance between planets
     * @param sys1 solar system 1
     * @param sys2 solar system 2
     * @return double of distance between two planets
     */
    public double calDist(SolarSystem sys1, SolarSystem sys2) {

        return Math.sqrt(Math.pow(sys2.getX() - sys1.getX(), 2)
                + Math.pow(sys2.getY() - sys1.getY(), 2));
    }
    /**
     * travel between planets
     * @param player player
     * @param planet planet
     * @return lets player travel to planet
     */
    public void travel(player player, SolarSystem planet) {
        double dist = calDist(player.getPlanet(), planet);
        System.out.println(dist);
        if (player.getPlanet().getName().equals(planet.getName())) {
            return;
        }
        if (player.getFuel() < dist ) {
            throw new IllegalArgumentException("Not enough fuel to travel");
        }
        player.setFuel(player.getFuel() - dist);
        System.out.println("+++++++++++++++++++++" + player.getPlanet().getName());
        player.setPlanet(planet);
        System.out.println("------------------" + player.getPlanet().getName());
        event = planet.getRandEvent();
        numRand = rand.nextDouble();
        if (numRand < 0.8) {
            if (event.equals(Events.Stolen_Cargo)) {
                player.getShip().getCargoStorage().clear();
            } else if (event.equals(Events.Free_Resource)) {
//                for (Resources res : player.getShip().getCargoStorage().getCargo().keySet());
                Resources res = planet.getRandResource();
                player.getShip().getCargoStorage().addCargo(res, 1);
            } else if (event.equals(Events.Stolen_Credit)) {
                if (player.getCredits() <= 99) {
                    throw new IllegalArgumentException("Too broke to steal from");
                }
                player.setCredits(player.getCredits() - 100);
            } else if (event.equals(Events.Free_Credit)) {
                player.setCredits(player.getCredits() + 100);
            } else if (event. equals(Events.Leak_Fuel)) {
                if (player.getFuel() < 50) {
                    player.setFuel(0);
                } else {
                    player.setFuel(player.getFuel() - 50);
                }
            } else if (event.equals(Events.Free_Fuel)) {
                    player.setFuel(player.getFuel() + 50);
            }
        }
    }

    /**
     * get event
     * @return event
     */
    public Events getEvent() {
        return event;
    }
    /**
     * get random number
     * @return random number
     */
    public double getRand() {
        return numRand;
    }

}
