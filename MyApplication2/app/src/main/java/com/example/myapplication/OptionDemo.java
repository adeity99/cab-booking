package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class OptionDemo extends AppCompatActivity implements View.OnClickListener {

    Button b;
    PopupMenu p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_demo);
        b=findViewById(R.id.button);
        b.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        Toast.makeText(this, "TRY!"+item.getTitle().toString(), Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public void onClick(View v) {
        p=new PopupMenu(this,b);
        p.getMenuInflater().inflate(R.menu.mymenu,p.getMenu());
        p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                b.setText(item.getTitle());
                return false;
            }
        });
        p.show();
    }
}