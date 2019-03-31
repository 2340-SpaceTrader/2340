package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gatech.cs2340.spacetrader.MainActivity;
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import edu.gatech.cs2340.spacetrader.models.player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;
import edu.gatech.cs2340.spacetrader.views.AddPlayerActivity;

public class MarketActivity extends AppCompatActivity {
    private EditText items;
    private EditText name;
    private EditText count;

    private MarketPlace marketPlace;
    private player player;
    private SolarSystem planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        getIncomingIntent();

//        items = findViewById(R.id.items_text;
//        name = findViewById(R.id.name.text);
//        count =
        Button buyButton = findViewById(R.id.buy_button);
        Button sellButton = findViewById(R.id.sell_button);

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, SellActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, BuyActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });
    }
    private void getIncomingIntent() {
//        System.out.println("aaaaaaaaaaaasdasdasssssss");
        if (getIntent().hasExtra("player")) {
            player = getIntent().getParcelableExtra("player");
//            Log.d("receive Player", player.toString());
        }
        if (getIntent().hasExtra("marketPlace")) {
            marketPlace = getIntent().getParcelableExtra("marketPlace");
//            Log.d("receive marketPlace", "marketPlace hello");
        }
        if (getIntent().hasExtra("planet")) {
            planet = getIntent().getParcelableExtra("planet");
//            Log.d("receive planet", "planet hello");
        }
    }
}
