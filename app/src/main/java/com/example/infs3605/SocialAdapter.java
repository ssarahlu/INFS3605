package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder>{

    private ArrayList<Integer> mImageUrls = new ArrayList<>();
    private RecyclerViewClickListener mListener;
    private Context mContext;

    public SocialAdapter(ArrayList<Integer> mImageUrls, RecyclerViewClickListener listener) {
        this.mImageUrls = mImageUrls;
        this.mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    @NonNull
    @Override
    public SocialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.social_list_item,parent,false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialAdapter.ViewHolder holder, int position) {

        holder.ivSocialImage.setImageResource(mImageUrls.get(position));

        holder.ivSocialImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
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

        }
    }
}
