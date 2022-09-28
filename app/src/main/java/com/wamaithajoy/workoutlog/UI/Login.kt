package com.wamaithajoy.workoutlog.UI

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.wamaithajoy.workoutlog.API.ApiClient
import com.wamaithajoy.workoutlog.API.ApiInterface
import com.wamaithajoy.workoutlog.Models.LoginRequest
import com.wamaithajoy.workoutlog.Models.LoginResponse
import com.wamaithajoy.workoutlog.ViewModel.UserViewModel
import com.wamaithajoy.workoutlog.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
       castviews()
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

    }

    override fun onResume(){
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))
        })

        userViewModel.errorLiveData.observe(this, Observer { errorMessage->
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()
        })
    }
    fun castviews(){

        binding.btnlogin.setOnClickListener {
            validateLogin()
        }
        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,SignUp::class.java))
        }
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
            val loginRequest=LoginRequest(email,password)
            binding.pBlogin.visibility=View.VISIBLE
            userViewModel.loginUser((loginRequest))


        }


    }
//    fun makeLoginRequest(loginRequest: LoginRequest){
//        val apiClient= ApiClient.ApiClient.buildApiClient(ApiInterface::class.java)
//        val request=apiClient.loginUser(loginRequest)
//
//        request.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//               if(response.isSuccessful){
//                   val loginResponse=response.body()
//
//               }
//                else{
//                    val error=response.errorBody()?.string()
//               }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                binding.pBlogin.visibility=View.GONE
//               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//            }
//
//        })
//
//    }
    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.acessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()
    }
}
