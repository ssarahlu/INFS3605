package com.example.infs3605;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.AccountAchievement;
import com.example.infs3605.Entities.Rewards;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

//adapter class to display all the rewards in a recycler view
public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.MyViewHolder> {
    private ArrayList<Rewards> mRewards;
    private List<AccountAchievement> mAccountAchievements = new ArrayList<>();
    private Rewards mReward;
    private AccountAchievement mAccAch;
    private int mStars, mTotal;
    private RecyclerViewClickListener mListener;
    private Context context;
    MyDatabase myDb;
    private String email;
    private static final String TAG = "MyAdapter";
    private boolean achieved;
    private boolean redeemed;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();



    public RewardsAdapter(ArrayList<Rewards> rewards, List<AccountAchievement> accountAchievements, RecyclerViewClickListener listener) {
        mRewards = rewards;
        mAccountAchievements = accountAchievements;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView shopTV, offerTV, redeemedTV, starsTV;
        private ImageView image;
        private RecyclerViewClickListener mListener;

        public MyViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            shopTV = v.findViewById(R.id.shopTV);
            offerTV = v.findViewById(R.id.offerTV);
            redeemedTV = v.findViewById(R.id.redeemedTV);
            starsTV = v.findViewById(R.id.starsTV);
            image = v.findViewById(R.id.image);

        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public RewardsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rewards_list_row, parent, false);
        return new MyViewHolder(v, mListener);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        email = user.getEmail();

        mReward = mRewards.get(position);

        Glide.with(context).load(mReward.getUrl()).into(holder.image);

        holder.starsTV.setText(mReward.getStars() + "");

        myDb = Room.databaseBuilder(context, MyDatabase.class, "my-db.db")
                .allowMainThreadQueries()
                .build();

        redeemed = myDb.accountAchievementDao().getRedeemed(email, mReward.getRewardId());
        System.out.println(email);

//        mAccAch = myDb.accountAchievementDao().getAch(email, mReward.getRewardId());

//        System.out.println( mAccAch.getEmail() + " " + mAccAch.getAchievementId() +  " " + mAccAch.isAchieved() + " " + mAccAch.isRedeemed());


        System.out.println( mReward.getShop() + " " + mReward.getRewardId() + " " + redeemed);

        if (redeemed == true){
            holder.redeemedTV.setText("Redeemed");
            holder.shopTV.setText(mReward.getShop());
            holder.offerTV.setText(mReward.getOffer());
            Log.d(TAG, "onBindViewHolder: redeemed is true " + mReward.getShop() );

        } else {
            holder.redeemedTV.setText("");

            //change position of textview programatically based on whether the redeemed needs to be shown or not
            RelativeLayout.LayoutParams s = (RelativeLayout.LayoutParams)holder.shopTV.getLayoutParams();
            s.bottomMargin =  90;
            RelativeLayout.LayoutParams o = (RelativeLayout.LayoutParams)holder.offerTV.getLayoutParams();
            o.bottomMargin = 40;

            holder.shopTV.setText(mReward.getShop());
            holder.offerTV.setText(mReward.getOffer());
            Log.d(TAG, "onBindViewHolder:  redeemed is false " + mReward.getShop());

        }

//        myDb.close();






    }


    @Override
    public int getItemCount() {
        return mRewards.size();
    }


}

