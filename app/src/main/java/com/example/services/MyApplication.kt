package com.example.services

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

class MyApplication:Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()



        val channel = NotificationChannel(
            "channel_id",
            "my foregraound service Notification",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager= getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
}