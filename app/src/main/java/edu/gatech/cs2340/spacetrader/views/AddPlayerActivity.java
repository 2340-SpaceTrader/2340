package edu.gatech.cs2340.spacetrader.views;

import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import edu.gatech.cs2340.spacetrader.R;

public class AddPlayerActivity extends AppCompatActivity {
    private EditText name;
    private EditText pilotPts;
    private EditText engrPts;
    private EditText tradePts;
    private EditText fighterPts;
    private Spinner difficultySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
    }
}