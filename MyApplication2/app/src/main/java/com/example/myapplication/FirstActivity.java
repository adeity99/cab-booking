package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {

    EditText ed;
    Dialog d;
    AlertDialog ad;
    AlertDialog.Builder adb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        ed=findViewById(R.id.name);
    }
//creating function by inserting  android:onClick="submit" in first_activity.xml and creating a function from there
    public void submit(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setMessage("Are You Sure");
        adb.setTitle("You want to go");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name=ed.getText().toString();
                Intent intent=new Intent(FirstActivity.this,MyData.class);
                intent.putExtra("name",name);//concept of map key,value pair and putExtra gives information in the form of Bundle and in MyData.java it is received in form of Bundle by getExtra()
                startActivity(intent);

            }
        });
        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(FirstActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });
        ad=adb.create();
        ad.show();
    }
}
