package com.example.loki_a10.mynotification

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.loki_a10.MainActivity
import com.example.loki_a10.R
import kotlinx.android.synthetic.main.notification_channel.*

class NotificationChannelActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_channel)

        notificationManager = NotificationManagerCompat.from(this)

        btNotif1.setOnClickListener {
//            val title = titleNotification.text.toString()
//            val message = messageNotification.text.toString()

            // Membuat action notifikasi ketika di tekan
            val resultIntent = Intent(this, MainActivity::class.java)
            val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
                addNextIntentWithParentStack(resultIntent)
                getPendingIntent(0,
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
            }

            //Membuat builder notifikasi
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Judul Notif")
                .setContentText("Coba coba ya gais ya")
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)

            //Menampilkan Notifikasi
            val notification = builder.build()
            notificationManager.notify(1, notification)
        }

//        btnNotif2.setOnClickListener {
//            val title = titleNotification.text.toString()
//            val message = messageNotification.text.toString()
//            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_2_ID)
//                .setSmallIcon(R.drawable.ic_notifications)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setPriority(NotificationCompat.PRIORITY_LOW)
//
//            val notification = builder.build()
//            notificationManager.notify(2, notification)
//        }

    }
}