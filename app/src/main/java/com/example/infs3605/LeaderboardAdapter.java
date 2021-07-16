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

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {
    private List<Profile> mProfiles;

    public LeaderboardAdapter(List<Profile> profiles) {
        mProfiles = profiles;
    }


    @NonNull
    @Override
    public LeaderboardAdapter.LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item, parent, false);
        return new LeaderboardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.LeaderboardViewHolder holder, int position) {
        Profile profile = mProfiles.get(position);

        holder.tvName.setText(profile.getDisplayName());
        holder.tvAnimal.setText(profile.getLevelAnimal());
        holder.tvLevel.setText(" | Level " + profile.getLevel());
        holder.tvStars.setText(Integer.toString(profile.getStars()));
        holder.ivAvatar.setImageResource(Integer.parseInt(profile.getLevelAnimalIcon()));

        if (position == 0) {
            holder.tvRank.setText("1st");
        } else if (position == 1) {
            holder.tvRank.setText("2nd");
        } else if (position == 2) {
            holder.tvRank.setText("3rd");
        } else {
            holder.tvRank.setText((position + 1) + "th");
        }


    }

    @Override
    public int getItemCount() {
        return mProfiles.size();
    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        private TextView tvRank, tvName, tvAnimal, tvLevel, tvStars;
        private ImageView ivAvatar;
        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            tvName = itemView.findViewById(R.id.tvName);
            tvAnimal = itemView.findViewById(R.id.tvAnimal);
            tvLevel = itemView.findViewById(R.id.tvLevel);
            tvStars = itemView.findViewById(R.id.tvStars);
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
