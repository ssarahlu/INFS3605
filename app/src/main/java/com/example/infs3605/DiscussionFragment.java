package com.example.infs3605;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3605.Entities.DiscussionThread;
import com.example.infs3605.Entities.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
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

    public DiscussionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discussion, container, false);

        mRecyclerView = view.findViewById(R.id.rvDiscussionThreads);
        mRecyclerView.setHasFixedSize(false);

        ArrayList<DiscussionThread> discussionThreads = new ArrayList<>();
        discussionThreadRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    // Gets all profiles, and loads the data into the Profiles Array List
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {

                                discussionThreads.add(new DiscussionThread(documentSnapshot.getString("title"),
                                        documentSnapshot.getString("author"),
                                        documentSnapshot.getString("lastPostTime"),
                                        Integer.parseInt(documentSnapshot.get("numberOfReplies").toString())));

                            }

                            mLayoutManager = new LinearLayoutManager(getActivity());
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mAdapter = new DiscussionThreadAdapter(discussionThreads);
                            mRecyclerView.setAdapter(mAdapter);

                        }

                    }

                });

        return view;

    }

    public void createThread() {
        String name = user.getDisplayName();

        // Create a Hash Map with the desired values
        Map<String, Object> thread = new HashMap<>();
        thread.put("title", "Dyarubbin Exhibition");
        thread.put("author", name);
        thread.put("lastPostTime", "12/07/2021, 8:19 p.m.");
        thread.put("numberOfReplies", 18);


        // Create a document with UID as the reference
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
    }
}