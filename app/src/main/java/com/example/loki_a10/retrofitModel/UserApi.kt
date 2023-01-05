package com.example.loki_a10.retrofitModel

import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.*
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username:String, @Field("password")
    password:String): Call<UserRequest>

    @POST("api/logout")
    fun logout(@Header("Authorization") token: String) : Call<LogoutResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<User>

    @FormUrlEncoded
    @POST("/api/me/update")
    fun updateProfile(
        @Header("Authorization") token:String,
        @Field("name") name:String,
        @Field("email") email:String
    ):Call<UpdateProfilResponse>

    @FormUrlEncoded
    @POST("/api/password")
    fun updatePassword(
        @Header("Authorization")token: String,
        @Field("old_password") old_password:String,
        @Field("new_password") new_password:String,
        @Field("confirm_password") confirm_password:String
    ):Call<UbahSandiResponse>

    @GET("/api/my-internship/2/logbook")
    fun listLogbook(@Header("Authorization") token:String):Call<LogbookResponse>

    @FormUrlEncoded
    @POST("/api/my-internship/2/logbook/1")
    fun detailLogbook(@Header("Authorization") token: String):Call<DetailLogbookResponse>

    @FormUrlEncoded
    @POST("/api/my-internship/2/logbook")
    fun tambahLogbook(
        @Header("Authorization")token: String
    ):Call<TambahLogbookResponse>

    @FormUrlEncoded
    @POST("/api/my-internship/2/finish-statement")
    fun laporKPSelesai(
        @Header("Authorization")token: String
    ):Call<LaporKPSelesaiResponse>

    @GET("/api/info-seminar-internship")
    fun infoSeminarLain(@Header("Authorization") token:String):Call<InformasiSeminarResponse>
}