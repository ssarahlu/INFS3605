package com.example.infs3605;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Videos;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class VideoActivity extends YouTubeBaseActivity {

    private ImageView backgroundImage;
    private int modId;
    private ArrayList<Videos> mVideos = new ArrayList<>();
    private Videos mVideo;
    private TextView videoDesc;
    private String modName;
    private ArrayList<Modules> mMods = new ArrayList<>();
    private Modules mMod;
    private String modDesc;
    private ImageButton backButton;
    private Button storyButton;

    private String videoDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        backgroundImage = findViewById(R.id.backgroundImage);
        videoDesc = findViewById(R.id.videoDesc);
        backButton = findViewById(R.id.backButton);
        storyButton = findViewById(R.id.storyButton);

        Intent intent = getIntent();
        modId = Integer.parseInt(intent.getStringExtra("id"));
        modName = intent.getStringExtra("mod_name");

        videoDescription =  "Here is a video of " +  modName + ". Please watch the video.";
        videoDesc.setText(videoDescription);

        setTitle(modName);

        for (Modules m : Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod = m;
                Glide.with(this).load(m.getModuleBackgroundImage()).into(backgroundImage);
                modDesc = m.getModuleDescription();
            }
        }


        for (Videos v: Videos.getVideos()){
            if (v.getModuleId() == modId){
                mVideos.add(v);
                mVideo = mVideos.get(v.getModuleId());

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

}
