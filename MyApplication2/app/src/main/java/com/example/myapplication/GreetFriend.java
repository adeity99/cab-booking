package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class GreetFriend extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_friend);
        Button btn = (Button) findViewById(R.id.Button01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Date da = new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(da);
                    int hours = cal.get(Calendar.HOUR_OF_DAY);
                    int min = cal.get(Calendar.MINUTE);

                    if(hours>=6 && hours<=12){
                        Toast.makeText(GreetFriend.this, "Good Morning", Toast.LENGTH_SHORT).show();
                    }else if(hours>=0 && hours<=17){
                        Toast.makeText(GreetFriend.this, "Good Afternoon", Toast.LENGTH_SHORT).show();
                    }else if(hours>=17 && hours<=21){
                        Toast.makeText(GreetFriend.this, "Good evening", Toast.LENGTH_SHORT).show();
                    }else if(hours>=21&& hours<=6){
                        Toast.makeText(GreetFriend.this, "Good night", Toast.LENGTH_SHORT).show();
                    }
                }


        });
    }
}
