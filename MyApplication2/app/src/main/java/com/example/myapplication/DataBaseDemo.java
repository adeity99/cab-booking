package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DataBaseDemo extends AppCompatActivity {
    MovieDataBaseHelper mdb;
    SQLiteDatabase sd;
    ListView lv;
    Button addrecord;
    View.OnClickListener reg=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Dialog d = new Dialog(DataBaseDemo.this);
            d.setContentView(R.layout.moviewregistration);//set layout of moviewregistration in DataBaseDemo activity
            d.show();
            final EditText name = d.findViewById(R.id.name);//we used d.findViewById bcoz it is layout of different activity
            final EditText actor = d.findViewById(R.id.actor);
            final EditText actress = d.findViewById(R.id.actress);
            final EditText director = d.findViewById(R.id.director);
            Button r = d.findViewById(R.id.addmovie);
            r.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n = name.getText().toString();
                    String a = name.getText().toString();
                    String ac = name.getText().toString();
                    String di = name.getText().toString();
                    mdb.addRecord(sd, n, a, ac, di);
                    Toast.makeText(DataBaseDemo.this, "Data Added", Toast.LENGTH_SHORT).show();
                    d.dismiss();

                }
            });
        }
    };//annonomous implementation of activity class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_demo);
        mdb=new MovieDataBaseHelper(this);
        sd=mdb.getWritableDatabase();
        addrecord=findViewById(R.id.button5);
        addrecord.setOnClickListener(reg);
        lv=findViewById(R.id.mlist);
        getData();
        if(sd!=null)
        {
            Toast.makeText(this, "Data Base Created", Toast.LENGTH_SHORT).show();
        }
    }
    void getData()
    {
        Cursor c=mdb.getRecord(sd);
        MovieCursorAdaptor mca=new MovieCursorAdaptor(this,c);
       lv.setAdapter(mca);

    }

}