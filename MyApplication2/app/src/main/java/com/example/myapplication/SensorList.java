package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {
   TextView tv;
   Sensor s;
   SensorManager sm;
   List<Sensor> l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        l=sm.getSensorList(Sensor.TYPE_ALL);
        tv=findViewById(R.id.textView3);
        for(Sensor s1:l)
        {
            tv.append(s1.getName() + " | "+s1.getVendor() + " | "+s1.getType());
        }
    }
}