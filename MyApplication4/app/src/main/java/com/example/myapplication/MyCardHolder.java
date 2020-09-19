package com.example.myapplication;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.core.Context;

public class MyCardHolder extends RecyclerView.ViewHolder {
    View view;
    public MyCardHolder(@NonNull View itemView) {
        super(itemView);
        view=itemView;
    }
    public void setView(FirebaseRecyclerAdapter<Student, MyCardHolder> context, String name, String email, String branch, String add, String phone)
    {
        TextView sname=view.findViewById(R.id.name);
        TextView semail=view.findViewById(R.id.email);
        TextView sbranch=view.findViewById(R.id.branch);
        TextView sadd=view.findViewById(R.id.add);
        TextView sphone=view.findViewById(R.id.phone);
        sname.setText(name);
        semail.setText(email);
        sbranch.setText(branch);
        sadd.setText(add);
        sphone.setText(phone);

    }
}
