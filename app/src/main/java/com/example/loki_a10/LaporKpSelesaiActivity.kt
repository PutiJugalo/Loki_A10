package com.example.loki_a10

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.example.loki_a10.Luthfia_Humaira_2011522005_UAS.Response.LaporKPSelesaiResponse
import com.example.loki_a10.retrofitModel.RetrofitClient
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_lapor_kp_selesai.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporKpSelesaiActivity : AppCompatActivity() {
    private var _binding: LaporKpSelesaiActivity?= null
    private val binding get() = _binding!!

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor_kp_selesai)
        supportActionBar?.hide()

        notificationManager = NotificationManagerCompat.from(this)

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().subscribeToTopic("E-KP") //THis for by topic
            .addOnCompleteListener { task ->
                var msg = "success"
                if (!task.isSuccessful) {
                    msg = "gagal"
                }
                Log.d(TAG, msg)
            }
        buttonIyaLaporKPSelesai.checkSessionStatus()

//        buttonIyaLaporKPSelesai.setOnClickListener {
////            val title = titleNotification.text.toString()
////            val message = messageNotification.text.toString()
//
//            // Membuat action notifikasi ketika di tekan
//            val resultIntent = Intent(this, MainActivity::class.java)
//            val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
//                addNextIntentWithParentStack(resultIntent)
//                getPendingIntent(0,
//                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
//            }
//
//            //Membuat builder notifikasi
//            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_UBAH_SANDI_ID)
//                .setSmallIcon(R.drawable.ic_notifications)
//                .setContentTitle("E-KP")
//                .setContentText("Kegiatan KP Telah Selesai")
//                .setContentIntent(resultPendingIntent)
//                .addAction(R.drawable.ic_baseline_navigate_next_24,"LIHAT", resultPendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
//
//            //Menampilkan Notifikasi
//            val notification = builder.build()
//            notificationManager.notify(1, notification)
//        }
    }
    fun ke_detailKP(view: View) {
        intent = Intent(this, DetailKpActivity::class.java)
        startActivity(intent)
    }
    fun ke_home(view: View) {
        intent = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Berhasil melaporkan KP telah selesai", Toast.LENGTH_SHORT).show()
        startActivity(intent)

        val sharedPreferences = applicationContext?.getSharedPreferences("sharedPref", Context.MODE_PRIVATE) ?: return
        val token = sharedPreferences.getString("Token","")

        Log.d("laporKPSelesai", token.toString())

        val retrofitClient = RetrofitClient.create()
        val call = retrofitClient.laporKPSelesai("Bearer $token")

        call.enqueue(object : Callback<LaporKPSelesaiResponse> {
            override fun onResponse(call: Call<LaporKPSelesaiResponse>, response: Response<LaporKPSelesaiResponse>) {
                val respon = response.body()
                Log.d("laporKPSelesai-debug", "respon : " + respon)

            }

            override fun onFailure(call: Call<LaporKPSelesaiResponse>, t: Throwable) {
                Log.d("laporKPSelesai-debug", t.localizedMessage)
            }

        })
    }
}

internal fun Button.checkSessionStatus() {

}
