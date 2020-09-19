package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=5000;
    Animation topAnimation1,bottomAnimation1;
    ImageView image;
    TextView logo,slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splashscreen2);

        //get id of animation,pass animation here
        /*here anim is the folder inside which topanimation1 and bottomanimation1 which contains details of when animation will fade away and when transition*/
        topAnimation1= AnimationUtils.loadAnimation(this,R.anim.top_animation1);
        bottomAnimation1=AnimationUtils.loadAnimation(this,R.anim.bottom_animation1);

         //get image id,textview id
        image=findViewById(R.id.imageView);
        logo=findViewById(R.id.textView);
        slogan=findViewById(R.id.textView2);

        //assign topanimation1 and bottomanimation1 to image and Textview
        image.setAnimation(topAnimation1);
        logo.setAnimation(bottomAnimation1);
        slogan.setAnimation(bottomAnimation1);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splashscreen.this,LoginActivity.class);

                Pair[] pairs=new Pair[2];
                pairs[0]= new Pair<View,String>(image,"logo_image");
                pairs[1]= new Pair<View,String>(logo,"logo_text");

                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(Splashscreen.this,pairs);
                startActivity(intent,options.toBundle());
            }
        },SPLASH_SCREEN);
/*SPLASH_SCREEN sets time to screen*/
    }
}