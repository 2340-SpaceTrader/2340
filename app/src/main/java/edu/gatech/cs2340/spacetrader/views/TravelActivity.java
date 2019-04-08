package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;
import edu.gatech.cs2340.spacetrader.viewmodel.Travel;
/**
 * travel activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class TravelActivity extends AppCompatActivity {
    private Spinner spinner;
    private player player;
    private Travel go;
    Serializable solarList;
    private MarketPlace marketPlace;

    /**
     * lets player travel in game
     * @param Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        getIncomingIntent();

        spinner = findViewById(R.id.travel_spinner);
        Button ok = findViewById(R.id.ok_button);
        Button back = findViewById(R.id.back_button);
        final CreateUniverse universe = new CreateUniverse();
        final ArrayAdapter<SolarSystem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, universe.create());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go = new Travel();
                try {
                    go.travel(player, (SolarSystem) spinner.getSelectedItem());
                    if (go.getRand() < 0.8) {
                        Toast.makeText(getApplicationContext(), "This random event happened: " + go.getEvent(),Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(TravelActivity.this, PlayingActivity.class);
                intent.putExtra("player", player);
//                intent.putExtra("go", go);
//                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravelActivity.this, PlayingActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("solarList", solarList);
                startActivity(intent);
            }
        });
    }

    /**
     * get incoming player selections for travel
     */
    private void getIncomingIntent() {
        if (getIntent().hasExtra("player")) {
            player = getIntent().getParcelableExtra("player");
        }
        if (getIntent().hasExtra("marketPlace")) {
            marketPlace = getIntent().getParcelableExtra("marketPlace");
        }
//        if (getIntent().hasExtra("universe")) {
//            universe = getIntent().getParcelableExtra("universe");
//        }
        if (getIntent().hasExtra("list")) {
            solarList = getIntent().getParcelableExtra("solarList");
        }
    }
}
