package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBardemo extends AppCompatActivity {
    ProgressBar pr;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bardemo);
        tv = findViewById(R.id.tv);
        pr = findViewById(R.id.pb);
        new Thread() {
            public void run()
            {
                try {
                    for (int i = 0; i <= 100; i++)
                    {
                        pr.setProgress(i);
                        Thread.sleep(200);
                    }
                    pr.setVisibility(View.INVISIBLE);
                    tv.setText("COMPLETED....!!!");

                }
                catch (Exception e)
                {
                }
            }

        }.start();
    }
}

