package com.example.myapplication;
//It display a screen with some text fields, whose value are saved when the application is closed and brought back when it is opened again.

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class PreferenceFromJava extends AppCompatActivity {
    EditText ed;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference_from_java);
        ed=findViewById(R.id.msg);
        sp=getSharedPreferences("mypref",MODE_PRIVATE);//In order to use shared preferences, you have to call a method getSharedPreferences() that returns a SharedPreference instance pointing to the file that contains the values of preferences.
        ed.setText(sp.getString("mydata",""));//Shared Preferences allow you to save and retrieve data in the form of key,value pair.

    }

    @Override
    protected void onStop() {
        super.onStop();
        String data=ed.getText().toString();
        SharedPreferences.Editor se=sp.edit();//
        se.putString("mydata",data);
        se.commit();
    }
}
//You can save something in the sharedpreferences by using SharedPreferences.Editor class. You will call the edit method of SharedPreference instance and will receive it in an editor object.//
//Its syntax is −
//
//Editor editor = sharedpreferences.edit();
//editor.putString("key", "value");
//editor.commit();