package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.infs3605.Entities.Levels;
import com.example.infs3605.Entities.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference profilesRef = db.collection("profiles");

    private LeaderboardAdapter mAdapter;
    private LeaderboardTop3Adapter mAdapter2;

    private RecyclerView mRecyclerView, mRecyclerView2;

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        getSupportActionBar().hide();
        mRecyclerView = findViewById(R.id.rvLeaderBoard);
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView2 = findViewById(R.id.rvLeaderBoard2);
        mRecyclerView2.setHasFixedSize(true);

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

        ArrayList<Profile> profiles = new ArrayList<>();
        profilesRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    // Gets all profiles, and loads the data into the Profiles Array List
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
//                               //email, String displayName, String fname, String lname,
//                               String levelAnimal, String levelAnimalIcon, int stars, int level
                                String levelAnimal = "";
                                String levelAnimalIcon = "" ;
                                int level = 1;

                                int userStars = Integer.parseInt(documentSnapshot.get("stars").toString());

                                if (userStars >= 0){
                                    profiles.add(new Profile(documentSnapshot.get("email").toString(),
                                            documentSnapshot.get("name").toString(),
                                            documentSnapshot.getString("fname"),
                                            documentSnapshot.getString("lname"),
                                            levelAnimal,
                                            levelAnimalIcon,
                                            Integer.parseInt(documentSnapshot.get("stars").toString()),
                                            level));
                                }


                            }

                            // Adds profiles into the Leaderboard Adapter and sorts by the topic selected
                            mAdapter = new LeaderboardAdapter(profiles);
                            mAdapter.sort();

                            mRecyclerView.setAdapter(mAdapter);
                            mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

                            mAdapter2 = new LeaderboardTop3Adapter(profiles);
                            mAdapter2.sort();
                            mRecyclerView2.setAdapter(mAdapter2);


                        }
                    }
                });


    }
}