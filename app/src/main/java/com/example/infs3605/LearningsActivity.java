package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Learnings;
import com.example.infs3605.Entities.Modules;

import java.util.ArrayList;

public class LearningsActivity extends AppCompatActivity {

    private int modId, width;
    private String modName, modDesc;
    private static final String TAG = "LearningsActivity";
    private static int i = 0;
    private Learnings learnings;
    private ArrayList<Learnings> mLearnings = new ArrayList<>();
    private ImageView image;
    private TextView title, info, position;
    private ImageButton cancel;
    private Button next, previous, check;
    private ArrayList<Modules> mMod = new ArrayList<>();
    ConstraintSet constraintSet;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnings);
        Intent intent = getIntent();
        modId = Integer.parseInt(intent.getStringExtra("id"));
        modName = intent.getStringExtra("mod_name");

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        info = findViewById(R.id.info);
        cancel = findViewById(R.id.cancel);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        position = findViewById(R.id.position);
        check = findViewById(R.id.check);

        //gets the width of the screen
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;

        for (Learnings l : Learnings.getLearnings()){
            if(l.getModuleId() == modId){
                mLearnings.add(l);
            }
        }

        for (Modules m: Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod.add(m);
                modDesc = m.getModuleDescription();
            }

        }

        if (mLearnings != null) {
            i = 0;
            learnings = mLearnings.get(i);
            title.setText(modName.toUpperCase());
            info.setText(learnings.getInformation());
            Glide.with(this).load(learnings.getImage()).into(image);
            position.setText(i + 1 + "/" + mLearnings.size());
            Log.d(TAG, "onCreate: line 97 displays index at " + i);

            //changes button so that only the next button is visible when the user is on the first information object
            next.setVisibility(View.VISIBLE);
            previous.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            image.setVisibility(View.VISIBLE);
            constraintLayout = findViewById(R.id.constraintLayout);
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.next, ConstraintLayout.LayoutParams.MATCH_PARENT);
            constraintSet.applyTo(constraintLayout);

        } else {
            info.setText("Nothing has been added yet. Please come back when the app updates.");
        }


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModuleSelection.class);
                intent.putExtra("Module", modName);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("Description", modDesc);
                startActivity(intent);
            }
        });

        //go to quiz button
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);

                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Quiz selected", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void next() {
        //if users has finished learnring, the check knowledge button will be displayed so that they can take a mini quiz
        if (i >= mLearnings.size()) {
            next.setVisibility(View.GONE);
            previous.setVisibility(View.VISIBLE);
            //sets components with data
            info.setText("You have finished your learning");
            check.setVisibility(View.VISIBLE);
            image.setImageResource(R.drawable.finished_course_stars);
            position.setText("");
            i = mLearnings.size();
            Log.d(TAG, "onClick: line 167 displays index at " + i);
            //button dynamic change
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.previous, ConstraintLayout.LayoutParams.MATCH_PARENT);
            constraintSet.applyTo(constraintLayout);

        } else if (i <= 0) {
            i = 1;
            Log.d(TAG, "onClick: line 170 displays index at " + i);
            previous.setVisibility(View.VISIBLE);
            check.setVisibility(View.GONE);

            //sets components with data
            learnings = mLearnings.get(i);
            info.setText(learnings.getInformation());
            Glide.with(this).load(learnings.getImage()).into(image);
            position.setText(i + 1 + "/" + mLearnings.size());
            image.setVisibility(View.VISIBLE);

            //button dynamic change
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.previous, width / 2);
            constraintSet.applyTo(constraintLayout);
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.next, width / 2);
            constraintSet.applyTo(constraintLayout);

        } else {
            i++;
            Log.d(TAG, "onClick: line 187 displays index at " + i);
            previous.setVisibility(View.VISIBLE);
            check.setVisibility(View.GONE);
            learnings = mLearnings.get(i);
            info.setText(learnings.getInformation());
            Glide.with(this).load(learnings.getImage()).into(image);
            position.setText(i + 1 + "/" + mLearnings.size());
            image.setVisibility(View.VISIBLE);

            if (i == (mLearnings.size() - 1)) {
                i++;
                Log.d(TAG, "onClick: line 201 sets index at " + i);
            }

            //button dynamic change
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.next, width / 2);
            constraintSet.applyTo(constraintLayout);


        }

    }

    private void back() {
        if (i == mLearnings.size()) {
            i--;
            Log.d(TAG, "onClick: line 210 displays index at " + i);
            previous.setVisibility(View.VISIBLE);
            check.setVisibility(View.GONE);
            //sets components with data
            learnings = mLearnings.get(i);
            info.setText(learnings.getInformation());
            Glide.with(this).load(learnings.getImage()).into(image);
            position.setText(i + 1 + "/" + mLearnings.size());
            image.setVisibility(View.VISIBLE);

            //button dynamic change
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.next, width / 2);
            constraintSet.applyTo(constraintLayout);
            next.setVisibility(View.VISIBLE);
            constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.constrainWidth(R.id.previous, width / 2);
            constraintSet.applyTo(constraintLayout);


        } else {
            i--;
            Log.d(TAG, "onClick: line 230 sets index at " + i);
            if (i <= 0) {
                previous.setVisibility(View.GONE);
                check.setVisibility(View.GONE);
                i = 0;
                Log.d(TAG, "onClick: line 230 displays index at " + i);
                learnings = mLearnings.get(i);
                info.setText(learnings.getInformation());
                Glide.with(this).load(learnings.getImage()).into(image);
                position.setText(i + 1 + "/" + mLearnings.size());
                image.setVisibility(View.VISIBLE);

                //button dynamic change
                constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.constrainWidth(R.id.next, ConstraintLayout.LayoutParams.MATCH_PARENT);
                constraintSet.applyTo(constraintLayout);

            } else {
                Log.d(TAG, "onClick: line 245 displays index at " + i);
                previous.setVisibility(View.VISIBLE);
                check.setVisibility(View.GONE);
                learnings = mLearnings.get(i);
                info.setText(learnings.getInformation());
                Glide.with(this).load(learnings.getImage()).into(image);
                position.setText(i + 1 + "/" + mLearnings.size());
                image.setVisibility(View.VISIBLE);

                //button dynamic change
                constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.constrainWidth(R.id.next, width / 2);
                constraintSet.applyTo(constraintLayout);
                next.setVisibility(View.VISIBLE);
                constraintSet = new ConstraintSet();
                constraintSet.clone(constraintLayout);
                constraintSet.constrainWidth(R.id.previous, width / 2);
                constraintSet.applyTo(constraintLayout);

            }
        }
    }



}