package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MeditateActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int tone;
    private int time;
    private TextView tvCountdown;
    private ImageView ivMedBackground, ivDropdownBackground, ivMedQuote;
    private ImageButton btnStart, btnPause, btnClose;
    private int randomQuote;

    private Spinner dropDownTimer;
    private static final String[] dropDownOptions = {"1 minute",
            "2 minutes","3 minutes", "4 minutes",
            "5 minutes","6 minutes", "7 minutes",
            "8 minutes","9 minutes","10 minutes"};


    private CountDownTimer mCountDownTimer;
    private long mTimeLeftInMillis;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate);

        Intent intent = getIntent();
        tone = intent.getIntExtra("Tone",0);



        tvCountdown = findViewById(R.id.tvCountdown);

        ivMedBackground = findViewById(R.id.ivMedBackground);
        ivDropdownBackground = findViewById(R.id.ivDropdownBackground);
        ivMedQuote = findViewById(R.id.ivMedQuote);

        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnClose = findViewById(R.id.btnClose);

        dropDownTimer = findViewById(R.id.dropDownTimer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MeditateActivity.this,
                android.R.layout.simple_spinner_item,dropDownOptions);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownTimer.setAdapter(adapter);
        dropDownTimer.setOnItemSelectedListener(this);

        switch (tone) {
            case 1:
                ivMedBackground.setImageResource(R.drawable.meditation_bg_one);
                break;
            case 2:
                ivMedBackground.setImageResource(R.drawable.meditation_bg_two);
                break;
            case 3:
                ivMedBackground.setImageResource(R.drawable.meditation_bg_three);
                break;
            case 4:
                ivMedBackground.setImageResource(R.drawable.meditation_bg_four);
                break;
        }

        randomQuote = (int)(Math.random() * 5) + 1;

        if (randomQuote == 1){
            ivMedQuote.setImageResource(R.drawable.med_quote);
        }

        switch (randomQuote) {
            case 1:
                ivMedQuote.setImageResource(R.drawable.med_quote);
                break;
            case 2:
                ivMedQuote.setImageResource(R.drawable.med_quote_two);
                break;
            case 3:
                ivMedQuote.setImageResource(R.drawable.med_quote_three);
                break;
            case 4:
                ivMedQuote.setImageResource(R.drawable.med_quote_four);
                break;
            case 5:
                ivMedQuote.setImageResource(R.drawable.med_quote_five);
                break;
            default:
                ivMedQuote.setImageResource(R.drawable.med_quote);
                break;
        }





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

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetMusic();
                launchMeditateIntroActivity();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        setTime(position + 1);
        resetMusic();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }

    private void setTime(int time) {
        this.time = time;
        mTimeLeftInMillis = time * 60000;


    }


    private void launchMeditateIntroActivity() {
        Intent intent = new Intent(MeditateActivity.this, MeditateIntroActivity.class);
        startActivity(intent);
    }

    private void startTimer() {

        btnStart.setVisibility(View.INVISIBLE);
        btnPause.setVisibility(View.VISIBLE);
        dropDownTimer.setVisibility(View.INVISIBLE);
        ivDropdownBackground.setVisibility(View.INVISIBLE);


        playMusic();

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                resetMusic();
                btnStart.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
                dropDownTimer.setVisibility(View.VISIBLE);
                ivDropdownBackground.setVisibility(View.VISIBLE);
            }
        }.start();


    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        pauseMusic();
        btnStart.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        dropDownTimer.setVisibility(View.VISIBLE);
        ivDropdownBackground.setVisibility(View.VISIBLE);
    }


    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d",minutes,seconds);

        tvCountdown.setText(timeLeftFormatted);
    }


    public void playMusic() {
        if (player == null) {
            switch (tone) {
                case 1:
                    player = MediaPlayer.create(this, R.raw.music1);
                    player.setLooping(true);
                    break;
                case 2:
                    player = MediaPlayer.create(this, R.raw.music2);
                    player.setLooping(true);
                    break;
                case 3:
                    player = MediaPlayer.create(this, R.raw.music3);
                    player.setLooping(true);
                    break;
                case 4:
                    player = MediaPlayer.create(this, R.raw.music4);
                    player.setLooping(true);
                    break;
            }
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