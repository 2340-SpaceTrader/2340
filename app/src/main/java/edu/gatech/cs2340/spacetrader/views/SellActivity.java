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

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.Resources;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;

public class SellActivity extends AppCompatActivity {
    private EditText sellCount;
    private Spinner SellList;
    private player player;
    private MarketPlace marketPlace;
    private SolarSystem planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        getIncomingIntent();

        sellCount = findViewById(R.id.sell_count);
        SellList = findViewById(R.id.sellList_spinner);
        Button okButton = findViewById(R.id.done_button);
        Button backButton = findViewById(R.id.back_button);
        ArrayAdapter<Resources> ResourcesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Resources.values());
        ResourcesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SellList.setAdapter(ResourcesAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellActivity.this, MarketActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
//                finish();
//                System.exit(0);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int numSell = Integer.parseInt(sellCount.getText().toString());
                Resources sellResource = (Resources) SellList.getSelectedItem();

                try {
                    marketPlace.sell(player, sellResource, player.getShip().getCargoStorage(), numSell, planet.getPriceResources());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    return;
                }
                marketPlace.display();
                Intent intent = new Intent(SellActivity.this, MarketActivity.class);
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
//            Log.d("receive Player", "Hello player");
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
