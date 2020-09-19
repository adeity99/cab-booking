package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityResult extends AppCompatActivity implements View.OnClickListener {
    EditText ed;
    Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        ed=findViewById(R.id.data);
        finish=findViewById(R.id.finish);
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String data=ed.getText().toString();
        Intent i=new Intent();
        i.putExtra("msg",data);
        setResult(1000,i);
        finish();



    }
}