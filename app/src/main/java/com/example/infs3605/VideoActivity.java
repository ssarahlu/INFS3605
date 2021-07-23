package com.example.infs3605;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.ProfileData;
import com.example.infs3605.Entities.Videos;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class VideoActivity extends YouTubeBaseActivity {

//    private ImageView backgroundImage;
    private int modId;
    private ArrayList<Videos> mVideos = new ArrayList<>();
    private Videos mVideo;
    private TextView videoDesc;
    private String modName;
    private ArrayList<Modules> mMods = new ArrayList<>();
    private Modules mMod;
    private String modDesc;
    private ImageButton backButton;
    private ImageButton storyButton;
    MyDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;
    ProfileData mProfileData = new ProfileData();

    private String videoDescription;
    private static final String TAG = "VideoActivity";


    private boolean videoViewed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//        getActionBar().hide();

//        backgroundImage = findViewById(R.id.backgroundImage);
        videoDesc = findViewById(R.id.videoDesc);
        backButton = findViewById(R.id.backButton);
        storyButton = findViewById(R.id.storyButton);

        Intent intent = getIntent();
        modId = Integer.parseInt(intent.getStringExtra("id"));
        modName = intent.getStringExtra("mod_name");

        videoDescription =  "Click play to watch a short video about " +  modName + ".";
        videoDesc.setText(videoDescription);

        email = user.getEmail();

        setTitle(modName);

        for (Modules m : Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod = m;
//                Glide.with(this).load(m.getModuleBackgroundImage()).into(backgroundImage);
                modDesc = m.getModuleDescription();
            }
        }


        for (Videos v: Videos.getVideos()){
            if (v.getModuleId() == modId){
                mVideo = v;

//                mVideos.add(v);
//                mVideo = mVideos.get(v.getModuleId());

            }
        }


        final YouTubePlayerView youtubePlayerView = findViewById(R.id.youtubePlayerView);

        playVideo(mVideo.getUrl(), youtubePlayerView);

        //can be back or an 'x' to show user they can go back to the page with the module description
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), ModuleSelection.class);
                myIntent.putExtra("id", String.valueOf(modId));
                myIntent.putExtra("Module", modName);
                myIntent.putExtra("Description", modDesc);
                startActivity(myIntent);
            }
        });

        //basically to go next
        storyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StoryActivity.class);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Story selected", Toast.LENGTH_SHORT).show();
            }
        });


        new MyVideoViewedTask().execute();

    }


    public void playVideo (final String videoId, YouTubePlayerView youTubePlayerView) {

    youTubePlayerView.initialize("AIzaSyBeP-aODZjmGj9aIxJK3ymBcSEvWVrw6Dg",
            new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                    YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.cueVideo(videoId);
                    System.out.println("From link ");
                }

                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                    YouTubeInitializationResult youTubeInitializationResult) {

                }
            });
    }


    //update video viewed to true
    private class MyVideoViewedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: LOADING");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            myDb.profileDataDao().updateVideoViewed(true, email , modId);

            //check data added correctly
            mProfileData = myDb.profileDataDao().getUserProfileData(email, modId);
            System.out.println("check video viewed data is added " + mProfileData.isVideoViewed());

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
        }

    }


}
