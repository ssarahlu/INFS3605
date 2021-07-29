package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MeditateIntroActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "module_id";

    ImageButton btnBack, btnMedIconOne, btnMedIconTwo, btnMedIconThree, btnMedIconFour;
    ImageView ivMeditateTitle, ivMeditateDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditate_intro);

        btnBack = findViewById(R.id.btnBack);
//        ivMeditateTitle = findViewById(R.id.ivMeditateTitle);
//        ivMeditateDesc = findViewById(R.id.ivMeditateDesc);
        btnMedIconOne = findViewById(R.id.btnMedIconOne);
        btnMedIconTwo = findViewById(R.id.btnMedIconTwo);
        btnMedIconThree = findViewById(R.id.btnMedIconThree);
        btnMedIconFour = findViewById(R.id.btnMedIconFour);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeditateIntroActivity.this, ModuleSelection.class);
                intent.putExtra(EXTRA_MESSAGE, 4);
                intent.putExtra("Module", "Dadirri - Deep Listening");
                intent.putExtra("Description", "In this lesson you will learn about tbe Aboriginal practice of deep listening, an almost spiritual skill, based on respect. Sometimes called 'dadirri', deep listening is inner, quiet, still awareness, and waiting.");
                intent.putExtra("id", "4");
                startActivity(intent);
            }
        });

        btnMedIconOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMeditateActivity(1);
            }
        });

        btnMedIconTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMeditateActivity(2);
            }
        });

        btnMedIconThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMeditateActivity(3);
            }
        });

        btnMedIconFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchMeditateActivity(4);
            }
        });
    }

    private void launchMeditateActivity(int tone) {

        Intent intent = new Intent(MeditateIntroActivity.this, MeditateActivity.class);
        intent.putExtra("Tone", tone);
        startActivity(intent);

    }
}