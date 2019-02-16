package edu.gatech.cs2340.spacetrader.views;

import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import android.widget.ArrayAdapter;
import android.widget.Button;
import edu.gatech.cs2340.spacetrader.models.player;
import java.util.ArrayList;

public class AddPlayerActivity extends AppCompatActivity {
    private EditText name;
    private EditText pilotPts;
    private EditText engrPts;
    private EditText traderPts;
    private EditText fighterPts;
    private Spinner difficultySpinner;
    private player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        name = findViewById(R.id.student_name_input);
        pilotPts = findViewById(R.id.pilot_points_input);
        engrPts = findViewById(R.id.engineer_points_input);
        traderPts = findViewById(R.id.trader_points_input);
        fighterPts = findViewById(R.id.fighter_points_input);
        difficultySpinner = findViewById(R.id.difficulty_spinner);

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // check to make sure player data is good - viewmodel
                Log.i("Player data:\n", player.toString());
            }
        });

        name.setText(player.getName());
        ArrayList playerPts = player.getSPAllocation();
        pilotPts.setText(String.valueOf(playerPts.get(0)));
        fighterPts.setText(String.valueOf(playerPts.get(1)));
        traderPts.setText(String.valueOf(playerPts.get(2)));
        engrPts.setText(String.valueOf(playerPts.get(3)));

        ArrayAdapter<gameDifficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, gameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);
    }
}
