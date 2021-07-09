package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.MeditationGuide;

import java.util.ArrayList;

public class MeditateActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "time";
    private int time;
    private TextView tvCountdown, tvMeditationText;
    private ImageButton btnStart, btnPause, btnReset, btnClose;

    private ArrayList<MeditationGuide> meditationGuide;
    private long quoteChangeInterval;
    private int quoteCounter;

    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate);

        Intent intent = getIntent();
        time = intent.getIntExtra("Time",0);



        mTimeLeftInMillis = time * 60000;
        meditationGuide = MeditationGuide.getMeditationGuide();
        quoteChangeInterval = time * 60 / 12;

        tvCountdown = findViewById(R.id.tvCountdown);
        tvMeditationText = findViewById(R.id.tvMeditationText);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnReset = findViewById(R.id.btnReset);
        btnClose = findViewById(R.id.btnClose);



        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               pauseTimer();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMeditateFragment();
            }
        });

        startTimer();
    }

    private void launchMeditateFragment() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("id", "0");
        intent.putExtra("Check", "4");
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Back to meditate ", Toast.LENGTH_SHORT).show();
    }

    private void startTimer() {

        btnStart.setVisibility(View.INVISIBLE);
        btnPause.setVisibility(View.VISIBLE);
        btnReset.setVisibility(View.INVISIBLE);

        playMusic();

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

                if ((mTimeLeftInMillis + 1000) / 1000 % quoteChangeInterval == 0) {
                    updateMeditationText();
                }
            }

            @Override
            public void onFinish() {
                resetMusic();
                btnStart.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        pauseMusic();
        btnStart.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = time * 60000;
        resetMusic();
        updateCountDownText();
        quoteCounter = 0;
        btnStart.setVisibility(View.VISIBLE);
    }

    private void updateMeditationText() {
        tvMeditationText.setText(meditationGuide.get(quoteCounter++).getGuideText());
        if (quoteCounter == 11) {
            quoteCounter = 0;
        }
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d",minutes,seconds);

        tvCountdown.setText(timeLeftFormatted);
    }


    public void playMusic() {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.music);
            player.setLooping(true);
        }

        player.start();
    }

    public void pauseMusic() {
        if (player != null) {
            player.pause();
        }
    }

    public void resetMusic() {
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        resetMusic();
    }




}