package com.indev.bwakotlinlaravel.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.indev.bwakotlinlaravel.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val auth = Intent(this@SplashScreenActivity, OnboardingOneActivity::class.java)
            startActivity(auth)
            finish()
        }, 3000)
    }
}