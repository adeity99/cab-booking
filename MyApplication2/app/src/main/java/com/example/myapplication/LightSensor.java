package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LightSensor extends AppCompatActivity {
    TextView tv;
    List<Sensor> s;
    SensorManager sm;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event.values[0];
            tv.setText("I am at position"+x);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);//typecast with SensorManager
        Sensor s1=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(s1==null)
            Toast.makeText(this, "Light Sensor not Present", Toast.LENGTH_SHORT).show();
        s=sm.getSensorList(Sensor.TYPE_LIGHT);
        tv=findViewById(R.id.textView3);
      //  sm.registerListener(sel,s.get(0),SensorManager.SENSOR_DELAY_NORMAL);
    }
}