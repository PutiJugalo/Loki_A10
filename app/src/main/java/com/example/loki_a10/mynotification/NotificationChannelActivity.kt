package com.example.loki_a10.mynotification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.loki_a10.R
import kotlinx.android.synthetic.main.notification_channel.*

class NotificationChannelActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notification_channel)

        notificationManager = NotificationManagerCompat.from(this)

        btNotif1.setOnClickListener {
            val title = titleNotification.text.toString()
            val message = messageNotification.text.toString()
            val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)

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