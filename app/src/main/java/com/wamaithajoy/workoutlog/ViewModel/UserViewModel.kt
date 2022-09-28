package com.wamaithajoy.workoutlog.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wamaithajoy.workoutlog.Models.LoginRequest
import com.wamaithajoy.workoutlog.Models.LoginResponse
import com.wamaithajoy.workoutlog.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository=UserRepository()
    val loginResponseLiveData=MutableLiveData<LoginResponse>()
    val errorLiveData=MutableLiveData<String>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue((response.errorBody()?.string()))
            }
        }
    }
}