package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class CameraDemo2 extends AppCompatActivity {
    Button pic;
    String myfolder;
    File f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);
        pic=findViewById(R.id.button7);
        File f= Environment.getExternalStorageDirectory();
        f1=new File(f,"MyFolderApp");
        if(!f1.exists())
        {
            f1.mkdir();
        }
       pic.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

    }
}
//this program is used to capture image and save to specific location as per our requirement
