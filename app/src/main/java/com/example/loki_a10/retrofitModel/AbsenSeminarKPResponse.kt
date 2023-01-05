package com.example.loki_a10.retrofitModel

import com.google.gson.annotations.SerializedName

data class AbsenSeminarKPResponse(
    @SerializedName("status"  ) var status  : String? = null,
    @SerializedName("message" ) var message : String? = null,
    @SerializedName("data"    ) var data    : Data?   = Data()
)
{
    data class Data (

        @SerializedName("internship_id" ) var internshipId : String? = null,
        @SerializedName("student_id"    ) var studentId    : Int?    = null,
        @SerializedName("role"          ) var role         : Int?    = null,
        @SerializedName("updated_at"    ) var updatedAt    : String? = null,
        @SerializedName("created_at"    ) var createdAt    : String? = null,
        @SerializedName("id"            ) var id           : Int?    = null

    )
}
