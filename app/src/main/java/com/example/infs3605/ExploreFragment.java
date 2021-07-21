package com.example.infs3605;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.infs3605.Entities.Event;
import com.example.infs3605.Entities.SavedEventData;
import com.example.infs3605.Entities.Social;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class ExploreFragment extends Fragment {

    private static final String TAG = "ExploreFragment";

    //event


    //saved
    private RecyclerView savedEventRecyclerView;
    private RecyclerView.Adapter savedEventAdapter;
    private RecyclerView.LayoutManager savedEventLayoutManager;

    private List<SavedEventData> savedEventList;


    //not saved
    private RecyclerView eventRecyclerView;
    private RecyclerView.Adapter eventAdapter;
    private RecyclerView.LayoutManager eventLayoutManager;

    private ArrayList<Event> eventList;

    public static SavedEventDatabase myDb;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;

    private TextView tvAllEvents;


    //social
    private RecyclerView socialRecyclerView;
    private RecyclerView.Adapter socialAdapter;
    private RecyclerView.LayoutManager socialLayoutManager;

    private TextView tvAllSocials;

    //to be changed to instagram API
    private ArrayList<Social> socialList;



    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_explore, container, false);


        email = user.getEmail();


        //saved events

        myDb = Room.databaseBuilder(getActivity().getApplicationContext(), SavedEventDatabase.class, "myDb")
                .allowMainThreadQueries()
                .build();

        Log.d(TAG, "doInBackground: " + email);

        savedEventList = myDb.savedEventDataDao().getUserSavedEvents(email);
        Log.d(TAG, "doInBackground: updating savedEventList | size = " + savedEventList.size());

        for (SavedEventData event : savedEventList) {
            System.out.println(event.getEmail() + " | " + event.getEventId());
        }



        savedEventRecyclerView = view.findViewById(R.id.rvSavedEvents);
        savedEventRecyclerView.setHasFixedSize(true);

        savedEventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        savedEventRecyclerView.setLayoutManager(savedEventLayoutManager);

        SavedEventAdapter.RecyclerViewClickListener savedEventListener = new SavedEventAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int eventId) {
                launchEventActivity(eventId);
            }
        };

        savedEventAdapter = new SavedEventAdapter(savedEventList,savedEventListener);
        savedEventRecyclerView.setAdapter(savedEventAdapter);


        //not saved

        tvAllEvents = view.findViewById(R.id.tvAllEvents);

        tvAllEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchAllEventsActivity();
            }
        });

        eventList = Event.getEventList();

        eventRecyclerView = view.findViewById(R.id.rvEvents);
        eventRecyclerView.setHasFixedSize(true);


        eventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        eventRecyclerView.setLayoutManager(eventLayoutManager);

        EventAdapter.RecyclerViewClickListener eventListener = new EventAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int eventId) {
                launchEventActivity(eventId);
            }
        };

        eventAdapter = new EventAdapter(eventList, eventListener);
        eventRecyclerView.setAdapter(eventAdapter);


        //social
        socialList = Social.getSocialList();

        tvAllSocials = view.findViewById(R.id.tvAllSocials);

        tvAllSocials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchAllSocialsActivity(0);
            }
        });

        socialRecyclerView = view.findViewById(R.id.rvSocial);
        socialRecyclerView.setHasFixedSize(true);

        socialLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.HORIZONTAL, false);
        socialRecyclerView.setLayoutManager(socialLayoutManager);

        SocialAdapter.RecyclerViewClickListener socialListener = new SocialAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int socialId) {
                launchAllSocialsActivity(socialId);
            }
        };

        socialAdapter = new SocialAdapter(socialList, socialListener);
        socialRecyclerView.setAdapter(socialAdapter);

        return view;
    }


    private void launchAllEventsActivity() {

        Intent intent = new Intent(getActivity().getApplicationContext(), AllEventsActivity.class);
        startActivity(intent);

    }

    private void launchAllSocialsActivity(int socialId) {
        Intent intent = new Intent(getActivity().getApplicationContext(), AllSocialsActivity.class);
        intent.putExtra("socialId",socialId);
        startActivity(intent);

    }


    private void launchEventActivity(int eventId) {

        Intent intent = new Intent(getActivity(), EventActivity.class);
        intent.putExtra("eventId",eventId);
        startActivity(intent);
    }



}