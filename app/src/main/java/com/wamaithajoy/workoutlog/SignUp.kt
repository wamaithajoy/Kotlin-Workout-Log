package com.wamaithajoy.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {
    lateinit var tilFirstName:TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName: TextInputEditText
    lateinit var tilEmailAddress: TextInputLayout
    lateinit var etEmailAddress: TextInputEditText
    lateinit var tilPassword: TextInputLayout
    lateinit var etPassword: TextInputEditText
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var etConfirmPassword: TextInputEditText
    lateinit var btnSignUp:Button
    lateinit var tvLogin:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        castview()
    }
    fun castview(){
        tilFirstName=findViewById(R.id.tilFirstName)
        etFirstName=findViewById(R.id.etFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        etLastName=findViewById(R.id.etLastName)
        tilEmailAddress=findViewById(R.id.tilEmailAddress)
        etEmailAddress=findViewById(R.id.etEmailAddress)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        tilConfirmPassword=findViewById(R.id.tilConfirmPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        btnSignUp=findViewById(R.id.btnSignUp)
        tvLogin=findViewById(R.id.tvLogin)
        tvLogin.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }
        btnSignUp.setOnClickListener { validating() }
    }
    fun validating(){
        var error=false
        tilFirstName.error=null
        tilLastName.error=null
        tilEmailAddress.error=null
        tilConfirmPassword.error=null
        tilPassword.error=null
        var firstname=etFirstName.text.toString()
        if (firstname.isBlank()){
            tilFirstName.error="Firstname is required"
        }
        var lastname=etLastName.text.toString()
        if (lastname.isBlank()){
            tilLastName.error="Lastname is required"
        }
        var email=etEmailAddress.text.toString()
        if (email.isBlank()){
            tilEmailAddress.error="Email is required"
        }
        var password=etPassword.text.toString()
        if (password.isBlank()){
            tilPassword.error="Password is required"
        }
        var confirmpassword=etConfirmPassword.text.toString()
        if (confirmpassword.isBlank()){
            tilConfirmPassword.error="Confirm password is required"
        }
        var equals=etPassword==etConfirmPassword
        if(etPassword!=etConfirmPassword){
            tilConfirmPassword.error="Wrong Password"
        }
    }
}