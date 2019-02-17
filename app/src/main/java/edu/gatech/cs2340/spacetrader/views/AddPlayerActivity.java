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
import edu.gatech.cs2340.spacetrader.models.gameDifficulty;
import edu.gatech.cs2340.spacetrader.models.player;

/**
 * The Add player page
 */
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

        name = findViewById(R.id.player_name);
        pilotPts = findViewById(R.id.pilot_point);
        engrPts = findViewById(R.id.engineer_point);
        traderPts = findViewById(R.id.trader_point);
        fighterPts = findViewById(R.id.fighter_point);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        Button okButton = findViewById(R.id.ok_button);
        Button exitButton = findViewById(R.id.exit_button);

        ArrayAdapter<gameDifficulty> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,gameDifficulty.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyAdapter);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = new player(name.getText().toString(), (gameDifficulty) difficultySpinner.getSelectedItem());
                ArrayList<Integer> playerPts = new ArrayList<>(4);
                if(name.length() == 0 || pilotPts.length() == 0
                        || fighterPts.length() == 0 || traderPts.length() == 0
                        || engrPts.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Input cannot be blank", Toast.LENGTH_SHORT).show();
                    return;
                }
                playerPts.add(Integer.parseInt(pilotPts.getText().toString()));
                playerPts.add(Integer.parseInt(fighterPts.getText().toString()));
                playerPts.add(Integer.parseInt(traderPts.getText().toString()));
                playerPts.add(Integer.parseInt(engrPts.getText().toString()));
                player.setSPAllocation(playerPts);
                if (!player.assertNonNeg16(playerPts)) {
                    Toast.makeText(getApplicationContext(), "Input cannot be bigger than 16", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!player.assertSum16(playerPts)) {
                    Toast.makeText(getApplicationContext(), "Total skill points cannot be smaller or bigger than 16", Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println(player.toString());
            }
        });

    }

}
