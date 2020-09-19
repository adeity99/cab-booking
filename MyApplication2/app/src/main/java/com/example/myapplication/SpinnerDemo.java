package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

public class SpinnerDemo extends AppCompatActivity {
    AutoCompleteTextView actv;
    MultiAutoCompleteTextView mactv;
    Spinner sp;
    String []city={"DELHI","DARBHANGA","LUCKNOW","KANPUR","DEHRADUN","LALITPUR","NOIDA","NAGPUR","NALANDA"};
    ArrayAdapter<String> ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        actv=findViewById(R.id.actv);
        mactv=findViewById(R.id.mactv);
        sp=findViewById(R.id.sp);
        ar=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city);
        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        mactv.setThreshold(1);
        mactv.setAdapter(ar);
        actv.setAdapter(ar);
        sp.setAdapter(ar);

    }
}