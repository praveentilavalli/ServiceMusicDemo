package com.example.adityacomputers.servicemusicdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
//import android.support.v7.app.NotificationCompat;

/**
 * Created by ADITYA COMPUTERS on 9/12/2018.
 */

public class MusicService extends Service {
    MediaPlayer mp;
    @Override
    public void onCreate() {
        super.onCreate();
        //create media player object
        mp=MediaPlayer.create(this,R.raw.song);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        //start playing music and build notification
        mp.start();
        mp.setLooping(true);
        sendNotification();
    }

    @Override
    public void onDestroy() {
        //stop the media player
        mp.stop();
        super.onDestroy();
    }
    //method to build the notification and pending intent
    public void sendNotification()
    {
        //build the notification objecct and it content
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)        // the status icon
                .setTicker("Service running...")           // the status text
                .setWhen(System.currentTimeMillis())       // the time stamp
                .setContentTitle("Music notification")                 // the label of the entry
                .setContentText("Music started to play...")      // the content of the entry
                .setContentIntent(pendingIntent)           // the intent to send when the entry is clicked
                .setOngoing(true)                          // make persistent (disable swipe-away)
                .build();
        // Start service in foreground mode
        startForeground(1,notification);
    }

}
