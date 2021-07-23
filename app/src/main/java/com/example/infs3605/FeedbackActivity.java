package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FeedbackActivity extends AppCompatActivity {
    private ImageButton submitButton, backButton;
    private EditText feedbackField;
    private RatingBar ratingBar;
    private ToggleButton content, ux, rewards, events, difficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        submitButton = findViewById(R.id.submitButton);
        feedbackField = findViewById(R.id.feedbackField);
        ratingBar = findViewById(R.id.ratingBar);
        content = findViewById(R.id.content);
        ux = findViewById(R.id.ux);
        rewards = findViewById(R.id.rewards);
        events = findViewById(R.id.events);
        difficulty = findViewById(R.id.difficulty);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", "0");
                intent.putExtra("Check", "5");
                startActivity(intent);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Feedback Submitted", Toast.LENGTH_SHORT).show();

            }
        });




    }
}