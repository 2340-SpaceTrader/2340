package edu.gatech.cs2340.spacetrader.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import edu.gatech.cs2340.spacetrader.models.PriceResources;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.TechLevel;

public class CreateUniverse implements Parcelable {
    private SolarSystem solarSystem;

    private Random rand = new Random();
    public CreateUniverse() {
    }

    protected CreateUniverse(Parcel in) {
        solarSystem = in.readParcelable(SolarSystem.class.getClassLoader());
    }

    public static final Creator<CreateUniverse> CREATOR = new Creator<CreateUniverse>() {
        @Override
        public CreateUniverse createFromParcel(Parcel in) {
            return new CreateUniverse(in);
        }

        @Override
        public CreateUniverse[] newArray(int size) {
            return new CreateUniverse[size];
        }
    };

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

        ArrayList<PriceResources> resourcesList = new ArrayList<>();
        resourcesList.add(PriceResources.Never);
        resourcesList.add(PriceResources.MineralRich);
        resourcesList.add(PriceResources.MineralPoor);
        resourcesList.add(PriceResources.Desert);
        resourcesList.add(PriceResources.LotsOfWater);
        resourcesList.add(PriceResources.RichSoil);
        resourcesList.add(PriceResources.PoorSoil);
        resourcesList.add(PriceResources.RichFauna);
        resourcesList.add(PriceResources.Lifeless);
        resourcesList.add(PriceResources.WeirdMushrooms);
        resourcesList.add(PriceResources.LotsOfHerbs);
        resourcesList.add(PriceResources.Artistic);
        resourcesList.add(PriceResources.Warlike);
        resourcesList.add(PriceResources.Drought);
        resourcesList.add(PriceResources.Cold);
        resourcesList.add(PriceResources.Cropfailure);
        resourcesList.add(PriceResources.War);
        resourcesList.add(PriceResources.Boredom);
        resourcesList.add(PriceResources.Plague);
        resourcesList.add(PriceResources.Lackofworkers);


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
            SolarSystem newSolar = new SolarSystem(name, x, y, techLevel, PriceResources.Never);
            solarList.add(newSolar);
        }
        for (int i = 5; i < 10; i++) {
            int x = arrayListX.get(i);
            int y = arrayListY.get(i);
            String name = solarName.get(i);
            TechLevel techLevel = techLevelList.get((int) (Math.random()*techLevelList.size()));
            PriceResources resources = resourcesList.get((int) (Math.random()*resourcesList.size()));
            SolarSystem newSolar = new SolarSystem(name, x, y, techLevel, resources);
            solarList.add(newSolar);
        }
        return solarList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(solarSystem, flags);
    }
}
