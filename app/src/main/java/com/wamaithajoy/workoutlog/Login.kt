package com.wamaithajoy.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var tilpassword:TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var etpassword:TextInputEditText
    lateinit var tvSignUp: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
       castviews()

    }
    fun castviews(){
        btnLogin=findViewById(R.id.btnlogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilpassword=findViewById(R.id.tilpassword)
        etEmail=findViewById(R.id.etEmail)
        etpassword=findViewById(R.id.etpassword)
        tvSignUp=findViewById(R.id.tvSignUp)

        btnLogin.setOnClickListener {
            validateLogin()
        startActivity(Intent(this,HomeActivity::class.java))}
        tvSignUp.setOnClickListener {
            val intent=Intent(this,SignUp::class.java)
            startActivity(intent)
        }

    }
    fun validateLogin(){
        tilEmail.error=null
        tilpassword.error=null
        var error=false
        var email=etEmail.text.toString()
        if (email.isBlank()){
            tilEmail.error="Email is required"
            error=true
        }
        var password=etpassword.text.toString()
        if(password.isBlank()){
            tilpassword.error="Password is required"
            error=true
        }
        if(!error){

        }


    }
}