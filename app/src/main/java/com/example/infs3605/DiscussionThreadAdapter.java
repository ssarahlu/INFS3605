package com.example.infs3605;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.DiscussionThread;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class DiscussionThreadAdapter extends RecyclerView.Adapter<DiscussionThreadAdapter.ViewHolder> implements Filterable {
    private ArrayList<DiscussionThread> mDiscussionThreads, mDiscussionThreadsFiltered;
    private DiscussionThread discussionThread;
    private static final String TAG = "DiscussionThreadAdapter";
    private RecyclerViewClickListener mListener;
    private Context context;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public DiscussionThreadAdapter(ArrayList<DiscussionThread> discussionThreads, RecyclerViewClickListener listener) {
        mDiscussionThreads = discussionThreads;
        mDiscussionThreadsFiltered = discussionThreads;
        mListener = listener;
    }



    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                // If no input, use the default Array List
                if(charString.equals("clear")||charString.isEmpty()) {
                    mDiscussionThreadsFiltered = mDiscussionThreads;
                    // Use a for loop to go through the Movies Array List
                } else {
                    ArrayList<DiscussionThread> filteredList = new ArrayList<>();
                    for(DiscussionThread discussionThread : mDiscussionThreadsFiltered) {
                        switch(charString) {
                            case "arts":
                                if(discussionThread.getArts()) {
                                    filteredList.add(discussionThread);
                                }
                                break;
                            case "culture":
                                if(discussionThread.getCulture()) {
                                    filteredList.add(discussionThread);
                                }
                                break;
                            case "values":
                                if(discussionThread.getValues()) {
                                    filteredList.add(discussionThread);
                                }
                                break;

                        }

                        if(discussionThread.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(discussionThread);
                            // Filter for Genre as well
                        } else if(discussionThread.getAuthor().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(discussionThread);
                        }
                    }
                    // Add the filtered list to the Movies Filtered Array List
                    mDiscussionThreadsFiltered = filteredList;
                }
                // Return the Filter Results
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDiscussionThreadsFiltered;
                return filterResults;
            }

            // Display the results and notify the data set that it has been changes
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mDiscussionThreadsFiltered = (ArrayList<DiscussionThread>) results.values;
                notifyDataSetChanged();
            }

        };

    }

    public interface RecyclerViewClickListener {
        void onClick(View v,String threadID, String title, String author, String authorID, Date postTime, String post);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle, tvAuthor, tvPostTime, tvReplies, tvFNPReplied;
        private ImageView fnpReplied, fnpReplied2;

        private RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPostTime = itemView.findViewById(R.id.tvPostTime);
            tvReplies = itemView.findViewById(R.id.tvReplies);
            fnpReplied = itemView.findViewById(R.id.fnpReplied);
            fnpReplied2 = itemView.findViewById(R.id.fnpReplied2);
//            tvFNPReplied = itemView.findViewById(R.id.tvFNPReplied);

            mListener = listener;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            discussionThread = mDiscussionThreadsFiltered.get(getAdapterPosition());
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
        discussionThread = mDiscussionThreadsFiltered.get(position);

        holder.tvTitle.setText(discussionThread.getTitle());
        holder.tvAuthor.setText(discussionThread.getAuthor());

        if (discussionThread.getAuthorID().equals(user.getUid())) {
            holder.tvAuthor.setTextColor(Color.parseColor("#71C453"));
        } else {
            holder.tvAuthor.setTextColor(Color.parseColor("#000000"));
        }


        if(discussionThread.getFnpReplied().equals("aboriginal")) {
            holder.fnpReplied.setImageResource(R.drawable.aboriginal_flag);
//            holder.tvFNPReplied.setText("First Nations Person has responded");
//            holder.tvFNPReplied.setTextColor(Color.parseColor("#2196F3"));

        } else if (discussionThread.getFnpReplied().equals("ts_islander")) {
            holder.fnpReplied.setImageResource(R.drawable.torres_strait_flag);
//            holder.tvFNPReplied.setText("First Nations Person has responded");
//            holder.tvFNPReplied.setTextColor(Color.parseColor("#2196F3"));
        } else if (discussionThread.getFnpReplied().equals("both")) {
            holder.fnpReplied.setImageResource(R.drawable.torres_strait_flag);
            holder.fnpReplied2.setImageResource(R.drawable.aboriginal_flag);
//            holder.tvFNPReplied.setText("First Nations People have responded");
//            holder.tvFNPReplied.setTextColor(Color.parseColor("#2196F3"));
        } else {
            holder.fnpReplied.setImageResource(0);
            holder.fnpReplied2.setImageResource(0);
//            holder.tvFNPReplied.setText("");
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
        String date = dateFormat.format(discussionThread.getPostTime());
        holder.tvPostTime.setText("Posted: " + date);
        holder.tvReplies.setText("" + (discussionThread.getNumberOfReplies()) + "");

    }

    @Override
    public int getItemCount() {
        return mDiscussionThreadsFiltered.size();
    }

    public void sort() {
        Collections.sort(mDiscussionThreadsFiltered, new Comparator<DiscussionThread>() {
            @Override
            public int compare(DiscussionThread o1, DiscussionThread o2) {
                return(o2.getPostTime().compareTo(o1.getPostTime()));

            }
        });

        notifyDataSetChanged();
    }

}


