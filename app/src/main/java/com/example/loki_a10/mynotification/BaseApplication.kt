package com.example.loki_a10.mynotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class BaseApplication : Application(){

    companion object{
        const val CHANNEL_1_ID = "channel1"
        const val CHANNEL_UBAH_SANDI_ID = "channelUbahSandi"
        const val CHANNEL_LAPOR_KP_SELESAI_ID = "channelLaporKPSelesai"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel Satu",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "Ini adalah channel 1"

            val channelUbahSandi = NotificationChannel(
                CHANNEL_UBAH_SANDI_ID,
                "Channel Ubah Sandi",
                NotificationManager.IMPORTANCE_HIGH
            )
            channelUbahSandi.description = "Ini adalah channel Ubah Kata Sandi"

            val channelLaporKpSelesai = NotificationChannel(
                CHANNEL_LAPOR_KP_SELESAI_ID,
                "Channel Lapor KP Selesai",
                NotificationManager.IMPORTANCE_HIGH
            )
            channelUbahSandi.description = "Ini adalah channel Lapor KP Selesai"

            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channelUbahSandi)
            manager.createNotificationChannel(channelLaporKpSelesai)
        }
    }
}

