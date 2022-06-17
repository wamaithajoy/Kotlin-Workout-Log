package com.wamaithajoy.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wamaithajoy.workoutlog.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
       castviews()

    }
    fun castviews(){

        binding.btnlogin.setOnClickListener {
            validateLogin()
        startActivity(Intent(this,HomeActivity::class.java))}
        }



    fun validateLogin(){
        binding.tilEmail.error=null
        binding.tilpassword.error=null
        var error=false
        var email=binding.etEmail.text.toString()
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error=true
        }
        var password=binding.etpassword.text.toString()
        if(password.isBlank()){
            binding.tilpassword.error="Password is required"
            error=true
        }
        if(!error){

        }


    }
}
