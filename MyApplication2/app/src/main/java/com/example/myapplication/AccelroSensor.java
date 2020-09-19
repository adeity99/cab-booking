package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
// using layout of SensorList by setContentView(R.layout.activity_sensor_list);
public class AccelroSensor extends AppCompatActivity {
    TextView tv;
    Sensor s;
    SensorManager sm;
    SensorEventListener sel=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float x=event .values[0];
            float y=event.values[1];
            float z=event.values[2];
            tv.setText("Azimuth="+x+"\n Pitch ="+y+"\n  Roll= "+z);

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
        s=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);//Type of sensor we want is TYPE_ACCELEROMETER
        //phone has three dimension Azimuth,Pitch,Roll
        sm.registerListener(sel,s,SensorManager.SENSOR_DELAY_NORMAL);

    }
}