package com.tokhirzhon.uniontv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

open class MainActivity : AppCompatActivity() {

    var auth : FirebaseAuth = FirebaseAuth.getInstance()
    var db : FirebaseDatabase = FirebaseDatabase.getInstance()
    var users : DatabaseReference = db.getReference("Users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val voyti = findViewById<Button>(R.id.login)
        voyti.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }

        val reg = findViewById<TextView>(R.id.registerAcc)
        reg.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }


    }
}
