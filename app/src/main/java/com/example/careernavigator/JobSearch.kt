package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class JobSearch : AppCompatActivity() {

    lateinit var backbtn: TextView
    lateinit var factor: CardView
    lateinit var factornot: CardView
    lateinit var websites: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_search)


        factor=findViewById(R.id.factor)
        factornot=findViewById(R.id.factornot)
        websites=findViewById(R.id.websites)
        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        factor.setOnClickListener{
            val intent= Intent(this,JobHuntingFactors::class.java)
            startActivity(intent)
            finish()
        }
        factornot.setOnClickListener{
            val intent= Intent(this,JobHuntingFactorsIgnore::class.java)
            startActivity(intent)
            finish()
        }
        websites.setOnClickListener{
            val intent= Intent(this,Websites::class.java)
            startActivity(intent)
            finish()
        }

    }
}