package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import edu.gatech.cs2340.spacetrader.models.player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;
import edu.gatech.cs2340.spacetrader.viewmodel.Travel;

public class TravelActivity extends AppCompatActivity {
    private Spinner difficultySpinner;
    private player player;
    private Travel go;
    ArrayList<SolarSystem> list;
    private MarketPlace marketPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        getIncomingIntent();

        difficultySpinner = findViewById(R.id.travel_spinner);
        Button ok = findViewById(R.id.ok_button);
        Button back = findViewById(R.id.back_button);
        CreateUniverse universe = new CreateUniverse();
        final ArrayAdapter<SolarSystem> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, universe.create());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go = new Travel();
                try {
                    go.travel(player, (SolarSystem) difficultySpinner.getSelectedItem());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(TravelActivity.this, PlayingActivity.class);
                intent.putExtra("player", player);
//                intent.putExtra("marketPlace", marketPlace);
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
//                intent.putExtra("planet", planet);
                intent.putExtra("list", list);
                startActivity(intent);
            }
        });
    }


    private void getIncomingIntent() {
        if (getIntent().hasExtra("player")) {
            player = getIntent().getParcelableExtra("player");
        }
        if (getIntent().hasExtra("marketPlace")) {
            marketPlace = getIntent().getParcelableExtra("marketPlace");
        }
//        if (getIntent().hasExtra("planet")) {
//            planet = getIntent().getParcelableExtra("planet");
//        }
        if (getIntent().hasExtra("list")) {
            list = getIntent().getParcelableExtra("list");
        }
    }
}
