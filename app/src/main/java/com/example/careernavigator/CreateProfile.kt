package com.example.careernavigator

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.careernavigator.databinding.ActivityCreateProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class CreateProfile : AppCompatActivity() {

    lateinit var creat: Button
    lateinit var sk : Button
    private lateinit var binding: ActivityCreateProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri: Uri
    lateinit var proname: EditText
    lateinit var proemail: EditText
    lateinit var protel: EditText
    lateinit var backbtn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)

        creat=findViewById(R.id.createpro)
        proname=findViewById(R.id.proname)
        proemail=findViewById(R.id.proemail)
        protel=findViewById(R.id.protel)
        backbtn=findViewById(R.id.backbtn)

        backbtn.setOnClickListener {
            val intent=Intent(this,Settings::class.java)
            startActivity(intent)
            finish()
        }

        sk=findViewById(R.id.skip)
        auth= FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        binding= ActivityCreateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        databaseReference= FirebaseDatabase.getInstance().getReference("Users")
        binding.skip.setOnClickListener {
            val hm = Intent(this,UserActivity::class.java)
            startActivity(hm)
        }

        binding.createpro.setOnClickListener {
            val name = binding.proname.text.toString()
            val email = binding.proemail.text.toString()
            val tel = binding.protel.text.toString()




            val user=User(name, email,tel  )
            if (uid != null){
                if (name.isBlank()||email.isBlank()||tel.isBlank()) {
                    Toast.makeText(this, " All fields are required", Toast.LENGTH_LONG).show()
                    return@setOnClickListener

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(this, "Email Incorrect Or Do not match", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                databaseReference.child(uid).setValue(user).addOnCompleteListener {
                    if(it.isSuccessful){
                        Toast.makeText(this,"Created Successfully", Toast.LENGTH_LONG).show()
                        val take = Intent(this,UserActivity::class.java)
                        startActivity(take)
                        uploadprofile()
                    }
                    else{
                        Toast.makeText(this,"Something Wrong Happened!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


    }

    private fun uploadprofile(){
        imageUri= Uri.parse("android.resource://$packageName${R.layout.activity_user}")
        storageReference= FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {
            Toast.makeText(this,"Created Successfully", Toast.LENGTH_LONG).show()
            val take= Intent(this,UserActivity::class.java)
            startActivity(take)
        }.addOnFailureListener{
            Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
        }
    }
}

