package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HideandSeek extends AppCompatActivity implements View.OnClickListener {
    Button s;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hideand_seek);
        s=findViewById(R.id.snh);
        msg=findViewById(R.id.msg);
        s.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(s.getText().toString().equalsIgnoreCase("SHOW MESSAGE"))
        {
            msg.setVisibility(View.VISIBLE);
            s.setText("HIDE MESSAGE");
        }
        else
        {
            msg.setVisibility(View.INVISIBLE);
            s.setText("SHOW MESSAGE");
        }

    }


}