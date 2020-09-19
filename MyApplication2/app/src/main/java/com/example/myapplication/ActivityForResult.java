package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityForResult extends AppCompatActivity implements View.OnClickListener {
    TextView tv;
    Button bt;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        tv=findViewById(R.id.result);
        bt=findViewById(R.id.clickme);
        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, ActivityResult.class);
        startActivityForResult(intent,1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000 && resultCode==1000)
        {
            Bundle b=data.getExtras();
            tv.setText(b.getString("msg"));
        }
    }
}

