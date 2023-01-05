package com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response

import com.google.gson.annotations.SerializedName

data class TambahLogbookResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("message") var message: String?  = null,
    @SerializedName("logbook") var logbook : ArrayList<Logbook> = arrayListOf()
){
    data class Logbook (
        @SerializedName("internship_id") var internship_id  : Int? = null,
        @SerializedName("date") var date  : String? = null,
        @SerializedName("activities") var activities  : String? = null,
        @SerializedName("note") var note : Any? = null,
        @SerializedName("status") var status : Int? = null,
        @SerializedName("created_at") var created_at : String? = null,
        @SerializedName("updated_at") var updated_at : String? = null,
        @SerializedName("id") var id  : Int? = null
    )
}
