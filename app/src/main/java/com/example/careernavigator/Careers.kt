package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class Careers : AppCompatActivity() {

    lateinit var backbtn:TextView


    lateinit var account :CardView
    lateinit var architect :CardView
    lateinit var chef :CardView
    lateinit var data :CardView
    lateinit var engineer :CardView
    lateinit var finance :CardView
    lateinit var graphic :CardView
    lateinit var human :CardView
    lateinit var lawyer :CardView
    lateinit var marketing :CardView
    lateinit var med :CardView
    lateinit var nurse :CardView
    lateinit var operations :CardView
    lateinit var pharmacist :CardView
    lateinit var psychology :CardView
    lateinit var research :CardView
    lateinit var sales :CardView
    lateinit var software :CardView
    lateinit var teacher :CardView
    lateinit var web :CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_careers)

        backbtn=findViewById(R.id.backbtn)

        account = findViewById(R.id.accountant)
        architect = findViewById(R.id.architect)
        chef = findViewById(R.id.chef)
        data = findViewById(R.id.data)
        engineer = findViewById(R.id.eng)
        finance = findViewById(R.id.finance)
        graphic = findViewById(R.id.graphic)
        human = findViewById(R.id.hrm)
        lawyer = findViewById(R.id.lawyer)
        marketing = findViewById(R.id.marketing)
        med = findViewById(R.id.med)
        nurse = findViewById(R.id.nurse)
        operations = findViewById(R.id.operations)
        pharmacist = findViewById(R.id.pharmacy)
        psychology = findViewById(R.id.psychologist)
        research = findViewById(R.id.research)
        sales = findViewById(R.id.sales)
        software = findViewById(R.id.softwaredeveloper)
        teacher= findViewById(R.id.teacher)
        web = findViewById(R.id.web)




        backbtn.setOnClickListener {
            val intent= Intent(this,Careerpage::class.java)
            startActivity(intent)
            finish()
        }

        account.setOnClickListener {
            val intent= Intent(this,Accountant::class.java)
            startActivity(intent)
            finish()
        }
        architect.setOnClickListener {
            val intent= Intent(this,Architect::class.java)
            startActivity(intent)
            finish()
        }
        chef.setOnClickListener {
            val intent= Intent(this,Chef::class.java)
            startActivity(intent)
            finish()
        }
        data.setOnClickListener {
            val intent= Intent(this,Data::class.java)
            startActivity(intent)
            finish()
        }
        engineer.setOnClickListener {
            val intent= Intent(this,Engineer::class.java)
            startActivity(intent)
            finish()
        }
        finance.setOnClickListener {
            val intent= Intent(this,Finance::class.java)
            startActivity(intent)
            finish()
        }
        graphic.setOnClickListener {
            val intent= Intent(this,Graphic::class.java)
            startActivity(intent)
            finish()
        }
        human.setOnClickListener {
            val intent= Intent(this,Human::class.java)
            startActivity(intent)
            finish()
        }
        lawyer.setOnClickListener {
            val intent= Intent(this,Lawyer::class.java)
            startActivity(intent)
            finish()
        }
        marketing.setOnClickListener {
            val intent= Intent(this,Marketing::class.java)
            startActivity(intent)
            finish()
        }
        med.setOnClickListener {
            val intent= Intent(this,Med::class.java)
            startActivity(intent)
            finish()
        }
        nurse.setOnClickListener {
            val intent= Intent(this,Nurse::class.java)
            startActivity(intent)
            finish()
        }
        operations.setOnClickListener {
            val intent= Intent(this,Operations::class.java)
            startActivity(intent)
            finish()
        }
        pharmacist.setOnClickListener {
            val intent= Intent(this,Pharmacist::class.java)
            startActivity(intent)
            finish()
        }
        psychology.setOnClickListener {
            val intent= Intent(this,Psychology::class.java)
            startActivity(intent)
            finish()
        }
        research.setOnClickListener {
            val intent= Intent(this,Research::class.java)
            startActivity(intent)
            finish()
        }
        sales.setOnClickListener {
            val intent= Intent(this,Salesrep::class.java)
            startActivity(intent)
            finish()
        }
        software.setOnClickListener {
            val intent= Intent(this,Software::class.java)
            startActivity(intent)
            finish()
        }
        teacher.setOnClickListener {
            val intent= Intent(this,Teacher::class.java)
            startActivity(intent)
            finish()
        }
        web.setOnClickListener {
            val intent= Intent(this,Web::class.java)
            startActivity(intent)
            finish()
        }




    }
}