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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance()
        users = db.getReference("Users")

        val registerButton = findViewById<Button>(R.id.regbtn)
        registerButton.setOnClickListener {
            registerUser()
            val intent : Intent = Intent(this, PageMain::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        val emailEditText = findViewById<EditText>(R.id.emailReg)
        val passwordEditText = findViewById<EditText>(R.id.passwordCreate)

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Success")
                } else {
                    println("Sorry, something went wrong")

                }
            }
    }
}
