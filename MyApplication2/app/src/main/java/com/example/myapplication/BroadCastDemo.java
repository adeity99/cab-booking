package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BroadCastDemo extends AppCompatActivity implements View.OnClickListener {
    Button b;
    MyBroadCast mbc;
    IntentFilter ifr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_demo);
        b=findViewById(R.id.broadcast);
        b.setOnClickListener(this);
        mbc=new MyBroadCast();
        /*IntentFilter ifr=new IntentFilter("com.example.myapplicaion");*/ //directly we cannot do static register from xml after oreo version so we have to register dynamically
        ifr=new IntentFilter("com.example.myapplicaion");//make IntentFilter ifr as class

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mbc,ifr);//register the broadcast
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mbc);
    }

    @Override
    public void onClick(View v) {
       Intent i=new Intent("com.example.myapplicaion");//it is important to match action
       sendBroadcast(i);
    }
}