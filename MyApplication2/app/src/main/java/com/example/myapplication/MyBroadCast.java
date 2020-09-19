package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.myapplication")) {
            Toast.makeText(context, "WELCOME FROM MY BROADCAST", Toast.LENGTH_SHORT).show();
        } //else {
            //ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
           // NetworkInfo ni = cm.getActiveNetworkInfo();
           // if (ni != null && ni.isConnectedOrConnecting()) {
                //try {
                    //Toast.makeText(context, "Connected to a network", Toast.LENGTH_SHORT).show();
                //} catch (Exception e) {
                  //  e.printStackTrace();
               // }
           // } else {
               // Toast.makeText(context, "Network not connected or Reconnect", Toast.LENGTH_SHORT).show();
           // }
        //}

    }
}

