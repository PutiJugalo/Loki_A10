package com.example.loki_a10

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_lapor_kp_selesai.*

class LaporKpSelesaiActivity : AppCompatActivity() {

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
        startActivity(intent)
    }
}

internal fun Button.checkSessionStatus() {

}
