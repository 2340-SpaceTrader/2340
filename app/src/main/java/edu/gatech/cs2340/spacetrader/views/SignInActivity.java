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

<<<<<<< HEAD
import edu.gatech.cs2340.spacetrader.R;
import edu.gatech.cs2340.spacetrader.WelcomeActivity;
import edu.gatech.cs2340.spacetrader.models.user;

=======
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

=======
/**
 * sign activity
 *
 * @author Group 46B NO MAC
 * @version 1.0
 */
@SuppressWarnings("ALL")
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
public class SignInActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private Button Back;
    private int counter = 5;
    private SharedPreferences prefs;
    private FirebaseAuth mAuth;

    /**
     * lets user sign in to play
     * @param Bundle savedInstanceState
     */
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_signin);
<<<<<<< HEAD
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
=======

        PD = new ProgressDialog(this);
        PD.setMessage("Loading...");
        PD.setCancelable(true);
        PD.setCanceledOnTouchOutside(false);
        auth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signup_button);
        btnLogin = findViewById(R.id.signin_button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

                try {

                    if (password.length() > 0 && email.length() > 0) {
                        PD.show();
                        auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(
                                                    SignInActivity.this,
                                                    "Authentication Failed",
                                                    Toast.LENGTH_LONG).show();
                                            Log.v("error", task.getResult().toString());
                                        } else {
                                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                        PD.dismiss();
                                    }
                                });
                    } else {
                        Toast.makeText(
                                SignInActivity.this,
                                "Fill All Fields",
                                Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
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

<<<<<<< HEAD
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

=======
    /**
     * makes sure player account is valid
     */
    @Override
    protected void onResume() {
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(SignInActivity.this, MainActivity.class));
            finish();
        }
        super.onResume();
>>>>>>> f7bf939aec99c542d296e9a6f6917eceedebcb81
    }
}