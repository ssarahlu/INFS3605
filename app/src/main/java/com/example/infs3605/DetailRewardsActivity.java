package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.AccountAchievement;
import com.example.infs3605.Entities.Rewards;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class DetailRewardsActivity extends AppCompatActivity {

    private TextView shopTV, rewardTV, detailTV, starsTV, qrTV;
    private ImageView rewardIV, qrIV;
    private ImageButton copy, redeemButton, backButton;

    private boolean redeemed, achieved;
    private String email, id;
    private int rewardId, userStars;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());
    MyDatabase myDb;

    private List<AccountAchievement> mAccAchs = new ArrayList<>();
    private ArrayList<Rewards> mRewards = new ArrayList<>();
    private Rewards reward;

    private static final String TAG = "DetailRewardsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rewards);

        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        System.out.println(id);
        rewardId = Integer.valueOf(id);
        System.out.println(rewardId);
        email = intent.getStringExtra("email");
        mRewards = Rewards.getRewards();


        shopTV = findViewById(R.id.shopTV);
        rewardTV = findViewById(R.id.rewardTV);
        detailTV = findViewById(R.id.detailTV);
        starsTV = findViewById(R.id.starsTV);
        qrTV = findViewById(R.id.qrTV);

        rewardIV = findViewById(R.id.rewardIV);
        qrIV = findViewById(R.id.qrIV);

        copy = findViewById(R.id.copy);
        redeemButton = findViewById(R.id.redeemButton);
        backButton = findViewById(R.id.backButton);


        copy.setVisibility(View.GONE);
        qrTV.setVisibility(View.GONE);
        redeemButton.setVisibility(View.GONE);

        for (Rewards r : mRewards) {
            if (r.getRewardId() == rewardId) {
                reward = r;
            }
        }

        //set elements that don't change depending on whether user has redeemed/earnt reward yet
        shopTV.setText(reward.getShop());
        rewardTV.setText(reward.getOffer());
        detailTV.setText(reward.getDetail());
        starsTV.setText(reward.getStars() + "");
        Glide.with(this).load(reward.getUrl()).into(rewardIV);


        new GetAccountAchievements().execute();


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RewardsActivity.class);
                startActivity(intent);
            }
        });

        redeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateRedemption().execute();
                Toast.makeText(getApplicationContext(), "Your reward has been redeemed!", Toast.LENGTH_SHORT).show();
                qrIV.setImageResource(R.drawable.redeem_success);

                copy.setVisibility(View.GONE);
                qrTV.setVisibility(View.GONE);
                redeemButton.setVisibility(View.GONE);

                new UpdateRedemption().execute();

            }
        });


        //can copy the qr code to clipboard
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

                if (reward.getQrCode() != null){
                    ClipData clip = ClipData.newPlainText("Copied Text", reward.getQrCode());
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(getApplicationContext(), "QR Code copied to clipboard!", Toast.LENGTH_SHORT).show();

                }

            }
        });





    }

    //gets all the users account achievements to display the rewards appropriately
    private class GetAccountAchievements extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
//            mAccAchs = myDb.accountAchievementDao().getAccAch(email);
            redeemed = myDb.accountAchievementDao().getRedeemed(email, rewardId);
            Log.d(TAG, "doInBackground: redeemed " + redeemed);

            Log.d(TAG, "doInBackground: ASYNC TASK  ");
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
            updateUi();
            myDb.close();

        }

    }


    private void updateUi() {

        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){

                            //set number of stars user has in top bar

                            userStars = Integer.parseInt("" + documentSnapshot.get("stars"));

                            if (userStars >= reward.getStars()){
                                achieved = true;
                                Log.d(TAG, "onSuccess: " + (userStars >= reward.getStars()));
                                Log.d(TAG, "onSuccess: " + achieved + " " + userStars + " " + reward.getStars());
                            }

                            //they haven't achieved the reward yet - not enough stars
                            if (achieved == false) {
                                copy.setVisibility(View.GONE);
                                redeemButton.setVisibility(View.GONE);
                                qrTV.setVisibility(View.GONE);
                                qrIV.setImageResource(R.drawable.not_enough_stars_reward);
                                Log.d(TAG, "updateUi: Achieved false");

                                //they've achieved it but haven't redeemed it yet
                            } else if ((achieved == true) && (redeemed == false)) {
                                copy.setVisibility(View.VISIBLE);
                                redeemButton.setVisibility(View.VISIBLE);
                                qrTV.setVisibility(View.VISIBLE);
                                qrTV.setText(reward.getQrCode() + "");
                                qrIV.setImageResource(R.drawable.qr);
                                Log.d(TAG, "updateUi: Achieved true, redeemed false " );

                                //achieved it and redeeemed it
                            } else if ((achieved == true) && (redeemed == true)) {
                                copy.setVisibility(View.GONE);
                                redeemButton.setVisibility(View.GONE);
                                qrTV.setVisibility(View.GONE);
                                qrIV.setImageResource(R.drawable.redeemed_reward);

                                Log.d(TAG, "updateUi: Achieved true, redeemed true");

                            }

                        }
                    }
                });




    }

    //after user clicks redeem, will update the database
    private class UpdateRedemption extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            myDb.accountAchievementDao().updateRedeemed(true, email, rewardId);
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

}