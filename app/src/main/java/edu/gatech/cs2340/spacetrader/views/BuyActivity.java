package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;
/**
 * Buy activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class BuyActivity extends AppCompatActivity {

    private EditText buyCount;
    private Spinner BuyList;
    private MarketPlace marketPlace;
    private player player;
    private SolarSystem planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        getIncomingIntent();

        buyCount = findViewById(R.id.buy_count);
        BuyList = findViewById(R.id.buyList_spinner);
        Button okButton = findViewById(R.id.done_button);
        Button backButton = findViewById(R.id.back_button);
        ArrayAdapter<Resources> ResourcesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Resources.values());
        ResourcesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BuyList.setAdapter(ResourcesAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyActivity.this, MarketActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numBuy = Integer.parseInt(buyCount.getText().toString());
                Resources buyResource = (Resources) BuyList.getSelectedItem();
                try {
                marketPlace.buy(player, buyResource, player.getShip().getCargoStorage(), numBuy, planet.getPriceResources());
                 } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                   return;
                }
                Intent intent = new Intent(BuyActivity.this, MarketActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
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
        if (getIntent().hasExtra("planet")) {
            planet = getIntent().getParcelableExtra("planet");
        }
    }
}
