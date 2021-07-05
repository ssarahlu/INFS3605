package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Facts;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //THIS IS THE HOME SCREEN

    private TextView factTV;
    private ArrayList<Facts> mFacts = new ArrayList<>();
    private int factNumber;
    private Facts fact;
    private ImageButton artButton;
    public static final String TOPIC_ID = "topic_id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        factTV = findViewById(R.id.factTV);
        artButton = findViewById(R.id.artButton);

        for (Facts f : Facts.getFacts()) {
            mFacts.add(f);

        }

        if (mFacts != null){
            factNumber = (int)(Math.random() * mFacts.size() - 1) + 1;
            System.out.println( "my random number is " + factNumber);
            fact = mFacts.get(factNumber);
            System.out.println(fact);
            factTV.setText(fact.getFact());

        }

        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleActivity.class);
                intent.putExtra(TOPIC_ID, "0");
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Art selected", Toast.LENGTH_SHORT).show();

            }
        });



    }





}
