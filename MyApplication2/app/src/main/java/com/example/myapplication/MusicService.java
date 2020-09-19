/*
package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;


 class MusicService extends Service{
     @Nullable
     @Override
     public IBinder onBind(Intent intent)
     {
         return null;
     }

     @Override
     public void onCreate() {
         super.onCreate();
     }

     @Override
     public int onStartCommand(Intent intent, int flags, int startId) {
         MediaPlayer mp= MediaPlayer.create(this,R.raw.song);
         Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
         mp.start();
        // mp.setLooping(true);
         return START_STICKY;
     }

     @Override
     public void onDestroy() {
         super.onDestroy();
         //stopSelf();
     }
 }
*/
