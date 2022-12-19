package com.example.loki_a10

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_lapor_kp_selesai.*
import kotlinx.android.synthetic.main.activity_ubah_sandi.*

class ubah_sandi : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_sandi)

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
        Toast.makeText(this, "Password Berhasil Diubah", Toast.LENGTH_SHORT).show()
    }
}