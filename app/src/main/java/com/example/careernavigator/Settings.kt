package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Settings : AppCompatActivity() {
    lateinit var logout: Button
    lateinit var backbtn: TextView
    lateinit var createprofile: Button
    lateinit var viewprofile: Button
    lateinit var editprofile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        logout=findViewById(R.id.logout)
        backbtn=findViewById(R.id.backbtn)
        createprofile=findViewById(R.id.addprofileButton)
        viewprofile=findViewById(R.id.viewProfileButton)
        editprofile=findViewById(R.id.editProfileButton)

        logout.setOnClickListener {
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
            finish()
        }
        backbtn.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        createprofile.setOnClickListener {
            val intent= Intent(this,CreateProfile::class.java)
            startActivity(intent)
            finish()
        }
        viewprofile.setOnClickListener {
            val intent= Intent(this,UserActivity::class.java)
            startActivity(intent)
            finish()
        }
        editprofile.setOnClickListener {
            val intent= Intent(this,EditProfile::class.java)
            startActivity(intent)
            finish()
        }

    }
}