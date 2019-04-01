package edu.gatech.cs2340.spacetrader.viewmodel;

import android.widget.Spinner;

import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;

public class Travel {
//    private player player;
//    private SolarSystem planet;

//    public Travel(player player, SolarSystem planet) {
//        this.player = player;
//        this.planet = planet;
//    }

    public double calDist(SolarSystem sys1, SolarSystem sys2) {

        return Math.sqrt(Math.pow(sys2.getX() - sys1.getX(), 2) + Math.pow(sys2.getY() - sys1.getY(), 2));
    }
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
        player.setPlanet(planet);
    }

}
