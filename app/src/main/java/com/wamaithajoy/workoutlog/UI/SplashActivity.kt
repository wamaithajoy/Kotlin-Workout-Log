package com.wamaithajoy.workoutlog.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        val accessToken=sharedPref.getString("ACCESS_TOKEN","")
        if(accessToken!!.isBlank()){
            startActivity(Intent(this, Login::class.java))
        }
        else{
            startActivity(Intent(this, HomeActivity::class.java))
        }


    }
}