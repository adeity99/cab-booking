package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewDemo extends AppCompatActivity implements View.OnClickListener {

    WebView w;
    EditText ed;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);
        w=findViewById(R.id.wv);
        b=findViewById(R.id.button6);
        ed=findViewById(R.id.editText3);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url=ed.getText().toString();
        w.setWebViewClient(new WebClientDemo());
        w.getSettings().setJavaScriptEnabled(true);//enable java script as it used in web development or u can say Client server
        w.loadUrl(url);
    }

    private class WebClientDemo extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
           view.loadUrl(url);
           return true;
        }
    }
}
