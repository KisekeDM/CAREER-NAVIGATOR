package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUp : AppCompatActivity() {
    lateinit var signupemail: EditText
    lateinit var name: EditText
    lateinit var signuppassword: EditText
    lateinit var confpassword: EditText
    lateinit var signup: Button
    lateinit var login: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        signupemail=findViewById(R.id.email)
        name=findViewById(R.id.name)
        signuppassword=findViewById(R.id.signuppass)
        confpassword=findViewById(R.id.confpass)
        signup=findViewById(R.id.signupbtn)
        login=findViewById(R.id.loginbtn)
        auth= Firebase.auth

        login.setOnClickListener{
            val intent= Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
        signup.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
            SignUpUser()
        }


    }

    private fun SignUpUser(){
        val clientemail=signupemail.text.toString()
        val clientpass=signuppassword.text.toString()
        val confirmpass=confpassword.text.toString()

        if(clientemail.isBlank()|| clientpass.isBlank()|| confirmpass.isBlank()){
            Toast.makeText(this,"Email and Password can't be empty", Toast.LENGTH_LONG).show()
            return
        }else if(clientpass != confirmpass){
            Toast.makeText(this,"Passwords do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(clientemail,clientpass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"Signed Up Successfully", Toast.LENGTH_LONG).show()
                val logo =Intent(this,MainActivity::class.java)
                startActivity(logo)
            }else{
                Toast.makeText(this,"Failed to create", Toast.LENGTH_LONG).show()
            }

        }

    }
}