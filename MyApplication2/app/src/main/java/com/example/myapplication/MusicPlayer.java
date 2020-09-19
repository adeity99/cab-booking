package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MusicPlayer extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener  {
   TextView rdur,cdur,name;
   SeekBar sb;
   ImageButton play;
   MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        rdur=findViewById(R.id.rdur);
        cdur=findViewById(R.id.cdur);
        name=findViewById(R.id.songname);
        sb=findViewById(R.id.seekBar);
        play=findViewById(R.id.play);
        Bundle b=getIntent().getExtras();
        String sname=b.getString("song");
        String songdata=b.getString("songdata");
        name.setText(sname);
        mp=MediaPlayer.create(this, Uri.parse(songdata));
        rdur.setText(convertToDuration(mp.getDuration()));
        sb.setMax(mp.getDuration());
        play.setOnClickListener(this);
        sb.setOnSeekBarChangeListener(this);
        new Thread()//to run seekbar
        {
         public void run()
         {
             while(mp.getCurrentPosition()!=mp.getDuration())
             {
                 sb.setProgress(mp.getCurrentPosition());
             }
         }
        }.start();//anonymous class with no reference
    }
    String convertToDuration(long sd) {
        String dur = "";
        sd = sd / 1000;
        dur = dur + sd / 60 + ":" +sd % 60;
        return dur;
    }

    @Override
    public void onClick(View v) {
        if(!mp.isPlaying())
        {
            mp.start();
            play.setImageResource(android.R.drawable.ic_media_pause);
        }
        else
        {
            mp.pause();
            play.setImageResource(android.R.drawable.ic_media_play);
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if(b)
        {
            mp.seekTo(progress);
        }
        cdur.setText(convertToDuration(mp.getCurrentPosition()));
        rdur.setText(convertToDuration(mp.getDuration()-mp.getCurrentPosition()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}