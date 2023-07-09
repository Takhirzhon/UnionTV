package com.tokhirzhon.uniontv.ui.main

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tokhirzhon.uniontv.R


open class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var db : FirebaseDatabase = FirebaseDatabase.getInstance()
    var users : DatabaseReference = db.getReference("Users")

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button войти начало
        val voyti = findViewById<Button>(R.id.login)
        voyti.setOnClickListener {
            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
        }//End of buttom Войти

        //Button нет аккаунта начало
        val reg = findViewById<TextView>(R.id.registerAcc)
        reg.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        //button нет аккаунта конец


    }

}
