package com.example.guessnumber.model;

import android.util.Log;

import java.util.Random;

public class Answer {

    private int value;

    public Answer() {
        randomValue();
        Log.i("MainActivity", "ค่าของ ans ="+this.value);
    }

    public enum GuessResult{
        OVER,
        UNDER,
        OK
    }

    public void randomValue(){
        Random r = new Random();
        this.value = r.nextInt(100);
    }

    public GuessResult checkAnswer(int guess){
        GuessResult result;

        if(guess== this.value){
            result = GuessResult.OK;
        }
        else if (guess > this.value){
            result = GuessResult.OVER;
        }
        else{
            result = GuessResult.UNDER;
        }

        return result;
    }
}
