package edu.gatech.cs2340.spacetrader.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.TechLevel;

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

        ArrayList<TechLevel> techLevelList = new ArrayList<>();
        techLevelList.add(TechLevel.PreAgriculture);
        techLevelList.add(TechLevel.Agriculture);
        techLevelList.add(TechLevel.Medieval);
        techLevelList.add(TechLevel.Renaissance);
        techLevelList.add(TechLevel.EarlyIndustrial);
        techLevelList.add(TechLevel.Industrial);
        techLevelList.add(TechLevel.PostIndustrial);
        techLevelList.add(TechLevel.HiTech);

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
        for (int i = 0; i < 5; i++) {
            int x = arrayListX.get(i);
            int y = arrayListY.get(i);
            String name = solarName.get(i);
            TechLevel techLevel = techLevelList.get((int) (Math.random()*techLevelList.size()));
            SolarSystem newSolar = new SolarSystem(name, x, y, techLevel, "NOSPECIALRESOURCES");
            solarList.add(newSolar);
        }
        for (int i = 5; i < 10; i++) {
            int x = arrayListX.get(i);
            int y = arrayListY.get(i);
            String name = solarName.get(i);
            TechLevel techLevel = techLevelList.get((int) (Math.random()*techLevelList.size()));
            String resources = resourcesList.get((int) (Math.random()*techLevelList.size()));
            SolarSystem newSolar = new SolarSystem(name, x, y, techLevel, resources);
            solarList.add(newSolar);
        }
        return solarList;
    }
}
