package com.wamaithajoy.workoutlog.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wamaithajoy.workoutlog.R
import com.wamaithajoy.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
  lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    fun setupBottomNav(){
    binding.btHome.setOnItemSelectedListener { item->
        when(item.itemId){
            R.id.plan ->{
                supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                true
            }
            R.id.track ->{
                supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                true
            }
            R.id.profile ->{
                val transaction=supportFragmentManager.beginTransaction().replace(
                    R.id.fcvHome,
                    ProfileFragment()
                ).commit()
                true
            }
            else->false
        }
    }
    }
}