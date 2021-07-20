package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Levels;
import com.example.infs3605.Entities.Post;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {
    private ArrayList<Post> mPosts;
    private Post post;
    private static final String TAG = "PostsAdapter";
    private Context context;

    public PostsAdapter(ArrayList<Post> posts) {
        mPosts = posts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPostDate, tvPost;
        private ImageView ivUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPostDate = itemView.findViewById(R.id.tvPostDate);
            tvPost = itemView.findViewById(R.id.tvPost);
            ivUser = itemView.findViewById(R.id.ivUser);

        }

    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.posts_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        post = mPosts.get(position);

        holder.tvName.setText(post.getAuthor());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
        String date = dateFormat.format(post.getPostTime());
        holder.tvPostDate.setText("Last Post: " + date);
        int numStars = Integer.parseInt("" + post.getNumStars());
        int numLevel = Levels.getLevel(numStars);
        holder.ivUser.setImageResource(Levels.getAvatar(numLevel));
        holder.tvPost.setText(post.getPost());



    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void sort() {
        Collections.sort(mPosts, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return(o1.getPostTime().compareTo(o2.getPostTime()));

            }
        });

        notifyDataSetChanged();
    }

}
