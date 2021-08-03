package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FeedbackActivity extends AppCompatActivity {
    private ImageButton submitButton, backButton;
    private EditText feedbackField;
    private RatingBar ratingBar;
    private ToggleButton content, ux, rewards, events, difficulty;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private CollectionReference feedbackRef = db.collection("feedback");
    private static final String TAG = "FeedbackActivity";

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
                Map<String, Object> feedback = new HashMap<>();
                feedback.put("author", user.getEmail());
                feedback.put("authorID", user.getUid());
                feedback.put("feedback", feedbackField.getText().toString());
                feedback.put("rating", ratingBar.getRating());

                if (content.isChecked() == true){
                    feedback.put("topic_content", true);
                } else {
                    feedback.put("topic_content", false);
                }

                if (difficulty.isChecked() == true){
                    feedback.put("topic_difficulty", true);

                } else {
                    feedback.put("topic_difficulty", false);

                }

                if (events.isChecked() == true){
                    feedback.put("topic_events", true);

                } else {
                    feedback.put("topic_events", false);

                }


                if (rewards.isChecked() == true){
                    feedback.put("topic_rewards", true);

                } else {
                    feedback.put("topic_rewards", false);

                }

                if (ux.isChecked() == true){
                    feedback.put("topic_ux", true);
                } else {
                    feedback.put("topic_ux", false);
                }

                feedbackRef.document().set(feedback)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "Profiles Document successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });

                Intent intent = new Intent(getApplicationContext(), FeedbackSubmitted.class);
                startActivity(intent);



            }
        });






    }
}