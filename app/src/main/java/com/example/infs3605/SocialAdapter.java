package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Social;

import java.util.ArrayList;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder>{

    private ArrayList<Social> mSocialList;
    private Social mSocial;
    private RecyclerViewClickListener mListener;
    private Context mContext;

    public SocialAdapter(ArrayList<Social> mSocialList, RecyclerViewClickListener listener) {
        this.mSocialList = mSocialList;
        this.mListener = listener;
    }



    @NonNull
    @Override
    public SocialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.social_list_item,parent,false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.ViewHolder holder, int position) {

        mSocial = mSocialList.get(position);

        holder.ivSocialImage.setImageResource(mSocial.getSocialImage());
        holder.itemView.setTag(mSocial.getSocialId());


    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView ivSocialImage;

        private RecyclerViewClickListener mListener;


        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            mListener = listener;
            itemView.setOnClickListener(this);

            ivSocialImage = itemView.findViewById(R.id.ivSocialImage);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, (Integer) v.getTag());
        }
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int socialId);
    }

    @Override
    public int getItemCount() {
        return mSocialList.size();
    }
}
