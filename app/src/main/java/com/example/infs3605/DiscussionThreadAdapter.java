package com.example.infs3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.DiscussionThread;

import java.util.ArrayList;
import java.util.List;


public class DiscussionThreadAdapter extends RecyclerView.Adapter<DiscussionThreadAdapter.DiscussionThreadViewHolder> {
    private ArrayList<DiscussionThread> mDiscussionThreads;
    private DiscussionThread discussionThread;

    public DiscussionThreadAdapter(ArrayList<DiscussionThread> discussionThreads) {
        mDiscussionThreads = discussionThreads;
    }

    public class DiscussionThreadViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvAuthor, tvLastPost, tvReplies;

        public DiscussionThreadViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvName);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvLastPost = itemView.findViewById(R.id.tvLastPost);
            tvReplies = itemView.findViewById(R.id.tvReplies);
        }
    }

    @NonNull
    @Override
    public DiscussionThreadAdapter.DiscussionThreadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.discussion_thread_item, parent, false);
        return new DiscussionThreadViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscussionThreadAdapter.DiscussionThreadViewHolder holder, int position) {
        discussionThread = mDiscussionThreads.get(position);

//        Log.d(TAG, "" + discussionThread.getTitle());
        holder.tvTitle.setText(discussionThread.getTitle());
        holder.tvAuthor.setText(discussionThread.getAuthor());
        holder.tvLastPost.setText(discussionThread.getLastPostTime());
        holder.tvReplies.setText(Integer.toString(discussionThread.getNumberOfReplies()));
    }

    @Override
    public int getItemCount() {
        return mDiscussionThreads.size();
    }
}

//
//public class DiscussionThreadAdapter extends RecyclerView.Adapter<DiscussionThreadAdapter.DiscussionThreadViewHolder> {
//    private static final String TAG = "";
//    private List<DiscussionThread> mDiscussionThreads;
//    private DiscussionThread discussionThread;
//
//    public DiscussionThreadAdapter(List<DiscussionThread> discussionThreads) {
//        mDiscussionThreads = discussionThreads;
//
//    }
//
//    public static class DiscussionThreadViewHolder extends RecyclerView.ViewHolder {
//        public TextView tvTitle, tvAuthor, tvLastPost, tvReplies;
//
//        public DiscussionThreadViewHolder(View itemView) {
//            super(itemView);
//            tvTitle = itemView.findViewById(R.id.tvName);
//            tvAuthor = itemView.findViewById(R.id.tvAuthor);
//            tvLastPost = itemView.findViewById(R.id.tvLastPost);
//            tvReplies = itemView.findViewById(R.id.tvReplies);
//
//        }
//    }
//    @Override
//    public DiscussionThreadAdapter.DiscussionThreadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.discussion_thread_item, parent, false);
//        return new DiscussionThreadViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DiscussionThreadAdapter.DiscussionThreadViewHolder holder, int position) {
//        discussionThread = mDiscussionThreads.get(position);
//
//        Log.d(TAG, "" + discussionThread.getTitle());
//        holder.tvTitle.setText(discussionThread.getTitle());
//        holder.tvAuthor.setText(discussionThread.getAuthor());
//        holder.tvLastPost.setText(discussionThread.getLastPostTime());
//        holder.tvReplies.setText(Integer.toString(discussionThread.getNumberOfReplies()));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDiscussionThreads.size();
//    }
//
//
//}

