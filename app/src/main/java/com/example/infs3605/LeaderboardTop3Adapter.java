package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Profile;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardTop3Adapter extends RecyclerView.Adapter<LeaderboardTop3Adapter.LeaderboardViewHolder> {
    private List<Profile> mProfiles;

    public LeaderboardTop3Adapter(List<Profile> profiles) {
        mProfiles = profiles;
    }


    @NonNull
    @Override
    public LeaderboardTop3Adapter.LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_top3_item, parent, false);
        return new LeaderboardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardTop3Adapter.LeaderboardViewHolder holder, int position) {
        Profile profile = mProfiles.get(position);

        holder.tvName.setText(profile.getDisplayName());

        holder.ivAvatar.setImageResource(Integer.parseInt(profile.getLevelAnimalIcon()));

        if (position == 0) {
            holder.tvRank.setText("1st");
        } else if (position == 1) {
            holder.tvRank.setText("2nd");
        } else {
            holder.tvRank.setText("3rd");
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        private TextView tvRank, tvName, tvAnimal, tvLevel, tvStars;
        private ImageView ivAvatar;
        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvName = itemView.findViewById(R.id.tvName);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);

        }
    }

    public void sort() {
        Collections.sort(mProfiles, new Comparator<Profile>() {
            @Override
            public int compare(Profile o1, Profile o2) {
                return Double.compare(o2.getStars(), o1.getStars());
            }
        });

        notifyDataSetChanged();
    }

}
