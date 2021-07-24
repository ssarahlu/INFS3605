package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FeedbackSubmitted extends AppCompatActivity {

    private ImageButton returnProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_submitted);

        returnProfile = findViewById(R.id.returnProfile);
        returnProfile.setVisibility(View.VISIBLE);

        returnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", "0");
                intent.putExtra("Check", "5");
                startActivity(intent);
            }
        });


    }
}