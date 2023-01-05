package com.example.loki_a10

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.loki_a10.databinding.ActivityUbahSandiBinding
import com.example.loki_a10.retrofitModel.RetrofitClient
import com.example.loki_a10.retrofitModel.UbahSandiResponse
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_ubah_sandi.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UbahSandi : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    lateinit var binding: ActivityUbahSandiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUbahSandiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        notificationManager = NotificationManagerCompat.from(this)

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().subscribeToTopic("E-KP") //THis for by topic
            .addOnCompleteListener { task ->
                var msg = "success"
                if (!task.isSuccessful) {
                    msg = "gagal"
                }
                Log.d(ContentValues.TAG, msg)
            }
        buttonUbahPassword.checkSessionStatus()

    }

    fun ubahPasswordClicked(view: View) {
        val sharedPref = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?: return
        val token = sharedPref.getString("TOKEN",null)

        val old_password = binding.textPasswordLamadiUbahSandi.text.toString()
        val new_password = binding.textPasswordBarudiUbahSandi.text.toString()
        val confirm_password = binding.textKonfirmasiPassworddiUbahSandi.text.toString()

        val retrofitClient = RetrofitClient.create()
        val call = retrofitClient.updatePassword(token = "Bearer $token", old_password, new_password,confirm_password)

        Log.d("update-debug", "$old_password|$new_password|$confirm_password|Bearer $token")

        call.enqueue(object: Callback<UbahSandiResponse> {
            override fun onFailure(call: Call<UbahSandiResponse>, t: Throwable) {
                Log.d("update-debug",t.localizedMessage)
            }
            override fun onResponse(call: Call<UbahSandiResponse>, response: Response<UbahSandiResponse>) {
                Log.d("update-debug", "response : $response")

                val respon: UbahSandiResponse? = response.body()
                if (respon != null && respon.status == "success" && new_password == confirm_password) {

                    Log.d("update-debug", "$old_password:$new_password|$confirm_password|$token|$respon")

                    Toast.makeText(this@UbahSandi, "Berhasil Mengupdate password", Toast.LENGTH_SHORT).show()

                    intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@UbahSandi, "Password & Confirm Passowrd Salah", Toast.LENGTH_SHORT).show()
                }
            }
        })
//
        }
    }
