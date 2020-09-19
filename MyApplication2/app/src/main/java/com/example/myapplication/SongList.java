package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity implements AdapterView.OnItemClickListener {
   ListView lv;
   ArrayList<String> songname=new ArrayList<String>();
   ArrayList<String> songdata=new ArrayList<String>();//songdata gives location
    Cursor c;
    ArrayAdapter<String> ad;//Generic collection of string
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        c=getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,null,null,null, MediaStore.Audio.Media.DISPLAY_NAME);// content provides all information related to music player for that we have to provide external URI
        //similarly we can also get the internel storage audio files by specifying INTERNEL_CONTENT_URI
        //to sortorder by name use MediaStore.Audio.Media.DISPLAY_NAME
        while(c.moveToNext())//moves cursor to the next row relative to current position
        {
            int i=c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME);
            int j=c.getColumnIndex(MediaStore.Audio.Media.DATA);
            songname.add(c.getString(i));
            songdata.add(c.getString(j));

        }

        //Adapter takes data from a list of array and creates a view from data and AdapterView displays data just you want and we can display data in list using Listview
        lv=findViewById(R.id.songlist);
        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songname);
        lv.setAdapter(ad);//displays lists
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,MusicPlayer.class);
        intent.putExtra("song",songname.get(position));
        intent.putExtra("songdata",songdata.get(position));
        startActivity(intent);
    }
}