package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

//import edu.gatech.cs2340.spacetrader.MainActivity;
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;

/**
 * Planet activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings({"LongLine", "ChainedMethodCall"})
public class PlayingActivity extends AppCompatActivity {
    private MarketPlace marketPlace;
    private SolarSystem planet;
    private player player;
    private ArrayList<SolarSystem> solarList;

    /**
     * lets the player play the game
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        getIncomingIntent();
        Button market = findViewById(R.id.market_button);
        Button travel = findViewById(R.id.travel_button);
        TextView status = findViewById(R.id.player_status);

        status.setText("Name: " + player.getName() + "\n" +
                "Current fuel: " + player.getFuel() + "\n" +
                "Current planet: " + player.getPlanet().getName() + "\n" +
                "Position: (" + player.getPlanet().getX() + ", " + player.getPlanet().getY() + ")\n" +
                "Tech Level: " + player.getPlanet().getTechLevel() + "\n" +
                "Resources: " + player.getPlanet().getPriceResources());

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final CreateUniverse universe = new CreateUniverse();
//                final ArrayList<SolarSystem> list = new ArrayList<>(universe.create());

//                Bundle extra = new Bundle();
//                extra.putSerializable("list", list);
//
//                Intent intent = new Intent(getBaseContext(), TravelActivity.class);
//                intent.putExtra("extra", extra);

                planet = player.getPlanet();
                Intent intent = new Intent(PlayingActivity.this, TravelActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("solarList", solarList);
                startActivity(intent);
            }
        });

        market.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("LongLine")
            @Override
            public void onClick(View v) {

//                CreateUniverse universe = new CreateUniverse();
//                ArrayList<SolarSystem> solarList = new ArrayList<>(universe.create());
//                planet = solarList.get(0);
                planet = player.getPlanet();
                //noinspection LongLine
                marketPlace = new MarketPlace(player.getPlanet(), player.getPlanet().getPriceResources());

                Intent intent = new Intent(PlayingActivity.this, MarketActivity.class);
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
        if (getIntent().hasExtra("solarList")) {
            solarList = getIntent().getParcelableExtra("solarList");
        }
    }
}
