package com.example.guessnumber;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        int score = i.getIntExtra("score",0);
        Log.i("MainActivity","ค่าของScore"+score);

        TextView scoreTextView = findViewById(R.id.score_textview);
        scoreTextView.setText(""+score);

    }
}