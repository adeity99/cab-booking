package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000;//5000 means 5sec
    //Hooks
    View first,second,third,fourth,fifth,sixth;
    TextView a,slogan;

    //Animations
    Animation topAnimation,bottomAnimation,middleAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//to remove top bar of phone
        setContentView(R.layout.activity_splashscreen);

        topAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);//R.anim(animation folder)
        middleAnimation= AnimationUtils.loadAnimation(this,R.anim.middle_animation);//call Animation

        //Create Hooks
        first=findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);
        a = findViewById(R.id.a);
        slogan = findViewById(R.id.tagLine);

        /*assign these color lines to Animation*/
        first.setAnimation(topAnimation); /*first,second,thirs...,a,slogan are all elements and set according to animation*/
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        a.setAnimation(middleAnimation);
        slogan.setAnimation(bottomAnimation);

       //calling another activty
        new Handler().postDelayed(new Runnable() {//Handler will delay the time to open another activity means after the time of splash screen is finished then handler will display another activity
            @Override
            public void run() {
                Intent intent = new Intent(SplashscreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}