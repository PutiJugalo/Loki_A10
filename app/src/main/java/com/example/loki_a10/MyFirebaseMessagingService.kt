package com.example.loki_a10

import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.loki_a10.mynotification.BaseApplication
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        val refreshToken = FirebaseMessaging.getInstance().token

        Log.e("refresh token", refreshToken.toString())
        //Kirim token ke server
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        displayNotification(remoteMessage.notification?.title.toString(), remoteMessage.notification?.body.toString())
    }


    fun displayNotification(title : String ,message : String) {
        // Membuat action notifikasi ketika di tekan
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(this, 0,intent, PendingIntent.FLAG_ONE_SHOT)

        //Membuat builder notifikasi
        val builder = NotificationCompat.Builder(this, BaseApplication.CHANNEL_LAPOR_KP_SELESAI_ID)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentTitle(title)
            .setContentText(message)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)

        //Menampilkan Notifikasi
//        val notification = builder.build()
//        notificationManager.notify(2, notification)
        with(NotificationManagerCompat.from(this)){
            notify(3, builder.build())
        }

    }
}
