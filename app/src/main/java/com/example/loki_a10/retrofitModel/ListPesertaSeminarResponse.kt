package com.example.loki_a10.retrofitModel

import com.google.gson.annotations.SerializedName

data class ListPesertaSeminarResponse(
    @SerializedName("status"      ) var status      : String?           = null,
    @SerializedName("count"       ) var count       : Int?              = null,
    @SerializedName("internships" ) var internships : ArrayList<String> = arrayListOf()
)
