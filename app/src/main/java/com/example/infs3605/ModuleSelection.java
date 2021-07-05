package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//page where user can view description, choose video, read story, look at learnings and quiz
public class ModuleSelection extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "topic_id";
    private String modName, modDesc;
    private TextView moduleName, moduleDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection);

        Intent intent = getIntent();

        modName = intent.getStringExtra("Module");
        modDesc = intent.getStringExtra("Description");
        System.out.println(modName);
        System.out.println(modDesc);

        moduleName = findViewById(R.id.moduleName);
        moduleDescription = findViewById(R.id.moduleDescription);

        moduleName.setText(modName);
        moduleDescription.setText(modDesc);




    }
}
