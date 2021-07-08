package com.example.infs3605;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

public class HomeFragment extends Fragment {

    private TextView factTV, name, didyouknow, learn, art;
    private ArrayList<Facts> mFacts = new ArrayList<>();
    private int factNumber;
    private Facts fact;
    private ImageButton artButton;
    public static final String TOPIC_ID = "topic_id";

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

        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Art selected", Toast.LENGTH_SHORT).show();

                factTV.setVisibility(View.INVISIBLE);
                artButton.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                didyouknow.setVisibility(View.INVISIBLE);
                learn.setVisibility(View.INVISIBLE);
                art.setVisibility(View.INVISIBLE);

                ModuleFragment fragment = new ModuleFragment();
                Bundle bundle = new Bundle();
                bundle.putString(HomeFragment.TOPIC_ID, "0");
                fragment.setArguments(bundle);

                getParentFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, fragment).commit();

            }
        });

        return view;
    }




}