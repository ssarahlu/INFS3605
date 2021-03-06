package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.AccountAchievement;
import com.example.infs3605.Entities.Levels;
import com.example.infs3605.Entities.Rewards;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class RewardsActivity extends AppCompatActivity {
    private ImageButton backButton;
    private TextView userStars;
    private RecyclerView mRecyclerView;
    private ArrayList<Rewards> mRewards = new ArrayList<>();
    private List<AccountAchievement> mAccAchs = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private String email;
    private int rewardId;
    RewardsAdapter.RecyclerViewClickListener listener;
    private static final String TAG = "RewardsActivity";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());
    MyDatabase myDb;
    private int mStars;
    private int achievementId;

    private int[] starSaved = new int [1];
//    private ArrayList<Integer> starSavedAR = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);
        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        backButton = findViewById(R.id.backButton);
        userStars = findViewById(R.id.userStars);

        for (Rewards r : Rewards.getRewards()){
            mRewards.add(r);
        }


        email = user.getEmail();

        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){

                            //set number of stars user has in top bar

                            mStars = Integer.parseInt("" + documentSnapshot.get("stars"));

                            userStars.setText(mStars + "");

                            starSaved[0] = mStars;


                        }
                    }
                });

        new GetAccountAchievements().execute();


        new InsertAccountAchievements().execute();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        listener = new RewardsAdapter.RecyclerViewClickListener() {
            public void onClick(View view, int position) {
                Rewards r = mRewards.get(position);
                rewardId = r.getRewardId();
                launchRewardDetail();
            }
        };



        mAdapter = new RewardsAdapter(mRewards, mAccAchs, listener);
        mRecyclerView.setAdapter(mAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", "0");
                intent.putExtra("Check", "5");
                startActivity(intent);
            }
        });




    }

    private void launchRewardDetail() {
        Intent intent = new Intent(this, DetailRewardsActivity.class);
        intent.putExtra("id", String.valueOf(rewardId));
        Log.d(TAG, "launchRewardDetail: " + rewardId);
        intent.putExtra("email", email);
        Log.d(TAG, "launchRewardDetail: " + email);
        startActivity(intent);

    }


    //gets all the different account achievements of the user so that we can display the rewards accordingly
    //e.g. user will not be able to see the QR codes of rewards they haven't received yet
    private class GetAccountAchievements extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            mAccAchs = myDb.accountAchievementDao().getAccAch(email);
            Log.d(TAG, "doInBackground: ASYNC TASK  ");
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
            myDb.close();

        }

    }

    //inserts a new achievement if the user has met the condition (e.g. over 20 stars earnt)
    private class InsertAccountAchievements extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db").allowMainThreadQueries()
                    .build();

            userRef.get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()){

                                mStars = Integer.parseInt("" + documentSnapshot.get("stars"));

                                for (Rewards r : mRewards) {
                                    Log.d(TAG, "doInBackground: r.getStars " + r.getStars() + " " +  mStars);

                                    if (r.getStars() < mStars) {
                                        Log.d(TAG, "doInBackground:  in if statement to check stars ");
                                        achievementId = r.getRewardId();
                                        mAccAchs.add(new AccountAchievement(email, achievementId, true, false));
                                        myDb.accountAchievementDao().insertSingle(email, achievementId, true, false);

                                        Log.d(TAG, "doInBackground: insert single " + email + achievementId );
                                    }
                                }

                            }
                        }
                    });


            Log.d(TAG, "doInBackground: ASYNC TASK  ");
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
            mAdapter = new RewardsAdapter(mRewards, mAccAchs, listener);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            myDb.close();

        }

    }





}