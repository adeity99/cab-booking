package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Jumbledword extends AppCompatActivity  implements View.OnClickListener {
    private TextView wordTv;
    private EditText wordEnteredTv;
    private Button validate,newgame;
    private String wordToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jumbledword);
        wordTv=(TextView)findViewById(R.id.word_tv);
        wordEnteredTv=(EditText) findViewById(R.id.wordEnteredEt);
        validate=(Button)findViewById(R.id.validate);
        newgame=(Button)findViewById(R.id.newgame);
        validate.setOnClickListener(this);
        newgame.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==validate)
        {
            validate();
        }
        else if(v==newgame){
            newGame();
        }

    }
    private void validate(){
        String w=wordEnteredTv.getText().toString();
        if(wordToFind.equalsIgnoreCase(w)){
            Toast.makeText(this,"Congratulations ...!you found the word"+wordToFind,Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Try again !",Toast.LENGTH_SHORT).show();
        }
    }
    private void newGame()
    {
        wordToFind = Jumbledwordpart.randomword();
        String wordShuffled = Jumbledwordpart.shuffleword(wordToFind);
        wordTv.setText(wordShuffled);
        wordEnteredTv.setText("");
    }

}