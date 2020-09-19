package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity implements View.OnClickListener {
    Button inc,dec,res;
    TextView results;
    static int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        inc=findViewById(R.id.inc);
        dec=findViewById(R.id.dec);
        res=findViewById(R.id.res);
        results=findViewById(R.id.count);
        inc.setOnClickListener(this);
        dec.setOnClickListener(this);
        res.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.inc:
                c++;
                results.setText("COUNT : "+ c);
                break;
            case R.id.dec:
                c--;
                results.setText("COUNT : "+c);
                break;
            case R.id.res:
                c=0;
                results.setText("COUNT : "+c);
                break;
        }


    }
}