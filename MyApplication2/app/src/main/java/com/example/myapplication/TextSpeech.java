package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TextSpeech extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText ed;
    Button b;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_speech);
        ed = findViewById(R.id.tt);
        b = findViewById(R.id.tts);
        tts = new TextToSpeech(this, this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();

            }
        });

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int r = tts.setLanguage(Locale.UK);
            if (r == TextToSpeech.LANG_MISSING_DATA || r == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            } else {
                b.setEnabled(true);
                speak();

            }
        }
            else
            {
                Toast.makeText(this, "Problem in lang.", Toast.LENGTH_SHORT).show();
            }
        }
        void speak()
        {
        String text=ed.getText().toString();
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }
}