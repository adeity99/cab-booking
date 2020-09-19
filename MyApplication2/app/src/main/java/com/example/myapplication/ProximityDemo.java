package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityDemo extends AppCompatActivity {

    TextView tv;
    Sensor s;
    SensorManager sm;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
         float x=event.values[0];
         if(x<s.getMaximumRange())
         {
             tv.setText("Near");
         }
         else
         {
           tv.setText("Far")  ;
         }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        tv=findViewById(R.id.textView3);
        //Typecast in form of SensorManager by putting (SensorManager) in front of getSystemService(SENSOR_SERVICE);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

    }
}