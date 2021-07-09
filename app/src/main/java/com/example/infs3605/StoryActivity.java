package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Story;

public class StoryActivity extends AppCompatActivity {

    private TextView storyTV;
    private int modId;
    private String modName, modDesc;
    private Story mSto;
    private ImageView storyImage;
    private ImageButton backButton, learningButton;
    private Modules mMod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        modId = Integer.parseInt(intent.getStringExtra("id"));
        modName = intent.getStringExtra("mod_name");

        storyTV = findViewById(R.id.storyTV);
        storyImage = findViewById(R.id.storyImage);
        backButton = findViewById(R.id.backButton);
        learningButton = findViewById(R.id.learningsButton);

        storyTV.setMovementMethod(new ScrollingMovementMethod());


        for (Story s: Story.getStory()){
            if (s.getModuleId() == modId){
                mSto = s;
                storyTV.setText(mSto.getInformation());
                Glide.with(this).load(mSto.getImage()).into(storyImage);

            }

        }


        for (Modules m : Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod = m;
                modDesc = m.getModuleDescription();
            }
        }
        setTitle(modName);


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

        learningButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearningsActivity.class);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Story selected", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
