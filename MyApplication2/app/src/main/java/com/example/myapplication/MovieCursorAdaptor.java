package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MovieCursorAdaptor extends CursorAdapter {
    public MovieCursorAdaptor(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.mylistview,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView mn=view.findViewById(R.id.mname);
        TextView a=view.findViewById(R.id.mactor);
        TextView act=view.findViewById(R.id.mactress);
        TextView d=view.findViewById(R.id.mdirector);
        String name=cursor.getString(cursor.getColumnIndexOrThrow(Movie.Data.MNAME));
        String actor=cursor.getString(cursor.getColumnIndexOrThrow(Movie.Data.MACTOR));
        String actress=cursor.getString(cursor.getColumnIndexOrThrow(Movie.Data.MACTRESS));
        String director=cursor.getString(cursor.getColumnIndexOrThrow(Movie.Data.MDIRECTOR));
        mn.setText(name);
        a.setText(actor);
        act.setText(actress);
        d.setText(director);


    }
}
