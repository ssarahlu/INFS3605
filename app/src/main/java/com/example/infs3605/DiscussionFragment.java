package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LongSparseArray;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.infs3605.Entities.DiscussionThread;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DiscussionFragment extends Fragment {

    private static final String TAG = "";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference discussionThreadRef = db.collection("discussion_threads");
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    private DiscussionThreadAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private ImageButton btAddThread;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private String searchQuery;

    public DiscussionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion, container, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        mRecyclerView = view.findViewById(R.id.rvDiscussionThreads);
        mRecyclerView.setHasFixedSize(false);

        TabLayout tabLayout;
        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("General"));
        tabLayout.addTab(tabLayout.newTab().setText("Arts"));
        tabLayout.addTab(tabLayout.newTab().setText("Culture"));
        tabLayout.addTab(tabLayout.newTab().setText("Values"));
        tabLayout.selectTab(tabLayout.getTabAt(0));

        SearchView tvSearch = view.findViewById(R.id.tvSearch);

        if (!tabLayout.isSelected()) {
            tvSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    mAdapter.getFilter().filter(s);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    mAdapter.getFilter().filter(newText);
                    return false;
                }
            });
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    mAdapter.getFilter().filter("clear");
                    searchQuery = "clear";
                } else if (position == 1) {
                    mAdapter.getFilter().filter("arts");
                    searchQuery = "arts";
                } else if (position == 2) {
                    mAdapter.getFilter().filter("culture");
                    searchQuery = "culture";
                } else if (position == 3) {
                    mAdapter.getFilter().filter("values");
                    searchQuery = "values";
                }

                tvSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        mAdapter.getFilter().filter(s);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mAdapter.getFilter().filter(newText);
                        if(newText.equals("")) {
                            mAdapter.getFilter().filter("clear");
                            mAdapter.getFilter().filter(searchQuery);
                        }
                        return false;
                    }
                });



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            mAdapter.getFilter().filter("clear");

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            int position = tab.getPosition();
                if (position == 0) {
                    mAdapter.getFilter().filter("clear");
                    searchQuery = "clear";
                } else if (position == 1) {
                    mAdapter.getFilter().filter("arts");
                    searchQuery = "arts";
                } else if (position == 2) {
                    mAdapter.getFilter().filter("culture");
                    searchQuery = "culture";
                } else if (position == 3) {
                    mAdapter.getFilter().filter("values");
                    searchQuery = "values";
                }

                tvSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        mAdapter.getFilter().filter(s);
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mAdapter.getFilter().filter(newText);
                        if(newText.equals("")) {
                            mAdapter.getFilter().filter("clear");
                            mAdapter.getFilter().filter(searchQuery);
                        }
                        return false;
                    }
                });

            }
        });



        setData();

        btAddThread = view.findViewById(R.id.btAddThread);
        btAddThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewNoteDialog();
            }
        });
        return view;

    }


    public void createNewNoteDialog() {
        dialogBuilder = new AlertDialog.Builder(getActivity());
        EditText threadTitle, threadContent;
        Button btPost;
        ImageButton btCancel;
        ToggleButton arts, culture, values;
        final View addThreadPopup = getLayoutInflater().inflate(R.layout.add_thread, null);
        threadTitle = addThreadPopup.findViewById(R.id.tvThreadTitle);
        threadContent = addThreadPopup.findViewById(R.id.tvThreadContent);
        btPost = addThreadPopup.findViewById(R.id.btPost);
        btCancel = addThreadPopup.findViewById(R.id.closeButton);
        arts = addThreadPopup.findViewById(R.id.arts);
        culture = addThreadPopup.findViewById(R.id.culture);
        values = addThreadPopup.findViewById(R.id.values);



        // Show the popup
        dialogBuilder.setView(addThreadPopup);
        dialog = dialogBuilder.create();
        dialog.show();

        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


        // Set the save button to save the note
        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the user input and if either values are empty, display a Toast
                String title = threadTitle.getText().toString();
                if (title.matches("")) {
                    Toast.makeText(getActivity(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    if (arts.isChecked() == false && culture.isChecked() == false && values.isChecked() == false) {
                        Toast.makeText(getActivity(), "Please select at least one Topic Area", Toast.LENGTH_SHORT).show();
                    } else {
                        Calendar calendar = Calendar.getInstance();

                        // Store the note under an author and for a specific module
                        Map<String, Object> thread = new HashMap<>();
                        thread.put("title", threadTitle.getText().toString());
                        thread.put("author", user.getDisplayName());
                        thread.put("authorID", user.getUid());
                        thread.put("post", threadContent.getText().toString());
                        thread.put("lastPostTime", calendar.getTime());
                        thread.put("postTime", calendar.getTime());
                        thread.put("numberOfReplies", 0);
                        thread.put("fnpReplied", "");

                        if (arts.isChecked() == true) {
                            thread.put("arts", true);
                        } else {
                            thread.put("arts", false);
                        }

                        if (culture.isChecked() == true) {
                            thread.put("culture", true);

                        } else {
                            thread.put("culture", false);
                        }

                        if (values.isChecked() == true) {
                            thread.put("values", true);

                        } else {
                            thread.put("values", false);
                        }



                        // Add the note to the Firestore database
                        discussionThreadRef.document().set(thread)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "Thread Document successfully written!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error writing document", e);
                                    }
                                });
                        // Close the popup
                        dialog.dismiss();
                        setDataAfterPost();
                    }
                }
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void setDataAfterPost(){
        ArrayList<DiscussionThread> discussionThreads = new ArrayList<>();
        discussionThreadRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    // Gets all profiles, and loads the data into the Profiles Array List
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                                discussionThreads.add(new DiscussionThread(documentSnapshot.getId(),
                                        documentSnapshot.getString("title"),
                                        documentSnapshot.getString("author"),
                                        documentSnapshot.getString("authorID"),
                                        documentSnapshot.getDate("lastPostTime"),
                                        documentSnapshot.getDate("postTime"),
                                        Integer.parseInt(documentSnapshot.get("numberOfReplies").toString()),
                                        documentSnapshot.getString("post"),
                                        documentSnapshot.getBoolean("arts"),
                                        documentSnapshot.getBoolean("culture"),
                                        documentSnapshot.getBoolean("values"),
                                        documentSnapshot.getString("fnpReplied")));

                            }

                            mLayoutManager = new LinearLayoutManager(getActivity());
                            mRecyclerView.setLayoutManager(mLayoutManager);

                            DiscussionThreadAdapter.RecyclerViewClickListener discussionListener = new DiscussionThreadAdapter.RecyclerViewClickListener() {
                                @Override
                                public void onClick(View v, String threadID, String title, String author, String authorID, Date postTime, String post, String fnpReplied) {
                                    Intent intent = new Intent(getActivity(), PostsActivity.class);
                                    intent.putExtra("threadID", threadID);
                                    intent.putExtra("title", title);
                                    intent.putExtra("author", author);
                                    intent.putExtra("authorID", authorID);
                                    intent.putExtra("postTime", postTime);
                                    intent.putExtra("post", post);
                                    intent.putExtra("fnpReplied", fnpReplied);
                                    startActivity(intent);

                                }
                            };

                            mAdapter = new DiscussionThreadAdapter(discussionThreads, discussionListener);
                            mAdapter.sort();
                            mRecyclerView.scrollToPosition(0);
                            mRecyclerView.setAdapter(mAdapter);

                        }

                    }

                });


    }

    public void setData(){
        ArrayList<DiscussionThread> discussionThreads = new ArrayList<>();
        discussionThreadRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    // Gets all profiles, and loads the data into the Profiles Array List
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                                discussionThreads.add(new DiscussionThread(documentSnapshot.getId(),
                                        documentSnapshot.getString("title"),
                                        documentSnapshot.getString("author"),
                                        documentSnapshot.getString("authorID"),
                                        documentSnapshot.getDate("lastPostTime"),
                                        documentSnapshot.getDate("postTime"),
                                        Integer.parseInt(documentSnapshot.get("numberOfReplies").toString()),
                                        documentSnapshot.getString("post"),
                                        documentSnapshot.getBoolean("arts"),
                                        documentSnapshot.getBoolean("culture"),
                                        documentSnapshot.getBoolean("values"),
                                        documentSnapshot.getString("fnpReplied")));

                            }

                            mLayoutManager = new LinearLayoutManager(getActivity());
                            mRecyclerView.setLayoutManager(mLayoutManager);

                            DiscussionThreadAdapter.RecyclerViewClickListener discussionListener = new DiscussionThreadAdapter.RecyclerViewClickListener() {
                                @Override
                                public void onClick(View v, String threadID, String title, String author, String authorID, Date postTime, String post, String fnpReplied) {
                                    Intent intent = new Intent(getActivity(), PostsActivity.class);
                                    intent.putExtra("threadID", threadID);
                                    intent.putExtra("title", title);
                                    intent.putExtra("author", author);
                                    intent.putExtra("authorID", authorID);
                                    intent.putExtra("postTime", postTime);
                                    intent.putExtra("post", post);
                                    intent.putExtra("fnpReplied", fnpReplied);
                                    startActivity(intent);

                                }
                            };

                            mAdapter = new DiscussionThreadAdapter(discussionThreads, discussionListener);
                            mAdapter.sort();
                            mRecyclerView.setAdapter(mAdapter);

                        }

                    }

                });


    }


}
