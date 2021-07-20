package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Topics;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModuleFragment#} factory method to
 * create an instance of this fragment.
 */
public class ModuleFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static final String TOPIC_ID = "topic_id";
    private ArrayList<Modules> mModules = new ArrayList<>();
    private ArrayList<Topics> mTopics = new ArrayList<>();
    private Topics topic;
    public static final String EXTRA_MESSAGE = "module_id";
    private int topicId;
    private ImageButton backButton;
    private TextView modTitle;


    public ModuleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_module, container, false);

        mRecyclerView = view.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        backButton = view.findViewById(R.id.backButton);
        modTitle = view.findViewById(R.id.modTitle);

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        for (Topics t : Topics.getTopics()) {
            mTopics.add(t);
        }

        Bundle bundle = getArguments();

        if (bundle.getString(HomeFragment.TOPIC_ID) != null) {
            topicId = Integer.parseInt(bundle.getString(HomeFragment.TOPIC_ID));
            System.out.println(topicId);
            topic = mTopics.get(topicId);

            modTitle.setText(topic.getTopicName());


            for (Modules m : Modules.getModules()) {
                System.out.println("Hello");
                if (m.getTopicId() == topicId) {
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


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity().getApplicationContext(), "Back to home ", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

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

