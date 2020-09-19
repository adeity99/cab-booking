package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.security.cert.PKIXRevocationChecker;

public class NotificationDemo extends AppCompatActivity implements View.OnClickListener {
    Notification n;
    NotificationManager nm;
    NotificationChannel nc;
    NotificationCompat.Builder nb;
    final static String CHANNEL_ID="mynm";
    Button n1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_demo);
        n1=findViewById(R.id.nm);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        n1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nb=new NotificationCompat.Builder(this,CHANNEL_ID);
        nb.setSmallIcon(android.R.drawable.stat_notify_missed_call);
        nb.setContentTitle("You Have Missed Call");
        nb.setContentText("You have missed call from 9999999999");
        nb.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        createNotificationChannel();
        Intent i=new Intent(this,Result.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);
        nb.setContentIntent(pi);
        nb.setAutoCancel(true);
        NotificationManagerCompat nmc=NotificationManagerCompat.from(this);
        nmc.notify(0, nb.build());

    }
    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
        CharSequence name=getString(R.string.channel_name);
        String desc= getString(R.string.channel_desc);
        int imp=NotificationManager.IMPORTANCE_DEFAULT;
        nc=new NotificationChannel(CHANNEL_ID,name,imp);
        nc.setDescription(desc);
        nm.createNotificationChannel(nc);
        }
    }
}