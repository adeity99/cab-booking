package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyData extends AppCompatActivity {
   TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        tv=findViewById(R.id.data);
        Bundle b=getIntent().getExtras();//all the extra thing inside bundle is to be taken
        tv.setText(b.getString("name"));
    }
}