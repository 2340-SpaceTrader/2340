package edu.gatech.cs2340.spacetrader.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import edu.gatech.cs2340.spacetrader.models.SolarSystem;

public class CreateUniverse {
    private SolarSystem solarSystem;

    private Random rand = new Random();
    public CreateUniverse() {
    }

    public ArrayList<SolarSystem> create() {
        ArrayList<SolarSystem> solarList = new ArrayList<>();
        ArrayList<String> solarName = new ArrayList<String>();
        solarName.add("Acamar");
        solarName.add("Brax");
        solarName.add("Calonia");
        solarName.add("Campor");
        solarName.add("Cestus");
        solarName.add("Deneb");
        solarName.add("Endor");
        solarName.add("Exo");
        solarName.add("Jason");
        solarName.add("Lave");

        ArrayList<String> techLevelList = new ArrayList<>();
        techLevelList.add("Pre-Agriculture");
        techLevelList.add("Agriculture");
        techLevelList.add("Medieval");
        techLevelList.add("Renaissance");
        techLevelList.add("Early Industrial");
        techLevelList.add("Industrial");
        techLevelList.add("Post-Industrial");
        techLevelList.add("Hi-Tech");

        ArrayList<String> resourcesList = new ArrayList<>();
        resourcesList.add("NOSPECIALRESOURCES");
        resourcesList.add("MINERALRICH");
        resourcesList.add("MINERALPOOR");
        resourcesList.add("DESERT");
        resourcesList.add("LOTSOFWATER");
        resourcesList.add("RICHSOIL");
        resourcesList.add("POORSOIL");
        resourcesList.add("RICHFAUNA");
        resourcesList.add("LIFELESS");
        resourcesList.add("WEIRDMUSHROOMS");
        resourcesList.add("LOTSOFHERBS");
        resourcesList.add("ARTISTIC");
        resourcesList.add("WARLIKE");

        ArrayList<Integer> arrayListX = new ArrayList<>();
        while (arrayListX.size() < 10) {
            int a = rand.nextInt(149) + 1;
            if (!arrayListX.contains(a)) {
                arrayListX.add(a);
            }
        }

        ArrayList<Integer> arrayListY = new ArrayList<>();
        while (arrayListY.size() < 10) {
            int a = rand.nextInt(99) + 1;
            if (!arrayListY.contains(a)) {
                arrayListY.add(a);
            }
        }

        for (String name : solarName) {
            int x = arrayListX.get((int) (Math.random()*arrayListX.size()));
            int y = arrayListY.get((int) (Math.random()*arrayListY.size()));
            String techLevel = techLevelList.get((int) (Math.random()*techLevelList.size()));
            String resource = resourcesList.get((int) (Math.random()*resourcesList.size())) ;
            SolarSystem newSolar = new SolarSystem(name, x, y, techLevel, resource);
            solarList.add(newSolar);
        }
        return solarList;
    }
}
