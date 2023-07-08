package com.tokhirzhon.uniontv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseDatabase
    private lateinit var users: DatabaseReference

    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
        users = db.getReference("Users")

        val emailEditText = findViewById<EditText>(R.id.emailReg)
        val passwordEditText = findViewById<EditText>(R.id.passwordCreate)

        email = emailEditText.text.toString()
        password = passwordEditText.text.toString()

        val registerButton = findViewById<Button>(R.id.regbtn)
        registerButton.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Success")
                } else {
                    println("Sorry, something went wrong")
                }
            }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in.
        if (auth.currentUser == null) {
            // Not signed in, launch the Sign In activity
            startActivity(Intent(this, LogIn::class.java))
            finish()
        }
    }
}
