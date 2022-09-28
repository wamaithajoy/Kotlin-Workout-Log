package com.wamaithajoy.workoutlog.API

import com.wamaithajoy.workoutlog.Models.LoginRequest
import com.wamaithajoy.workoutlog.Models.LoginResponse
import com.wamaithajoy.workoutlog.Models.RegisterResponse
import com.wamaithajoy.workoutlog.Models.registerRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiInterface {
   @POST("/register")
   fun registerUser(@Body registerRequest: registerRequest): Call<RegisterResponse>

   @POST("/login")
  suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>
}