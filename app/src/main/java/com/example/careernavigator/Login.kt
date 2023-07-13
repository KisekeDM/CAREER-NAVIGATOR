package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    lateinit var signupbtn: Button
    lateinit var loginemail: EditText
    lateinit var login1: Button
    lateinit var loginpassword: EditText
    lateinit var retrive: TextView

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signupbtn = findViewById(R.id.signbtn2)
        loginemail = findViewById(R.id.loginemail)
        loginpassword = findViewById(R.id.pass2)
        login1 = findViewById(R.id.loginbtn2)
        retrive=findViewById(R.id.resetpwd)

        auth = FirebaseAuth.getInstance()

        retrive.setOnClickListener {
            val get = Intent(this, ForgotPasssword::class.java)
            startActivity(get)
        }

        signupbtn.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }
        login1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Login()
        }
    }

    private fun Login() {
        val loginemail = loginemail.text.toString()
        val pass2 = loginpassword.text.toString()

        if (loginemail.isBlank() || pass2.isBlank()) {
            Toast.makeText(this, "Email and Password can't be empty", Toast.LENGTH_LONG).show()
            return
        }else if (pass2.isBlank()){
            Toast.makeText(this,"Password Incorrect or Blank",Toast.LENGTH_LONG).show()
            return
        }


        auth.signInWithEmailAndPassword(loginemail, pass2).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_LONG).show()
                val me=Intent(this,MainActivity::class.java)
                startActivity(me)
            } else {
                Toast.makeText(this, "Log In Failed", Toast.LENGTH_LONG).show()
            }

        }
    }




    }
