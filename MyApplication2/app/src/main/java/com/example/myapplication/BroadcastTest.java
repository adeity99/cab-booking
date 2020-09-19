package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class BroadcastTest extends AppCompatActivity {
    public static final int REQ_ID_M_PERMISSION=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);
        checkandRequestPermission();
    }

    @Override
    protected void onResume() {
        IntentFilter filter=new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");//implicit intent
        getApplicationContext().registerReceiver(new MyCallReciver(),filter);
        super.onResume();
    }

    private boolean checkandRequestPermission()
    {
        int rphone_state= ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int rcall_log=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CALL_LOG);
        List<String> l=new ArrayList();
        if(rphone_state!= PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(rcall_log!=PackageManager.PERMISSION_GRANTED)
        {
            l.add(Manifest.permission.READ_CALL_LOG);
        }
        if(!l.isEmpty())
        {
            ActivityCompat.requestPermissions(this,l.toArray(new String[l.size()]),REQ_ID_M_PERMISSION);
         return false;
        }
        return true;
    }
}