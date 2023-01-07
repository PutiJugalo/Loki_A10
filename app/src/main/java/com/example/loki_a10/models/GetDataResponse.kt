package com.example.loki_a10.models

import com.google.gson.annotations.SerializedName

data class GetDataResponse(

    @field:SerializedName("internships")
    val internships: List<InternshipsItem?>? = null,

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("status")
    val status: String? = null
)