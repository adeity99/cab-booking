package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class CalCulation extends AppCompatActivity implements View.OnClickListener {
    Button ad, sub, div, mul;
    TextView result;
    EditText n1, n2;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_culation);
        ad = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        div = findViewById(R.id.div);
        mul = findViewById(R.id.mul);
        cl = findViewById(R.id.cl);
        setBackground();
        Calendar c= Calendar.getInstance();
        c.get(Calendar.HOUR_OF_DAY);
        c.get(Calendar.AM);
        result=findViewById(R.id.result);
        n1=findViewById(R.id.num1);
        n2=findViewById(R.id.num2);
        result = findViewById(R.id.result);
        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        ad.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);


    }

    void setBackground() {
        SharedPreferences pm = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, " " + pm.getString("devicename", ""), Toast.LENGTH_LONG).show();
        switch (pm.getString("bgcolor", "")) {
            case "0":
                cl.setBackgroundColor(Color.WHITE);
                break;
            case "1":
                cl.setBackgroundColor(Color.RED);
                break;
            case "2":
                cl.setBackgroundColor(Color.GREEN);
                break;
            case "3":
                cl.setBackgroundColor(Color.YELLOW);
                break;
            case "4":
                cl.setBackgroundColor(Color.GRAY);
                break;
            case "5":
                cl.setBackgroundColor(Color.BLUE);
                break;
            case "6":
                cl.setBackgroundColor(Color.rgb(253, 123, 76));
                break;
            default:
                cl.setBackgroundColor(Color.WHITE);
                break;

        }
    }

    @Override
    public void onClick(View v) {
        if (n1.getText().toString().trim().length() < 1 || n2.getText().toString().trim().length() < 1) {
            Toast.makeText(this, "Please provide value", Toast.LENGTH_SHORT).show();
        } else {
            double num1 = Double.parseDouble(n1.getText().toString().trim());
            double num2 = Double.parseDouble(n2.getText().toString().trim());
            result.setTextSize(30);
            result.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            result.setTextColor(Color.RED);
            result.setTypeface(Typeface.DEFAULT_BOLD);
            result.setTypeface(result.getTypeface(), Typeface.BOLD);

            switch (v.getId()) {
                case R.id.add:
                    result.setText("Addition of two number :" + (num1 + num2));
                    break;
                case R.id.sub:
                    result.setText("Subtraction of two number :" + (num1 - num2));
                    break;
                case R.id.div:
                    result.setText("Division of two number :" + (num1 / num2));
                    break;
                case R.id.mul:
                    result.setText("Multiplication of two number :" + (num1 * num2));
                    break;
            }
        }
    }
}