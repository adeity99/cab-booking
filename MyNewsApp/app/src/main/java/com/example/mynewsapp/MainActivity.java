package com.example.mynewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import parameter.Articles;
import parameter.Headlines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    final String API_KEY="5b17802d380f4c918923f79e1362289c";
    Button refreshButton;
    List<Articles> articles=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        refreshButton=findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String country=getCountry();
        fetchJSON(country,API_KEY);
    }

    private void fetchJSON(String country, String api_key) {
        Call<Headlines> call=Client.getInstance().getApi().getHeadlines(country,API_KEY);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if(response.isSuccessful() && response.body().getArticles()!=null)
                {
                    articles.clear();
                    articles=response.body().getArticles();
                    adapter = new Adapter(MainActivity.this,articles);
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Check Your Internet Connection",Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getCountry() {
        Locale locale=Locale.getDefault();
        String country=locale.getCountry();
        return country.toLowerCase();
    }

}