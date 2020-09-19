package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name, branch, add, phone, email;
    Button reg,show;
    FirebaseDatabase fd;
    DatabaseReference dbr;
    static int sid = 0;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        branch = findViewById(R.id.branch);
        add = findViewById(R.id.add);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        reg = findViewById(R.id.register);
        show=findViewById(R.id.sd);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ShowData.class);
                startActivity(i);
            }
        });
        s=new Student();
        reg.setOnClickListener(this);
        dbr=fd.getInstance().getReference().child("Student");
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                 sid=(int)dataSnapshot.getChildrenCount();
                }
                else
                {

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "data base created", Toast.LENGTH_SHORT).show();
        s.setName(name.getText().toString());
        s.setBranch(branch.getText().toString());
        s.setAdd(add.getText().toString());
        s.setPhone(phone.getText().toString());
        s.setEmail(email.getText().toString());
        dbr.child(String.valueOf(sid+1)).setValue(s);

    }
}