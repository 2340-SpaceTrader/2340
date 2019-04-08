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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//import edu.gatech.cs2340.spacetrader.MainActivity;
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import edu.gatech.cs2340.spacetrader.models.player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;
import edu.gatech.cs2340.spacetrader.views.AddPlayerActivity;
/**
 * Market activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class MarketActivity extends AppCompatActivity {
    private EditText items;
    private EditText name;
    private EditText count;
    private TextView resources;
    private TextView price;
    private TextView quantity;
    private TextView credit;
    private TextView cargo_capacity;

    private MarketPlace marketPlace;
    private player player;
    private SolarSystem planet;

    /**
     * creates the marketplace for user to buy and sell
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        getIncomingIntent();
        resources = findViewById(R.id.resources);
        price = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        credit = findViewById(R.id.credit);
        cargo_capacity = findViewById(R.id.cargo_capacity);

        Button buyButton = findViewById(R.id.buy_button);
        Button sellButton = findViewById(R.id.sell_button);
        Button backButton = findViewById(R.id.back_button);

        resources.setText(marketPlace.displayType());
        price.setText(marketPlace.displayPrice());
        quantity.setText(marketPlace.displayQuant());
        credit.setText("Credits: " + String.valueOf(player.getCredits()));
        cargo_capacity.setText("Cargo: " + String.valueOf(player.getShip().getCargoStorage().getSize()) + "/" +
                String.valueOf(player.getShip().getCargoStorage().getCapacity()));

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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MarketActivity.this, PlayingActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });

    }

    /**
     * gets the incoming intent
     */
    private void getIncomingIntent() {

        if (getIntent().hasExtra("player")) {
            player = getIntent().getParcelableExtra("player");

        }
        if (getIntent().hasExtra("marketPlace")) {
            marketPlace = getIntent().getParcelableExtra("marketPlace");

        }
        if (getIntent().hasExtra("planet")) {
            planet = getIntent().getParcelableExtra("planet");

        }
    }
}
