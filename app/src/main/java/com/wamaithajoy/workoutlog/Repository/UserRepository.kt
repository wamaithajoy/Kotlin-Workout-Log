package com.wamaithajoy.workoutlog.Repository

import com.wamaithajoy.workoutlog.API.ApiClient
import com.wamaithajoy.workoutlog.API.ApiInterface
import com.wamaithajoy.workoutlog.Models.LoginRequest
import com.wamaithajoy.workoutlog.Models.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
    = withContext(Dispatchers.IO){
        val response =apiClient.loginUser(loginRequest)
        return@withContext response
    }
}