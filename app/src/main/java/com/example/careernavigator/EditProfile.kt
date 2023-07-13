package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.careernavigator.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditProfile : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private lateinit var database: DatabaseReference
    private lateinit var uid : String
    private lateinit var auth: FirebaseAuth
    private lateinit var edit: Button
    lateinit var edfname: EditText
    lateinit var edemail: EditText
    lateinit var edtel: EditText
    lateinit var backbtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        edit=findViewById(R.id.update)
        edfname=findViewById(R.id.upname)
        edemail=findViewById(R.id.upmail)
        edtel=findViewById(R.id.uptel)
        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener {
            val intent=Intent(this,Settings::class.java)
            startActivity(intent)
            finish()
        }



        binding= ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.update.setOnClickListener {
            val name = binding.upname.text.toString()
            val email = binding.upmail.text.toString()
            val tel = binding.uptel.text.toString()


            updatedata(name,email,tel)
        }

    }

    private fun updatedata(name: String, email: String, tel: String) {

        database= FirebaseDatabase.getInstance().getReference("Users")
        val user = mapOf<String,String>(
            "name" to name,
            "email" to email,
            "tel" to tel,

            )
        database.child(uid).updateChildren(user).addOnSuccessListener {
            binding.upname.text.clear()
            binding.upmail.text.clear()
            binding.uptel.text.clear()

            Toast.makeText(this,"Successfully Updated", Toast.LENGTH_SHORT).show()
            val deck= Intent(this,UserActivity::class.java)
            startActivity(deck)
        }.addOnFailureListener{
            Toast.makeText(this,"Failed to Updated", Toast.LENGTH_SHORT).show()
        }
    }
}
