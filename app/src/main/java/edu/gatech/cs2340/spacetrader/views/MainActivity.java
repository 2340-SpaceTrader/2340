package edu.gatech.cs2340.spacetrader.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

<<<<<<< HEAD
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import edu.gatech.cs2340.spacetrader.R;
=======
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
import edu.gatech.cs2340.spacetrader.WelcomeActivity;
import edu.gatech.cs2340.spacetrader.models.player;

/**
 * The main page
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    private player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button new_game = findViewById(R.id.new_game);
        Button back = findViewById(R.id.back_button);
        Button load_game = findViewById(R.id.load);
        new_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPlayerActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });

        load_game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                final FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference playerDb = database.getReference("player");
//                playerDb.child("player").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//                        player = snapshot.getValue(player.class);
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                    }
//                });

//                playerDb.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                            player = dataSnapshot.getValue(player.class);
//
////                        }
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });

//                System.out.println("--------------------------" + player.getName());

                Intent intent = new Intent(MainActivity.this, LoadGameActivity.class);
                intent.putExtra("player", player);
                startActivity(intent);
            }
        });
    }
}
