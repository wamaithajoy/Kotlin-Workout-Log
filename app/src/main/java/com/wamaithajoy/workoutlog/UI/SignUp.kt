package com.wamaithajoy.workoutlog.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.wamaithajoy.workoutlog.API.ApiClient
import com.wamaithajoy.workoutlog.API.ApiInterface
import com.wamaithajoy.workoutlog.Models.RegisterResponse
import com.wamaithajoy.workoutlog.Models.registerRequest
import com.wamaithajoy.workoutlog.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            val intent=Intent(this, Login::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener { validating()
            startActivity(Intent(this,HomeActivity::class.java))}
    }
    fun validating(){
        var error=false
        binding.tilFirstName.error=null
        binding.tilLastName.error=null
        binding.tilEmailAddress.error=null
        binding.tilConfirmPassword.error=null
        binding.tilPassword.error=null
        binding.tilPhoneNumber.error=null
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
        var phoneNumber=binding.etPassword.text.toString()
        if (phoneNumber.isBlank()){
            binding.tilPassword.error="Password is required"
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
        if (!error){
            val registerRequest=registerRequest(firstname,lastname,phoneNumber,email,password )
            makeRegisterRequest(registerRequest)
        }
    }
    fun makeRegisterRequest(registerRequest: registerRequest){
        var apiClient=ApiClient.ApiClient.buildApiClient(ApiInterface::class.java)
        val request=apiClient.registerUser(registerRequest)

        request.enqueue(object :Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if(response.isSuccessful){
                Toast.makeText(baseContext,response.body()?.message,Toast.LENGTH_LONG).show()
                }
                else{
                    var error=response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })

    }
}