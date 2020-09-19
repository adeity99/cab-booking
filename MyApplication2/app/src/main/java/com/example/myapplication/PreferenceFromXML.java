package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;

public class PreferenceFromXML extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_preference_from_x_m_l);
        //the above line is commented as we have to show preference layout
        //if we use both setContent and addpreference then the error will generate your application goes bad
        addPreferencesFromResource(R.xml.mypreferencedemo);
    }
}