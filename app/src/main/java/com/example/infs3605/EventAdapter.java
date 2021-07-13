package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Event;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Event> mEventList;
    private Event mEvent;
    private RecyclerViewClickListener mListener;
    private Context context;

    public EventAdapter(ArrayList<Event> events, RecyclerViewClickListener listener) {
        mEventList = events;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivEventImage;
        public TextView tvEventName, tvEventDate, tvAttendance;

        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            mListener = listener;
            itemView.setOnClickListener(this);

            ivEventImage = itemView.findViewById(R.id.ivShoppingImage);
            tvEventName = itemView.findViewById(R.id.tvShoppingName);
            tvEventDate = itemView.findViewById(R.id.tvShoppingPrice);
            tvAttendance = itemView.findViewById(R.id.tvAttendance);

        }


        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        mEvent = mEventList.get(position);

        holder.ivEventImage.setImageResource(mEvent.getEventImage());
        holder.tvEventName.setText(mEvent.getEventName());
        holder.tvEventDate.setText(mEvent.getEventDate());

    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }
}
