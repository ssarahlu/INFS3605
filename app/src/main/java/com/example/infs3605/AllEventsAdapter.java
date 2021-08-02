package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Event;

import java.util.ArrayList;

public class AllEventsAdapter extends RecyclerView.Adapter<AllEventsAdapter.ViewHolder> {

    private ArrayList<Event> mEventList;
    private Event mEvent;
    private RecyclerViewClickListener mListener;
    private Context context;

    public AllEventsAdapter(ArrayList<Event> events, RecyclerViewClickListener listener) {
        mEventList = events;
        mListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivEventImage;
        public TextView tvEventName, tvEventDate;

        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            mListener = listener;
            itemView.setOnClickListener(this);

            ivEventImage = itemView.findViewById(R.id.ivEventListImage);
            tvEventName = itemView.findViewById(R.id.tvEventListName);
            tvEventDate = itemView.findViewById(R.id.tvEventListDate);

        }


        @Override
        public void onClick(View v) {
            mListener.onClick(v, (Integer) v.getTag());
        }
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int eventId);
    }

    @NonNull
    @Override
    public AllEventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.all_event_list_item, parent, false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mEvent = mEventList.get(position);

        Glide.with(context).load( mEvent.getEventImage()).into(holder.ivEventImage);
        holder.tvEventName.setText(mEvent.getEventName());
        holder.tvEventDate.setText(mEvent.getEventDate());
        holder.itemView.setTag(mEvent.getEventId());



    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }
}
