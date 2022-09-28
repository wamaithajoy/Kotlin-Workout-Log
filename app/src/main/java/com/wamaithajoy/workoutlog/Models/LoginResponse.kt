package com.wamaithajoy.workoutlog.Models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var response: String,
    @SerializedName("message")  var message: String,
    @SerializedName("access_token")  var acessToken: String,
    @SerializedName("user_id") var userId: String,
    @SerializedName("profile_id") var profileId: String,
)
