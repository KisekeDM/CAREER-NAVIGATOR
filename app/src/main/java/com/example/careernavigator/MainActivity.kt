package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    private lateinit var cardSettings: CardView
    private lateinit var cardJobs: CardView
    private lateinit var cardCareers: CardView
    private lateinit var cardAbout: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardSettings = findViewById(R.id.card_settings)
        cardJobs = findViewById(R.id.card_jobs)
        cardCareers = findViewById(R.id.card_careers)
        cardAbout = findViewById(R.id.card_about)

        cardSettings.setOnClickListener {
            // Handle SETTINGS card click
            val intent= Intent(this,Settings::class.java)
            startActivity(intent)
            finish()
        }

        cardJobs.setOnClickListener {
            // Handle LIST OF EVENTS card click
            val intent= Intent(this,JobSearch::class.java)
            startActivity(intent)
            finish()
        }

        cardCareers.setOnClickListener {
            // Handle PROFILE card click
            val intent= Intent(this,Careerpage::class.java)
            startActivity(intent)
            finish()
        }

        cardAbout.setOnClickListener {
            // Handle CALENDAR card click
            val intent= Intent(this,About::class.java)
            startActivity(intent)
            finish()
        }
    }
}