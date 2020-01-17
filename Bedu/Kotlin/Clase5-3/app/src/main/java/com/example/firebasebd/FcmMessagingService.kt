package com.example.firebasebd

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FcmMessagingService : FirebaseMessagingService() {

    lateinit var CHANNEL_ID:String
    val DESCUENTO:String = "descuento"

    override fun onMessageReceived(rM: RemoteMessage?) {
        super.onMessageReceived(rM)
        var desc = rM!!.data[DESCUENTO].toString().toDouble()

        val intento = Intent(this,FcmActivity::class.java)
        intento.putExtra(DESCUENTO,desc)
        intento.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)


        if(rM.data.isNotEmpty()){
            mostrarNotificacion(rM)
        }

        mostrarNotificacion(rM)
    }

    private fun mostrarNotificacion(rM: RemoteMessage?){
        CHANNEL_ID = getString(R.string.CHANEL_ID)

        val intento = Intent(this,FcmActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,intento, PendingIntent.FLAG_ONE_SHOT)
        val sonidoNotifacion = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) as Uri
        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_carrito)
            .setContentTitle("Titulo de la notificacion")
            .setContentText("Oferta descuento en curso kotlin")
            .setAutoCancel(true)
            .setSound(sonidoNotifacion)
            .setContentIntent(pendingIntent)


        //MOSTRAR NOTIFICACION
        with(NotificationManagerCompat.from(this)){
            notify(0,builder.build())
        }
    }

    fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
