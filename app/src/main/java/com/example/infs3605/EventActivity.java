package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Event;
import com.example.infs3605.Entities.SavedEventData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class EventActivity extends FragmentActivity implements OnMapReadyCallback{
    private static final String TAG = "EventActivity";
    SavedEventDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;

    private int eventId;

    private ImageView ivEventImage;
    private TextView tvEventName, tvEventDate, tvEventDesc, tvEventLoc;
    private ImageButton btnSave, btnSearch;
    private ImageButton btnBack;

    private ArrayList<Event> mEventList;
    private Event mEvent;

    private List<SavedEventData> list = new ArrayList<>();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        Intent intent = getIntent();
        eventId = intent.getIntExtra("eventId",0);

        ivEventImage = findViewById(R.id.ivEventImage);
        tvEventName = findViewById(R.id.tvEventName);
        tvEventDate = findViewById(R.id.tvEventDate);
        tvEventLoc = findViewById(R.id.tvEventLoc);
        tvEventDesc = findViewById(R.id.tvEventDesc);
        btnSave = findViewById(R.id.btnSave);
        btnSearch = findViewById(R.id.btnSearch);
        btnBack = findViewById(R.id.btnBack);

        email = user.getEmail();

        myDb = Room.databaseBuilder(getApplicationContext(),SavedEventDatabase.class,"myDb")
                .allowMainThreadQueries()
                .build();

        mEventList = Event.getEventList();

        for (Event event : mEventList) {
            if (event.getEventId() == eventId) {
                mEvent = event;
            }
        }

        String imageBaseUrl = "https://www.indigenous.gov.au/sites/default/files/styles/indig_thumbnail/public/";

        Glide.with(getApplicationContext()).load(imageBaseUrl + mEvent.getEventImage()).into(ivEventImage);
        tvEventName.setText(mEvent.getEventName());
        tvEventDate.setText(mEvent.getEventDate());
        tvEventDesc.setText(mEvent.getEventDesc());
        tvEventLoc.setText(mEvent.getEventLoc());

        if (myDb.savedEventDataDao().getSavedEvent(email,mEvent.getEventId()) != null) {
            btnSave.setBackgroundResource(R.drawable.saved_icon);
        } else if (myDb.savedEventDataDao().getSavedEvent(email,mEvent.getEventId()) == null) {
            btnSave.setBackgroundResource(R.drawable.unsaved_icon);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchExploreFragment();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEvent(mEvent.getEventId());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail = email;
                int mId = mEvent.getEventId();
                String mImage = mEvent.getEventImage();
                String mName = mEvent.getEventName();
                String mDate = mEvent.getEventDate();
                String mLink = mEvent.getEventLink();
                String mDesc = mEvent.getEventDesc();
                String mLoc = mEvent.getEventLoc();


                if (myDb.savedEventDataDao().getSavedEvent(mEmail,mId) == null) {
                    myDb.savedEventDataDao().saveEvent(mEmail,mId,mImage,mName,mDate,mLink,mDesc,mLoc);

                    list = myDb.savedEventDataDao().getAllSavedEvents();

                    Log.d(TAG, "onClick: first if");

                    for (SavedEventData item : list) {
                        System.out.println(item.getEmail() + " " + item.getEventId());

                    }

                    btnSave.setBackgroundResource(R.drawable.saved_icon);
//                    Toast.makeText(getApplicationContext(),"Event saved",Toast.LENGTH_SHORT).show();
                } else if (myDb.savedEventDataDao().getSavedEvent(mEmail,mId) != null) {
                    myDb.savedEventDataDao().deleteEvent(mEmail,mId);

                    list = myDb.savedEventDataDao().getAllSavedEvents();

                    Log.d(TAG, "onClick: second if");

                    for (SavedEventData item : list) {
                        System.out.println(item.getEmail() + " " + item.getEventId());

                    }

                    btnSave.setBackgroundResource(R.drawable.unsaved_icon);
//                    Toast.makeText(getApplicationContext(),"Event unsaved",Toast.LENGTH_SHORT).show();
                }


            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        String strAddress = mEvent.getEventLoc();

        LatLng location = getLocationFromAddress(this,strAddress);
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(location).title(strAddress));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17),200,null);
    }

    public LatLng getLocationFromAddress(Context context, String strAddress) {

        Geocoder coder = new Geocoder(context);
        List<Address> address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }

    private void launchExploreFragment() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("id", "0");
        intent.putExtra("Check", "2");
        startActivity(intent);
    }

    private void searchEvent(int eventId) {
        String eventBaseUrl = "https://www.indigenous.gov.au/news-and-media/event/";
        String eventUrl = mEventList.get(eventId).getEventLink();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(eventBaseUrl + eventUrl));
        startActivity(intent);
    }

}