package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Facts;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Topics;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private TextView factTV, name, didyouknow, learn, art;
    private ArrayList<Facts> mFacts = new ArrayList<>();
    private int factNumber;
    private Facts fact;
    private ImageButton artButton;
    public static final String TOPIC_ID = "topic_id";


    //extra
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Modules> mModules = new ArrayList<>();
    private ArrayList<Topics> mTopics = new ArrayList<>();
    private Topics topic;
    public static final String EXTRA_MESSAGE = "module_id";
    private int topicId;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        factTV = view.findViewById(R.id.factTV);
        artButton = view.findViewById(R.id.artButton);
        name = view.findViewById(R.id.name);
        learn = view.findViewById(R.id.learn);
        didyouknow = view.findViewById(R.id.didyouknow);
        art = view.findViewById(R.id.art);

        mRecyclerView = view.findViewById(R.id.rvList);
        mRecyclerView.setVisibility(View.INVISIBLE);
        factTV.setVisibility(View.VISIBLE);
        artButton.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);
        didyouknow.setVisibility(View.VISIBLE);
        learn.setVisibility(View.VISIBLE);
        art.setVisibility(View.VISIBLE);
        mRecyclerView.setHasFixedSize(true);

        for (Facts f : Facts.getFacts()) {
            mFacts.add(f);

        }

        if (mFacts != null){
            factNumber = (int)(Math.random() * mFacts.size() - 1) + 1;
            System.out.println( "my random number is " + factNumber);
            fact = mFacts.get(factNumber);
            System.out.println(fact);
            factTV.setText(fact.getFact());

        }

        Intent intent = new Intent(getActivity(), MainActivity.class);
        for (Topics t: Topics.getTopics()){
            mTopics.add(t);

        }

        if (intent.getStringExtra(HomeFragment.TOPIC_ID) != null){
            topicId = Integer.parseInt(intent.getStringExtra(HomeFragment.TOPIC_ID));
            System.out.println(topicId);
            topic = mTopics.get(topicId);

            getActivity().setTitle(topic.getTopicName());

            for (Modules m : Modules.getModules()){
                System.out.println("Hello");
                if (m.getTopicId() == topicId){
                    mModules.add(m);
                    System.out.println("added modules");
                }
            }
        }

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        ModulesAdapter.RecyclerViewClickListener listener = new ModulesAdapter.RecyclerViewClickListener() {
            public void onClick(View view, int position) {
                launchModules(position);
                Modules mod = mModules.get(position);
            }
        };
        mAdapter = new ModulesAdapter(mModules, listener);
        mRecyclerView.setAdapter(mAdapter);



        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
//                intent.putExtra(TOPIC_ID, "0");
//                startActivity(intent);
                Toast.makeText(getActivity(), "Art selected", Toast.LENGTH_SHORT).show();

                mRecyclerView.setVisibility(View.VISIBLE);

                factTV.setVisibility(View.INVISIBLE);
                artButton.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                didyouknow.setVisibility(View.INVISIBLE);
                learn.setVisibility(View.INVISIBLE);
                art.setVisibility(View.INVISIBLE);


//                ModuleFragment moduleFragment = new ModuleFragment();
//                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction1.replace(R.id.fragment_container, moduleFragment, "FragmentName");
//                fragmentTransaction1.commit();

                for (Topics t: Topics.getTopics()){

                    if (t.getTopicId() == 0 ){
                        mTopics.add(t);
                        System.out.println("hi");
                        System.out.println(t.getTopicId());
                    }

                }

                    topicId = 0;
                    System.out.println(topicId);
                    topic = mTopics.get(topicId);

                    getActivity().setTitle(topic.getTopicName());

                    for (Modules m : Modules.getModules()){
                        System.out.println("Hello");
                        if (m.getTopicId() == topicId){
                            mModules.add(m);
                            System.out.println("added modules");
                        }
                    }


                mLayoutManager = new LinearLayoutManager(getActivity());
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
        });

        return view;
    }

    private void updateUi(){

    }

    private void launchModules(int position) {
        Modules mod = mModules.get(position);
        Intent intent = new Intent(getActivity(), ModuleSelection.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        intent.putExtra("Module", mod.getModuleName());
        intent.putExtra("Description", mod.getModuleDescription());
        intent.putExtra("id", String.valueOf(mod.getModuleId()));
        startActivity(intent);

    }

}