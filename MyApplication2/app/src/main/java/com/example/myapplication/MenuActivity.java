package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuActivity extends Activity implements AdapterView.OnItemClickListener {
    String act[] = {"CameraDemo","MapsActivity","BlueToothDemo","WifiDemo","BroadcastTest","BroadCastDemo","WebViewDemo","SongList","LightSensor","TextSpeech","ProximityDemo","AccelroSensor","SensorList","DataBaseDemo",
            "FileDemo","ActivityLifeCycle","PreferenceFromXML","PreferenceFromJava", "ActivityForResult",
            "NotificationDemo", "ContextDemo", "ProgressBardemo", "OptionDemo", "Radiodemo", "Jumbledword",
            "SpinnerDemo", "CalCulation", "CounterActivity", "FirstActivity", "MainActivity",
            "HideandSeek", "SeekBardemo"};
    ArrayAdapter<String> ad;
     ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lv=findViewById(R.id.mylist);
        ad = new ArrayAdapter<String>(this,R.layout.activity_light_sensor,R.id.textView5, act);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sp = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor se = sp.edit();
        se.putString("mydata","");
        se.commit();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try {
            String s = "com.example.myapplication." + act[position];
            Class c = Class.forName(s);
            Intent intent = new Intent(MenuActivity.this, c);
            startActivity(intent);
        } catch (Exception e) {

        }

    }
}
