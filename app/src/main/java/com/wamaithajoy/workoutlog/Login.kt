package com.wamaithajoy.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var tilpassword:TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var etpassword:TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin=findViewById(R.id.btnlogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilpassword=findViewById(R.id.tilpassword)
        etEmail=findViewById(R.id.etEmail)
        etpassword=findViewById(R.id.etpassword)

        btnLogin.setOnClickListener { validateLogin() }

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