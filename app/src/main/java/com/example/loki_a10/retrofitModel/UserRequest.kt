package com.example.loki_a10.retrofitModel

import com.google.gson.annotations.SerializedName

class UserRequest {
    @field:SerializedName("authorisation")
    val authorisation: UserResponse? = null

    @field:SerializedName("status")
    val status: String? = null

//    @SerializedName("email")
//    @Expose
//    var email: String? = null
//
//    @SerializedName("password")
//    @Expose
//    var password: String? = null
}