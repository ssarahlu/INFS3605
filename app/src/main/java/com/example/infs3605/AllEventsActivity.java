package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.infs3605.Entities.Event;

import java.util.ArrayList;

public class AllEventsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private ArrayList<Event> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);

        mList = Event.getEventList();

        mRecyclerView = findViewById(R.id.rvAllEvents);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        AllEventsAdapter.RecyclerViewClickListener mListener = new AllEventsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int eventId) {
                launchEventActivity(eventId);
            }
        };

        mAdapter = new AllEventsAdapter(mList, mListener);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void launchEventActivity(int eventId) {
        Intent intent = new Intent(this, EventActivity.class);
        intent.putExtra("eventId",eventId);
        startActivity(intent);
    }
}