package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileDemo extends AppCompatActivity   {
EditText fname,fdata;
Button save,search;
File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_demo);
        File dir=Environment.getExternalStorageDirectory();
        fname =findViewById(R.id.editText1);
        fdata=findViewById(R.id.editText2);
        f=new File(dir,"ict2020");
        save=findViewById(R.id.button1);
        search=findViewById(R.id.button2);

        f=new File(dir,"ict2020");
        if(!f.exists())
        {
            Toast.makeText(this, "File created", Toast.LENGTH_SHORT).show();
            f.mkdir();
        }
        else
        {
            Toast.makeText(this, "File Exists", Toast.LENGTH_SHORT).show();
        }

    }

    public void addFile(View view) {
        try {
            String name=fname.getText().toString();
            String data=fdata.getText().toString();
            FileOutputStream fos=new FileOutputStream(f.getAbsolutePath()+File.separator+name,true);
           fos.write(data.getBytes());
           fos.close();
           fdata.setText("");
        }
        catch(Exception e)
        {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void searchFile(View view) {
        try {
            String name = fname.getText().toString();
            File f1 = new File(f, name);
            if (f1.exists()) {
                FileInputStream fis = new FileInputStream(f1.getAbsolutePath());
                Scanner sc=new Scanner(fis);
                String s="";
                while(sc.hasNext())
                {
                   s=s+sc.nextLine() ;
                }
                fdata.setText(s);

            } else {
                Toast.makeText(this, "FILE NOT EXISTS", Toast.LENGTH_SHORT).show();
                fdata.setText("");
            }
        }
        catch (Exception e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            fdata.setText("");
        }

        }
    }