package com.example.infs3605;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infs3605.Entities.Event;
import com.example.infs3605.Entities.Shopping;

import java.util.ArrayList;

public class ExploreFragment extends Fragment {

    //event
    private RecyclerView eventRecyclerView;
    private RecyclerView.Adapter eventAdapter;
    private RecyclerView.LayoutManager eventLayoutManager;


    //social
    private RecyclerView socialRecyclerView;
    private RecyclerView.Adapter socialAdapter;
    private RecyclerView.LayoutManager socialLayoutManager;

    private ArrayList<Integer> mImageUrls = new ArrayList<>();

    //shopping
    private RecyclerView shoppingRecyclerView;
    private RecyclerView.Adapter shoppingAdapter;
    private RecyclerView.LayoutManager shoppingLayoutManager;



    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_explore, container, false);


        //events
        eventRecyclerView = view.findViewById(R.id.rvEvents);
        eventRecyclerView.setHasFixedSize(true);


        eventLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        eventRecyclerView.setLayoutManager(eventLayoutManager);

        EventAdapter.RecyclerViewClickListener eventListener = new EventAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchEventActivity();
            }
        };

        eventAdapter = new EventAdapter(Event.getEventList(), eventListener);
        eventRecyclerView.setAdapter(eventAdapter);

        //social
        getImages();

        socialRecyclerView = view.findViewById(R.id.rvSocial);
        socialRecyclerView.setHasFixedSize(true);

        socialLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false);
        socialRecyclerView.setLayoutManager(socialLayoutManager);

        SocialAdapter.RecyclerViewClickListener socialListener = new SocialAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchSocialActivity();
            }
        };

        socialAdapter = new SocialAdapter(mImageUrls, socialListener);
        socialRecyclerView.setAdapter(socialAdapter);

        //shopping
        shoppingRecyclerView = view.findViewById(R.id.rvShopping);
        shoppingRecyclerView.setHasFixedSize(true);


        shoppingLayoutManager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL,false);
        shoppingRecyclerView.setLayoutManager(shoppingLayoutManager);

        ShoppingAdapter.RecyclerViewClickListener shoppingListener = new ShoppingAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchShoppingActivity();
            }
        };

        shoppingAdapter = new ShoppingAdapter(Shopping.getShoppingList(), shoppingListener);
        shoppingRecyclerView.setAdapter(shoppingAdapter);

        return view;
    }

    private void getImages() {
        mImageUrls.add(R.drawable.event1);
        mImageUrls.add(R.drawable.event2);
        mImageUrls.add(R.drawable.event3);
        mImageUrls.add(R.drawable.event4);
        mImageUrls.add(R.drawable.event5);
        mImageUrls.add(R.drawable.event1);
        mImageUrls.add(R.drawable.event2);
        mImageUrls.add(R.drawable.event3);
        mImageUrls.add(R.drawable.event4);
    }

    private void launchEventActivity() {

    }

    private void launchSocialActivity() {

    }

    private void launchShoppingActivity() {

    }

}