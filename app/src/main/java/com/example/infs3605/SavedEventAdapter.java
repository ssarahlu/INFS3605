package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.SavedEventData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.List;


public class SavedEventAdapter extends RecyclerView.Adapter<SavedEventAdapter.ViewHolder> {

    private List<SavedEventData> mEventList;
    private SavedEventData mEvent;
    private RecyclerViewClickListener mListener;
    private Context context;

    SavedEventDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;

    private String mEmail;
    private int mId;
    private String mImage;
    private String mName;
    private String mDate;
    private String mLink;


    public SavedEventAdapter(List<SavedEventData> savedEventList, RecyclerViewClickListener listener) {
        mEventList = savedEventList;
        mListener = listener;
    }




    public interface RecyclerViewClickListener {
        void onClick(View view, int eventId);
    }

    @NonNull
    @Override
    public SavedEventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.event_list_item, parent, false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        /*
        email = user.getEmail();


        myDb = Room.databaseBuilder(context, SavedEventDatabase.class, "myDb")
                .allowMainThreadQueries()
                .build();

         */

        mEvent = mEventList.get(position);

        //System.out.println(mEventList.size());


        String imageBaseUrl = "https://www.indigenous.gov.au/sites/default/files/styles/indig_thumbnail/public/";

        Glide.with(context).load(imageBaseUrl + mEvent.getEventImage()).into(holder.ivEventImage);
        holder.tvEventName.setText(mEvent.getEventName());
        holder.tvEventDate.setText(mEvent.getEventDate());
        holder.itemView.setTag(mEvent.getEventId());

    }

    @Override
    public int getItemCount() {
        return  mEventList == null ? 0 : mEventList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivEventImage;
        public TextView tvEventName, tvEventDate;
        public Button btnSaved;

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
}
