package com.hp.project.finalprojectandroid.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class AppMessageService : FirebaseMessagingService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)


    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        remoteMessage?.let {

            Log.d("teste", "FROM : " + remoteMessage.from)

            //Verify if the message contains data
            if (it.data.isNotEmpty()) {
                Log.d("teste", "Message data : " + it.data)
            }

            //Verify if the message contains notification
            if (it.notification != null) {
//                Log.d("teste","Message body : "+it.notification.body)
//                var teste = it.notification.body
//                sendNotification(teste)
            }

        }



    }


}