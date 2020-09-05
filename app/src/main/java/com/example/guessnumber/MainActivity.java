package com.example.guessnumber;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.model.Answer;

public class MainActivity extends AppCompatActivity {

    Answer a;
    int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new Answer();
        //a.randomValue();


        //Log.i("MainActivity", "ค่าของ ans ="+a.getValue());

        Button guessButton = findViewById(R.id.guess_button);
        //guessButton.setText("Hello");
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText numberEditText = findViewById(R.id.number_edit_text);
                String numText = numberEditText.getText().toString();
                int num = Integer.parseInt(numText);

                Answer.GuessResult result = a.checkAnswer(num);

                //Toast t = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
                //t.show();

                TextView resultTextView = findViewById(R.id.result_text_view);

                switch(result){
                    case OK:
                        score++;
                        Log.i("MainActivity", "คะแนนทั้งหมด: "+ score);


                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("ผลลัพธ์");
                        dialog.setMessage("ถึกต้องเเด้อหล่า ");
                        dialog.setPositiveButton("เล่นอีกๆๆๆๆๆๆๆ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //todo: ทำการสุ่มเลขใหม่
                                a = new Answer();

                            }
                        });
                        dialog.setNegativeButton("พอเถอะ", null);
                        dialog.show();

                        resultTextView.setText("");
                        break;

                    case OVER:
                        /*dialog.setMessage("เยอะเกินเเด้อหล่า \n\n ");
                        dialog.setPositiveButton("OK", null);*/
                        resultTextView.setText("เยอะเกินเด้อหล่า");

                        break;

                    case UNDER:
                        /*dialog.setMessage("น้อยไปเเด้อหล่า \n\n ");
                        dialog.setPositiveButton("OK", null);*/
                        resultTextView = findViewById(R.id.result_text_view);
                        resultTextView.setText("น้อยเกินไปเด้อหล่า");

                        break;
                }




            }
        });

        Button exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle(R.string.exit_message);
                dialog.setMessage("จะออกจาก Guess Number จริงๆย๋อ ?");
                dialog.setPositiveButton("ํช่ายย", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton("หยอกๆ", null);
                dialog.show();
            }
        });

        Button scoreButton = findViewById(R.id.score_button);
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ScoreActivity.class);//รันหน้าจอใหม่
                i.putExtra("score",score);

                startActivity(i);
            }
        });





    }


}