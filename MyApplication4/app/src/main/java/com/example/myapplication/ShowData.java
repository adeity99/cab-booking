package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ShowData extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference dbr;
    FirebaseDatabase fd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        recyclerView=findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fd=FirebaseDatabase.getInstance();
        dbr=fd.getReference("Student");

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Student,MyCardHolder> fra=new FirebaseRecyclerAdapter<Student, MyCardHolder>(Student.class,R.layout.mydata,MyCardHolder.class,dbr) {

            @Override
            protected void populateViewHolder(MyCardHolder myCardHolder, Student student, int i) {
                myCardHolder.setView(this,student.getName(),student.getEmail(), student.getPhone(), student.getAdd(), student.getBranch());
            }
        };
        recyclerView.setAdapter(fra);
    }
}