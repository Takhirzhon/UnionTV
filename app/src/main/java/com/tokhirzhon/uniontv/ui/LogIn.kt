package com.tokhirzhon.uniontv.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.tokhirzhon.uniontv.R

class LogIn : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var usersRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        usersRef = database.getReference("Users")


        if (auth.currentUser != null) {
            Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT).show()
        }

        val voyti = findViewById<Button>(R.id.signInbtn)
        voyti.setOnClickListener {
            signInWithEmail()
        }
    }

    private fun signInWithEmail() {
        val emailEditText = findViewById<EditText>(R.id.emailSignIn)
        val passwordEditText = findViewById<EditText>(R.id.passwordInput)

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent : Intent = Intent(this, PageMain::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Заходите смотреть кино", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this, "Неверные данные или вы не зарегестрированы", Toast.LENGTH_SHORT).show()
                }
            }

    }
}
