package com.example.adityacomputers.servicemusicdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnstart,btnstop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inilize the code
        btnstart=(Button)findViewById(R.id.button);
        btnstop=(Button)findViewById(R.id.button2);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start the music service
                Intent i=new Intent(MainActivity.this,MusicService.class);
//                sendNotification();
                startService(i);
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop the music service
                Intent i=new Intent(MainActivity.this,MusicService.class);
                stopService(i);
            }
        });
    }

}
