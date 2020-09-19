package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.Gravity;
import android.widget.Toast;

import java.util.List;

public class WifiBroadcastDemo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Toast.makeText(context, "INVOKED", Toast.LENGTH_SHORT).show();
        WifiManager wm=(WifiManager)(context.getApplicationContext().getSystemService(Context.WIFI_SERVICE));
        List<ScanResult> wi=wm.getScanResults();
        for(ScanResult s:wi)
        {
            String s1=s.SSID+"\t"+s.BSSID+"\t"+s.level;
            Toast toast=Toast.makeText(context,s1,Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
}
