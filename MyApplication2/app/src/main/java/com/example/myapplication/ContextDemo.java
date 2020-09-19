package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;

public class ContextDemo extends AppCompatActivity {
  Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_demo);
        b=findViewById(R.id.getm);
        registerForContextMenu(b);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"View");
        menu.add(0,v.getId(),0,"Delete");
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"Back");
    }
}