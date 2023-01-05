package com.example.loki_a10.models

import com.google.gson.annotations.SerializedName

class DetailKPResponse {
    @SerializedName("end_at")
    val endAt: String? = null

    @SerializedName("agency")
    val agency: String? = null

    @SerializedName("supervisor_id")
    val supervisorId = 0

    @SerializedName("seminar_room_id")
    val seminarRoomId = 0

    @SerializedName("title")
    val title: String? = null

    @SerializedName("start_at")
    val startAt: Any? = null

    @SerializedName("seminar_date")
    val seminarDate: String? = null

    @SerializedName("seminar_room_name")
    val seminarRoomName: String? = null

    @SerializedName("grade")
    val grade: String? = null

    @SerializedName("seminar_deadline")
    val seminarDeadline: Any? = null

    @SerializedName("audiences")
    val audiences: List<Any>? = null

    @SerializedName("id")
    val id = 0

    @SerializedName("supervisor")
    val supervisor: String? = null

    @SerializedName("status")
    val status = 0
}