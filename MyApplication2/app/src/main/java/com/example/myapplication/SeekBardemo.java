package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;

public class SeekBardemo extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar red,green,blue;
    ConstraintLayout c1;
    Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bardemo);
        red=findViewById(R.id.r);
        green=findViewById(R.id.g);
        blue=findViewById(R.id.b);
        c1=findViewById(R.id.cl);
        s=findViewById(R.id.switch1);
        red.setVisibility(View.INVISIBLE);
        green.setVisibility(View.INVISIBLE);
        blue.setVisibility(View.INVISIBLE);
        c1.setBackgroundColor(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    red.setVisibility(View.VISIBLE);
                    green.setVisibility(View.VISIBLE);
                    blue.setVisibility(View.VISIBLE);
                }
                else
                {
                    red.setVisibility(View.INVISIBLE);
                    green.setVisibility(View.INVISIBLE);
                    blue.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        c1.setBackgroundColor(Color.rgb(red.getProgress(),green.getProgress(),blue.getProgress()));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}