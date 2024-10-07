package com.example.services

import android.content.Intent
import android.media.MediaPlayer
import android.media.audiofx.BassBoost
import android.os.IBinder
import android.provider.Settings
import androidx.core.app.NotificationCompat

class myservice : android.app.Service() {
    private lateinit var mediaPlayer:MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

      when (intent?.action){
          Actions.START.toString()-> {

             startmyservice()

          }

          Actions.STOP.toString()-> {
              mediaPlayer.stop()
              stopSelf()


          }


      }
        return super.onStartCommand(intent , flags , startId)
    }

    private fun startmyservice() {
        mediaPlayer=MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
         mediaPlayer.start()
        mediaPlayer.isLooping=true
        val notification= NotificationCompat.Builder(
            this,
            "channel_id"
        ).setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("foreground service")
            .setContentText("Foreground service is runnig")
            .setOngoing(true)
            .build()
        startForeground(1001,notification)
    }
}

enum class  Actions{
    START,
    STOP
}