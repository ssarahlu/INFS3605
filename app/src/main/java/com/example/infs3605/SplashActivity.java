package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    private ImageView ack, logo, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ack = findViewById(R.id.ack);
        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);

        ack.setVisibility(View.INVISIBLE);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                logo.setVisibility(View.VISIBLE);
                Intent ackIntent = new Intent(SplashActivity.this, SplashAcknowledgementActivity.class);
                startActivity(ackIntent);
                overridePendingTransition(0, 0);
                finish();
            }
        }, SPLASH_TIME_OUT);



    }



}