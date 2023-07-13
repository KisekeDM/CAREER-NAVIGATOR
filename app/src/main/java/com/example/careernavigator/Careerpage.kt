package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class Careerpage : AppCompatActivity() {

    lateinit var backbtn:TextView
    lateinit var careers2:CardView
    lateinit var careerdo:CardView
    lateinit var careersdont:CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_careerpage)

        backbtn=findViewById(R.id.backbtn)
        careers2=findViewById(R.id.careers2)
        careerdo=findViewById(R.id.careerdo)
        careersdont=findViewById(R.id.careersdont)

        backbtn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        careers2.setOnClickListener{
            val intent= Intent(this,Careers::class.java)
            startActivity(intent)
            finish()
        }
        careerdo.setOnClickListener{
            val intent= Intent(this,CareerChoosing::class.java)
            startActivity(intent)
            finish()
        }
        careersdont.setOnClickListener{
            val intent= Intent(this,CareerChoosingDonts::class.java)
            startActivity(intent)
            finish()
        }

    }
}