package com.example.loki_a10.retrofitModel

import com.google.gson.annotations.SerializedName

data class UpdateProfilResponse(
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)
