package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Timer time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                if(new user(splash.this).getId() != " "){

                 Intent in=  new Intent(splash.this,Homepage.class);
                    startActivity(in);
                    finish();
                }
                else {
                   Intent inte= new Intent(splash.this,MainActivity.class);
                    startActivity(inte);
                    finish();
                }

            }
        },2000);
    }
}
