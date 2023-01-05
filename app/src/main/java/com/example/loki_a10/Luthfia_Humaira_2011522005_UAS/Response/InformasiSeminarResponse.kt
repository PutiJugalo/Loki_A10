package com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response

import com.google.gson.annotations.SerializedName

data class InformasiSeminarResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("count") var count: Int?  = null,
    @SerializedName("internships") var internships : ArrayList<InformasiSeminarResponse> = arrayListOf()
)
