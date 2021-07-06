package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Topics;

import java.util.ArrayList;

//page where user can view description, choose video, read story, look at learnings and quiz
public class ModuleSelection extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "topic_id";
    public static final String MODULE_ID = "module_id";
    private String modName, modDesc;
    private TextView moduleName, moduleDescription;
    private ImageButton videoButton, storyButton, closeButton;
    private int modId;
    private ImageView backgroundImage;
    private Modules mMod;
    public static final String TOPIC_ID = "topic_id";
    private Topics mTop;
    private int topicIdFK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection);

        Intent intent = getIntent();

        modName = intent.getStringExtra("Module");
        modDesc = intent.getStringExtra("Description");
        modId = Integer.parseInt(intent.getStringExtra("id"));
//        System.out.println(modName);
//        System.out.println(modDesc);

        moduleName = findViewById(R.id.moduleName);
        moduleDescription = findViewById(R.id.moduleDescription);
        videoButton = findViewById(R.id.videoButton);
        storyButton = findViewById(R.id.storyButton);
        closeButton = findViewById(R.id.closeButton);

        backgroundImage = findViewById(R.id.backgroundImage);

        moduleName.setText(modName);
        moduleDescription.setText(modDesc);

        for (Modules m : Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod = m;
                backgroundImage.setImageResource(mMod.getModuleBackgroundImage());
            }

        }

        for (Topics t: Topics.getTopics()){
            if (t.getTopicId() == mMod.getTopicId()){
                mTop = t;
                topicIdFK = mTop.getTopicId();
            }
        }



        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Video selected", Toast.LENGTH_SHORT).show();

            }
        });


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


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleActivity.class);
                intent.putExtra(TOPIC_ID, String.valueOf(topicIdFK));
                System.out.println(topicIdFK);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Back to list ", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
