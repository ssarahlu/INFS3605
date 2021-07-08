package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public ModuleFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment ModuleFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static ModuleFragment newInstance(String param1, String param2) {
//        ModuleFragment fragment = new ModuleFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);

        Intent intent = getActivity().getIntent();

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

