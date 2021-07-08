package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Topics;

import java.util.ArrayList;

//displays recyclerview of all the modules
public class ModuleActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String TOPIC_ID = "topic_id";
    private ArrayList<Modules> mModules = new ArrayList<>();
    private ArrayList<Topics> mTopics = new ArrayList<>();
    private Topics topic;
    public static final String EXTRA_MESSAGE = "module_id";
    private int topicId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);

        Intent intent = getIntent();

        for (Topics t: Topics.getTopics()){
            mTopics.add(t);

        }

        if (intent.getStringExtra(HomeFragment.TOPIC_ID) != null){
            topicId = Integer.parseInt(intent.getStringExtra(HomeFragment.TOPIC_ID));
            System.out.println(topicId);
            topic = mTopics.get(topicId);

            setTitle(topic.getTopicName());

            for (Modules m : Modules.getModules()){
                System.out.println("Hello");
                if (m.getTopicId() == topicId){
                    mModules.add(m);
                    System.out.println("added modules");

                }

            }

        }


        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ModulesAdapter.RecyclerViewClickListener listener = new ModulesAdapter.RecyclerViewClickListener() {
            public void onClick(View view, int position) {
                launchModules(position);
                Modules mod = mModules.get(position);
            }
        };
        mAdapter = new ModulesAdapter(mModules, listener);
        mRecyclerView.setAdapter(mAdapter);



    }


    private void launchModules(int position) {
        Modules mod = mModules.get(position);
        Intent intent = new Intent(this, ModuleSelection.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        intent.putExtra("Module", mod.getModuleName());
        intent.putExtra("Description", mod.getModuleDescription());
        intent.putExtra("id", String.valueOf(mod.getModuleId()));
        startActivity(intent);

    }

}
