package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Radiodemo extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    TextView tv;
    RadioGroup rg;
    Button clear;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiodemo);
        tv=findViewById(R.id.rs);
        rg=findViewById(R.id.rg);
        clear=findViewById(R.id.clear);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
             RadioButton r=findViewById(radioGroup.getCheckedRadioButtonId());
             if(r!=null)
             tv.setText(r.getText());

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg.clearCheck();
                tv.setText("");
            }
        });




    }
}