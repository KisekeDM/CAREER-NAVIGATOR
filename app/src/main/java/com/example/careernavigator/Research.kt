package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Research : AppCompatActivity() {
    lateinit var backbtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_research)

        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener{
            val intent= Intent(this,Careers::class.java)
            startActivity(intent)
            finish()
        }
    }
}