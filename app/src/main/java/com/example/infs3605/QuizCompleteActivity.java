package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuizCompleteActivity extends AppCompatActivity {

    private ImageButton returnHome;
    private TextView addedStars, result, finished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_complete);

        returnHome = findViewById(R.id.returnHome);
        addedStars = findViewById(R.id.addedStars);
        result = findViewById(R.id.result);
        finished = findViewById(R.id.finished);

        Intent intent = getIntent();

        addedStars.setText(intent.getStringExtra("addedStars"));
        finished.setText(intent.getStringExtra("finished"));
        result.setText(intent.getStringExtra("result"));

        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }
}