package com.example.careernavigator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.careernavigator.databinding.ActivityCreateProfileBinding
import com.example.careernavigator.databinding.ActivityUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.StorageReference

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var user:User
    private lateinit var uid : String
    lateinit var give:Button
    lateinit var ppname: TextView
    lateinit var pptel: TextView
    lateinit var ppmail: TextView
    lateinit var backbtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding= ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        give=findViewById(R.id.confirmup)
        ppname=findViewById(R.id.ppname)
        ppmail=findViewById(R.id.ppemail)
        pptel=findViewById(R.id.pptel)
        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener {
            val intent=Intent(this,Settings::class.java)
            startActivity(intent)
            finish()
        }


        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()
        databaseReference =  FirebaseDatabase.getInstance().getReference("Users")
        binding.confirmup.setOnClickListener {
            val reck= Intent(this,EditProfile::class.java)
            startActivity(reck)
        }
        if (uid.isNotEmpty()){
            getUserData()

        }
    }

    private fun getUserData() {
        databaseReference.child(uid).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.getValue(User::class.java)!!
                binding.ppname.setText(user.name)
                binding.ppemail.setText(user.email)
                binding.pptel.setText(user.tel)




            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}