package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infs3605.Entities.Social;

import java.util.ArrayList;

public class AllSocialsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Social> mList;

    private ImageButton backButton;

    private int socialId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_socials);

        Intent intent = getIntent();

        socialId = intent.getIntExtra("socialId",0);

        backButton = findViewById(R.id.socialBackButton);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchExploreFragment();
            }
        });


        mList = Social.getSocialList();

        mRecyclerView = findViewById(R.id.rvAllSocials);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.getLayoutManager().scrollToPosition(socialId);

        mAdapter = new AllSocialsAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void launchExploreFragment() {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("id", "0");
        intent.putExtra("Check", "2");
        startActivity(intent);
    }

}