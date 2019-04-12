package edu.gatech.cs2340.spacetrader;

import edu.gatech.cs2340.spacetrader.views.RegisterActivity;
import edu.gatech.cs2340.spacetrader.views.SignInActivity;

import edu.gatech.cs2340.spacetrader.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Welcome activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
public class WelcomeActivity extends AppCompatActivity {

    /**
     * creates welcome screen for user
     * @param savedInstanceState Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button signIn = findViewById(R.id.sign_in);
        Button register = findViewById(R.id.register);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}