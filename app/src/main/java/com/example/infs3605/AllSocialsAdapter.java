package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Social;

import java.util.ArrayList;

public class AllSocialsAdapter extends RecyclerView.Adapter<AllSocialsAdapter.ViewHolder>{

    private ArrayList<Social> mSocialList;
    private Social mSocial;

    private Context mContext;

    public AllSocialsAdapter(ArrayList<Social> mSocialList) {
        this.mSocialList = mSocialList;
    }



    @NonNull
    @Override
    public AllSocialsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_socials_list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllSocialsAdapter.ViewHolder holder, int position) {

        mSocial = mSocialList.get(position);


        holder.ivSocialIcon.setImageResource(mSocial.getSocialIcon());
        holder.ivSocialImage.setImageResource(mSocial.getSocialImage());
        holder.tvSocialAccount.setText(mSocial.getSocialAccount());
        holder.tvSocialDesc.setText(mSocial.getSocialDesc());
        holder.itemView.setTag(mSocial.getSocialId());


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivSocialIcon, ivSocialImage;
        public TextView tvSocialAccount, tvSocialDesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSocialIcon = itemView.findViewById(R.id.ivSocialIcon);
            ivSocialImage = itemView.findViewById(R.id.ivSocialImage);

            tvSocialAccount = itemView.findViewById(R.id.tvSocialAccount);
            tvSocialDesc = itemView.findViewById(R.id.tvSocialDesc);
        }

    }


    @Override
    public int getItemCount() {
        return mSocialList.size();
    }
}
