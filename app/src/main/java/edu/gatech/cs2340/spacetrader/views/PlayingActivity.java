package edu.gatech.cs2340.spacetrader.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

//import edu.gatech.cs2340.spacetrader.MainActivity;
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.MarketPlace;
import edu.gatech.cs2340.spacetrader.models.SolarSystem;
import edu.gatech.cs2340.spacetrader.models.player;
import edu.gatech.cs2340.spacetrader.viewmodel.CreateUniverse;

public class PlayingActivity extends AppCompatActivity {
    MarketPlace marketPlace;
    SolarSystem planet;
    private player player;
    ArrayList<SolarSystem> solarList;
    private Context mContext;
    private FirebaseDatabase mDatabase;
    private DatabaseReference db;
    private DataSnapshot snapshot1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);
        getIncomingIntent();
        Button market = findViewById(R.id.market_button);
        Button travel = findViewById(R.id.travel_button);
        TextView status = findViewById(R.id.player_status);
        Button back = findViewById(R.id.back);
        Button save = findViewById(R.id.save);

        mDatabase = FirebaseDatabase.getInstance();
        db = mDatabase.getReference("player");
        mContext = this;

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
                intent.putExtra("planet", planet);
                intent.putExtra("player", player);
                intent.putExtra("solarList", solarList);
                startActivity(intent);
            }
        });

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                CreateUniverse universe = new CreateUniverse();
//                ArrayList<SolarSystem> solarList = new ArrayList<>(universe.create());
//                planet = solarList.get(0);
                planet = player.getPlanet();
                marketPlace = new MarketPlace(player.getPlanet(), player.getPlanet().getPriceResources());

                Intent intent = new Intent(PlayingActivity.this, MarketActivity.class);
                intent.putExtra("player", player);
                intent.putExtra("marketPlace", marketPlace);
                intent.putExtra("planet", planet);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                for(DataSnapshot snapshot : snapshot1.getChildren()) {
//                    DatabaseReference db = FirebaseDatabase.getInstance().getReference(snapshot.getKey());
//                }
//
//                db.setValue(snapshot.getKey());

                updatePlayer("player");
//                DatabaseReference db = FirebaseDatabase.getInstance().getReference("player");
//                String newKey = mDatabase.getReference().child("player").push().getKey();
//                db.child(newKey).setValue(player).addOnCompleteListener((Activity) mContext, new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        Intent intent = new Intent(mContext, MainActivity.class);
//                        intent.putExtra("player", player);
//                        intent.putExtra("marketPlace", marketPlace);
//                        intent.putExtra("planet", planet);
//                        intent.putExtra("solarList", solarList );
//                        startActivity(intent);
//                    }
//                });
//                Toast.makeText(getApplicationContext(),"Successfully saved",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void updatePlayer(String id) {

        DatabaseReference db = FirebaseDatabase.getInstance().getReference(id);
        //DatabaseReference ship = FirebaseDatabase.getInstance().getReference("player").child("ship").child("cargo");
//        ship.setValue(player.getShip().getCargoStorage());
        db.setValue(player);
//        ship.setValue(player.getShip().getCargoStorage());
//        db.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()) {
//                    if (snapshot1.getKey().equals(itemId)) {
//                        for (DataSnapshot snapshot : snapshot1.getChildren()) {
//                            String key = snapshot.getKey();
//                            String value = "";
//                            if (key.equals("value")) {
//                                value = snapshot.getValue() + "";
//                            } else {
//                                value = (String) snapshot.getValue();
//                            }
//                            mDetails.add(key + ": " + value);
//                        }
//                    }
//
//                }
//                initRecyclerView();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("player")) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            player = getIntent().getParcelableExtra("player");
            System.out.println(player.getName());
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
