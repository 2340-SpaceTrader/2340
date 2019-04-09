package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.player;

public class LoadGameActivity extends AppCompatActivity {
    private DatabaseReference playerDb;
    private player player;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerDb = FirebaseDatabase.getInstance().getReference("player");
        setContentView(R.layout.activity_load_game);
        playerDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()) {
                    player = dataSnapshot.getValue(player.class);
                    //player.getShip()
//                    player.getShip().create();
//                    System.out.println("-----------------------------" + player.getPlanet().getPriceResources().getTypePrice();
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button go = findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadGameActivity.this, PlayingActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });
    }
}
