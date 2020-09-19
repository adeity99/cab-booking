package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
//if parent class doesn't has default constructor then we can call it with the help of super like
// public MovieDataBaseHelper(Context context) {
//super(context, DB_NAME, null, DB_VERSION);}
public class MovieDataBaseHelper extends SQLiteOpenHelper {
    Context c;
    public static final String TABLE_NAME = Movie.Data.TABLE_NAME;
    public static final String DB_NAME = "moviedatabase";
    public static final int DB_VERSION = 1;
    private static final String Query = "create table if not exists " + Movie.Data.TABLE_NAME + " ( " + Movie.Data.ROW_ID+" integer PRIMARY KEY autoincrement ,"+Movie.Data.MNAME + " varchar , "
            + Movie.Data.MACTOR + " varchar , " + Movie.Data.MACTRESS + " varchar , " + Movie.Data.MDIRECTOR + " varchar ) ";

    public MovieDataBaseHelper(Context context) {
        //factory can be null also
        //factory gives rights to choose which data should be accessed from database thats why it is also called cursor factory
        super(context, DB_NAME, null, DB_VERSION);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Query);
        Toast.makeText(c, "DataBase-Created", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Movie.Data.TABLE_NAME);
        onCreate(db);

    }

    public void addRecord(SQLiteDatabase sd, String mname, String actor, String actress, String director) { //utilization of collection is seen below
        ContentValues c = new ContentValues();
        c.put(Movie.Data.MNAME, mname);
        c.put(Movie.Data.MACTOR, actor);
        c.put(Movie.Data.MACTRESS, actress);
        c.put(Movie.Data.MDIRECTOR, director);
        // we have to write all the data
        sd.insert(Movie.Data.TABLE_NAME, null, c);
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();

    }

    public void deleteRecord(SQLiteDatabase sd,String name)
    {

     sd.delete(Movie.Data.TABLE_NAME,Movie.Data.MNAME+"="+name,null);
    }

    public Cursor getRecord(SQLiteDatabase sd) {
        String[] col = {Movie.Data.ROW_ID,Movie.Data.MNAME, Movie.Data.MACTOR, Movie.Data.MACTRESS, Movie.Data.MDIRECTOR};
        Cursor cursor = sd.query(Movie.Data.TABLE_NAME, col, null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
            return cursor;
    }
}

