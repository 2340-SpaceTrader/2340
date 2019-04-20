package edu.gatech.cs2340.spacetrader.views

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.*

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import edu.gatech.cs2340.spacetrader.models.user
import edu.gatech.cs2340.spacetrader.R
import edu.gatech.cs2340.spacetrader.WelcomeActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var register: Button
    private lateinit var back: Button
    private lateinit var user: user
    private var mAuth: FirebaseAuth? = null
    private var mDatabase: DatabaseReference? = null
    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mContext = this
        mDatabase = FirebaseDatabase.getInstance().reference
        mAuth = FirebaseAuth.getInstance()
        userName = findViewById<View>(R.id.email_edit_text) as EditText
        password = findViewById<View>(R.id.password_edit_text) as EditText
        register = findViewById<View>(R.id.register_button) as Button
        back = findViewById<View>(R.id.back_button) as Button

        register.setOnClickListener {
            user = user(userName.text.toString(), password.text.toString())
            if (userName.length() == 0 || password.length() == 0) {
                Toast.makeText(this, "Please Enter text in email/password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (user.checkPasswordStrength() <= 1) {
                Toast.makeText(this, "Please Enter a stronger password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth!!.createUserWithEmailAndPassword(user.username, user.password).addOnCompleteListener {
                if (!it.isSuccessful) {
                    Toast.makeText(applicationContext, (it.getException())?.message , Toast.LENGTH_LONG).show()
                    return@addOnCompleteListener

                }
                // else if successful

                Log.d("main", "Successfully created user with uid: $(it.user.id)")
                val userId = mAuth!!.currentUser!!.uid
                user = user(userName.text.toString(), password.text.toString())
                FirebaseDatabase.getInstance().reference.child("users").child(userId).setValue(user)
            }.addOnFailureListener {

            }

            startActivity(Intent(this, MainActivity:: class.java))

            back.setOnClickListener {
                startActivity(Intent(this, WelcomeActivity:: class.java ))
            }


        }
    }
}