package com.example.loki_a10

import android.app.PendingIntent.getService
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.ui.AppBarConfiguration
import com.example.loki_a10.databinding.ActivityAbsensiSeminarBinding
import com.example.loki_a10.retrofitModel.AbsenSeminarKPResponse
import com.example.loki_a10.retrofitModel.UserApi
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_absensi_seminar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class absensi_seminar : AppCompatActivity() {
    private lateinit var notificationManager: NotificationManagerCompat
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityAbsensiSeminarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absensi_seminar)
        binding = ActivityAbsensiSeminarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        //notifikasi
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
        buttonHadir.checkSessionStatus()
        //------

        val bundle : Bundle? = intent.extras
        val namaMhsLain = bundle!!.getString("namaMhsLain")
        val tanggalSeminarLain = bundle!!.getString("tanggalSeminarLain")

        binding.textNamadiAbsensi.text = namaMhsLain
        binding.textTanggaldiAbsensi.text = tanggalSeminarLain
    }
    fun absenSeminar () {
        var sharedPref = applicationContext.getSharedPreferences("sharedpref", Context.MODE_PRIVATE)?:return
        val token = sharedPref.getString("TOKEN", " ")
        Log.d("profile", token.toString())
        val retrofit : UserApi = com.example.loki_a10.retrofitModel.Retrofit().getService()
        val call : Call<AbsenSeminarKPResponse> = retrofit.attendSeminar("Bearer $token")
        call.enqueue(object : Callback<AbsenSeminarKPResponse> {
            override fun onResponse(
                call: Call<AbsenSeminarKPResponse>,
                response: Response<AbsenSeminarKPResponse>
            ) {
                Toast.makeText(this@absensi_seminar, "Berhasil", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<AbsenSeminarKPResponse>, t: Throwable) {
                Toast.makeText(this@absensi_seminar, "Yahh:(", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun tombolHadirClicked(view: View) {
        Toast.makeText(this, "Anda Sudah Hadir", Toast.LENGTH_SHORT).show()
    }
}