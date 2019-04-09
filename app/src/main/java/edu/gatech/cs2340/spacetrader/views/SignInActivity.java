package edu.gatech.cs2340.spacetrader.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.WelcomeActivity;
import edu.gatech.cs2340.spacetrader.models.user;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Back;
    private int counter = 5;
    private SharedPreferences prefs;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signin);
        prefs = getSharedPreferences("edu.gatech.cs2340.spacetrader.prefs", 0);
        Name = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.signin_button);
        Info = findViewById(R.id.infoTextView);
        Back = findViewById(R.id.back_button);
        mAuth = FirebaseAuth.getInstance();
        Info.setText("Number of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = Name.getText().toString();
                String password = Password.getText().toString();
                if (password.length() == 0 || userName.length() == 0) {
                    Toast.makeText(getApplicationContext(),"Password/Username cannot be empty",Toast.LENGTH_LONG).show();
                    return;
                }
                validate (Name.getText().toString(), Password.getText().toString());
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword) {
        String password = prefs.getString(userName, null);
        mAuth.signInWithEmailAndPassword(userName, userPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                           Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                           startActivity(intent);
                        } else {
                            counter--;
                            Info.setText("Number of attempts " + String.valueOf(counter));
                            Toast.makeText(getApplicationContext(),"Bad Login Attempt",Toast.LENGTH_LONG).show();
                            if(counter == 0) {
                                Login.setEnabled(false);
                            }
                        }
                    }
                });

    }
}