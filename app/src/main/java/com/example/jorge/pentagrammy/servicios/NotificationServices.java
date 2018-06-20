package com.example.jorge.pentagrammy.servicios;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.vista.Notificaciones;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.time.LocalDate;


public class NotificationServices extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {



        Log.d(TAG, "detinatario: " + remoteMessage.getFrom());

        // Se  verifica  si   hay  una  notificacion remota  en  caso de  que    si  la alla  se  entra  en el  siclo  y se manda   el parameto de la notificacion
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "cuerpo del  mensaje: " + remoteMessage.getNotification().getBody());
            sendNotification(remoteMessage.getNotification().getBody(),remoteMessage.getNotification().getTitle());

            String token = FirebaseInstanceId.getInstance().getToken();
            Log.d("Token",token);
        }
    }

    private void sendNotification(String messageBody, String title) {
        Intent intent = new Intent(this, Notificaciones.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        Intent i = new Intent(this, Notificaciones.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , i,
                PendingIntent.FLAG_ONE_SHOT);

        String channelId = getString(R.string.default_notification_channel_id);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(R.drawable.img3)
                        .setContentTitle(title)
                        .setContentText(messageBody)
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String description = getString(R.string.channel_description);
        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,"Channel human readable title", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new  long[]{100,200,300,400,500,400,300,200,400});

            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 , notificationBuilder.build());
    }

}
