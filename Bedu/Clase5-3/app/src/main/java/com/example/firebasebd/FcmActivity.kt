package com.example.firebasebd

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging

class FcmActivity : AppCompatActivity() {

    lateinit var CHANNEL_ID:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm)

        var descuento = intent.getDoubleExtra("descuento",0.0)

    }

    fun suscribirTopic(view:View){
        var tag = view.tag.toString()
        if(view is CheckBox){
            if(view.isChecked){
                //FirebaseMessaging.getInstance().suscribeToTopic()
            }
        }
    }

}
