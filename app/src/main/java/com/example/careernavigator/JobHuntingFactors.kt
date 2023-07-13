package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class JobHuntingFactors : AppCompatActivity() {

    lateinit var backbtn:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_hunting_factors)

        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener{
            val intent= Intent(this,JobSearch::class.java)
            startActivity(intent)
            finish()
        }

    }
}