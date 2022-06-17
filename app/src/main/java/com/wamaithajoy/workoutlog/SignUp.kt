package com.wamaithajoy.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wamaithajoy.workoutlog.databinding.ActivityLoginBinding
import com.wamaithajoy.workoutlog.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
   lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castview()
    }
    fun castview(){

        binding.tvLogin.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener { validating() }
    }
    fun validating(){
        var error=false
        binding.tilFirstName.error=null
        binding.tilLastName.error=null
        binding.tilEmailAddress.error=null
        binding.tilConfirmPassword.error=null
        binding.tilPassword.error=null
        var firstname=binding.etFirstName.text.toString()
        if (firstname.isBlank()){
            binding.tilFirstName.error="Firstname is required"
        }
        var lastname=binding.etLastName.text.toString()
        if (lastname.isBlank()){
            binding.tilLastName.error="Lastname is required"
        }
        var email=binding.etEmailAddress.text.toString()
        if (email.isBlank()){
            binding.tilEmailAddress.error="Email is required"
            error=true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.tilEmailAddress.error="Not a valid email"
            error=true
        }
        var password=binding.etPassword.text.toString()
        if (password.isBlank()){
            binding.tilPassword.error="Password is required"
        }
        var confirmpassword=binding.etConfirmPassword.text.toString()
        if (confirmpassword.isBlank()){
            binding.tilConfirmPassword.error="Confirm password is required"
            if(password!=confirmpassword){
                binding.tilConfirmPassword.error="Wrong password"
        }



        }
    }
}