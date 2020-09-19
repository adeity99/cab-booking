package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

public class WifiDemo extends AppCompatActivity {

public static final int REQ_ID_M_PERMISSION=1;
Switch s;
WifiManager wm;
IntentFilter ifr;
WifiBroadcastDemo wbcd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_demo);
        checkandRequestPermission();//as soon as the activity is loaded permission should be granted
        s=findViewById(R.id.wifis);
        wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked)
            {
                if(!wm.isWifiEnabled())
                {
                    wm.setWifiEnabled(true);
                    s.setText("WIFI Off");
                }
            }
            else
            {
                if(wm.isWifiEnabled())
                {
                    wm.setWifiEnabled(false);
                    s.setText("WIFI On");
                }
            }
            }
        });//anonymous class for setOnCheckedChangeListener
        ifr=new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        wbcd=new WifiBroadcastDemo();
        registerReceiver(wbcd,ifr);
        wm.startScan();
    }
    private boolean checkandRequestPermission()
    {
        int aws= ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE);
        int cws=ContextCompat.checkSelfPermission(this,Manifest.permission.CHANGE_WIFI_STATE);
        List<String> l=new ArrayList();
        if(aws!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.ACCESS_WIFI_STATE);
        }
        if(cws!=PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.CHANGE_WIFI_STATE);
        }
        if(!l.isEmpty())
        {
            ActivityCompat.requestPermissions(this,l.toArray(new String[l.size()]),REQ_ID_M_PERMISSION);
            return false;
        }
        return true;
    }

}