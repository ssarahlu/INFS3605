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
import com.example.infs3605.Entities.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
        void onClick(View v,String threadID, String title, String author, String authorID, Date postTime, String post);
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
            discussionThread = mDiscussionThreads.get(getAdapterPosition());
            mListener.onClick(v,discussionThread.getThreadID(), discussionThread.getTitle(), discussionThread.getAuthor(), discussionThread.getAuthorID(),  discussionThread.getPostTime(), discussionThread.getPost());

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

        holder.tvTitle.setText(discussionThread.getTitle());
        holder.tvAuthor.setText(discussionThread.getAuthor());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
        String date = dateFormat.format(discussionThread.getLastPostTime());
        holder.tvLastPost.setText("Last Post: " + date);
        if(discussionThread.getNumberOfReplies() == 1) {
            holder.tvReplies.setText("" + (discussionThread.getNumberOfReplies()) + " Reply");
        } else {
            holder.tvReplies.setText("" + (discussionThread.getNumberOfReplies()) + " Replies");
        }


    }

    @Override
    public int getItemCount() {
        return mDiscussionThreads.size();
    }

    public void sort() {
        Collections.sort(mDiscussionThreads, new Comparator<DiscussionThread>() {
            @Override
            public int compare(DiscussionThread o1, DiscussionThread o2) {
                return(o2.getLastPostTime().compareTo(o1.getLastPostTime()));

            }
        });

        notifyDataSetChanged();
    }

}


