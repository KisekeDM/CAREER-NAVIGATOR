package com.example.careernavigator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class SecondSplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val console= Intent(this,SignUp::class.java)
            startActivity(console)
            finish()
        },1000)

    }
}