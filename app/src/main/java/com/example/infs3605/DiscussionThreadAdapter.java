package com.example.infs3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.DiscussionThread;

import java.util.ArrayList;
import java.util.List;


public class DiscussionThreadAdapter extends RecyclerView.Adapter<DiscussionThreadAdapter.ViewHolder> {
    private ArrayList<DiscussionThread> mDiscussionThreads;
    private DiscussionThread discussionThread;
    private static final String TAG = "DiscussionThreadAdapter";
    private RecyclerViewClickListener mListener;
    private Context context;

    public DiscussionThreadAdapter(ArrayList<DiscussionThread> discussionThreads, RecyclerViewClickListener listener) {
        mDiscussionThreads = discussionThreads;
        mListener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle, tvAuthor, tvLastPost, tvReplies;

        private RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvLastPost = itemView.findViewById(R.id.tvLastPost);
            tvReplies = itemView.findViewById(R.id.tvReplies);

            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @NonNull
    @Override
    public DiscussionThreadAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.discussion_thread_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        discussionThread = mDiscussionThreads.get(position);

        Log.d(TAG, "" + discussionThread.getTitle());
        Log.d(TAG, "onBindViewHolder: DiscussionThreadAdapter ");

        holder.tvTitle.setText(discussionThread.getTitle());
        holder.tvAuthor.setText(discussionThread.getAuthor());
        holder.tvLastPost.setText(discussionThread.getLastPostTime());
        holder.tvReplies.setText("" + (discussionThread.getNumberOfReplies()) + " Replies");


    }

    @Override
    public int getItemCount() {
        return mDiscussionThreads.size();
    }


}


