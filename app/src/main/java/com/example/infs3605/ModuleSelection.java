package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Profile;
import com.example.infs3605.Entities.ProfileData;
import com.example.infs3605.Entities.Quiz;
import com.example.infs3605.Entities.Topics;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

//page where user can view description, choose video, read story, look at learnings and quiz
public class ModuleSelection extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "topic_id";
    public static final String MODULE_ID = "module_id";
    private String modName, modDesc;
    private TextView moduleName, moduleDescription;
    private ImageButton videoButton, storyButton, closeButton, quizButton, learningsButton, commentButton;
    private int modId;
    private ImageView backgroundImage;
    private Modules mMod;
    public static final String TOPIC_ID = "topic_id";
    private Topics mTop;
    private int topicIdFK;
    private ImageView videoViewed, storyViewed, learningsViewed;
    private ProgressBar quizBar;
    private TextView quizMark;
    private int numStars;
    private ArrayList<Quiz> mQuiz = new ArrayList<>();

    private ImageButton meditateBtn;
    
    private static final String TAG = "TopicQuestionActivity";
    MyDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;
    
    private boolean isVideoViewed, isStoryViewed, isLearningsViewed, isQuizViewed;

    private int meditationModuleId = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_selection);


//        getSupportActionBar().hide();
//        getActionBar().hide();

        Intent intent = getIntent();
        modName = intent.getStringExtra("Module");
        modDesc = intent.getStringExtra("Description");
        modId = Integer.parseInt(intent.getStringExtra("id"));


        moduleName = findViewById(R.id.moduleName);
        moduleDescription = findViewById(R.id.moduleDescription);
        videoButton = findViewById(R.id.videoButton);
        storyButton = findViewById(R.id.storyButton);
        closeButton = findViewById(R.id.closeButton);
        commentButton = findViewById(R.id.commentButton);
        backgroundImage = findViewById(R.id.backgroundImage);
        quizButton = findViewById(R.id.quizButton);
        learningsButton = findViewById(R.id.learningsButton);
        
        videoViewed = findViewById(R.id.videoViewed);
        storyViewed = findViewById(R.id.storyViewed);
        learningsViewed = findViewById(R.id.learningsViewed);
        quizBar = findViewById(R.id.quizBar);
        quizMark = findViewById(R.id.quizMark);

        videoViewed.setVisibility(View.INVISIBLE);
        storyViewed.setVisibility(View.INVISIBLE);
        learningsViewed.setVisibility(View.INVISIBLE);
        quizBar.setVisibility(View.INVISIBLE);
        quizMark.setVisibility(View.INVISIBLE);

        meditateBtn = findViewById(R.id.meditateButton);

        meditateBtn.setVisibility(View.INVISIBLE);


        moduleName.setText(modName);
        moduleDescription.setText(modDesc);
        
        email = user.getEmail();

        for (Modules m : Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod = m;
                Glide.with(this).load(m.getModuleBackgroundImage()).into(backgroundImage);
            }

        }

        for (Topics t: Topics.getTopics()){
            if (t.getTopicId() == mMod.getTopicId()){
                mTop = t;
                topicIdFK = mTop.getTopicId();
            }
        }

        //execute inserting that user has accessed module into local database
        insertData();

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

        learningsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LearningsActivity.class);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Learnings selected", Toast.LENGTH_SHORT).show();

            }
        });

        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("id", String.valueOf(modId));
                intent.putExtra("mod_name", modName);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Quiz selected", Toast.LENGTH_SHORT).show();

            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", String.valueOf(topicIdFK));
                intent.putExtra("Check", "1");

                System.out.println(topicIdFK);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Back to list ", Toast.LENGTH_SHORT).show();


            }
        });

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModuleCommentsActivity.class);
                intent.putExtra("Module", modName);
                intent.putExtra("Description", modDesc);
                intent.putExtra("id", String.valueOf(modId));
                startActivity(intent);
            }
        });

        //set meditate button visibility
        if (mMod.getModuleId() == meditationModuleId) {
            meditateBtn.setVisibility(View.VISIBLE);
            Log.d(TAG, "onCreate: in if statement for button visibility " + mMod.getModuleId());

        } else {
            meditateBtn.setVisibility(View.INVISIBLE);
            Log.d(TAG, "onCreate: Else statement for btn visibility");

        }

        //meditate button listener
        meditateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditateIntroActivity.class);
                startActivity(intent);
            }
        });

    }

    private void insertData(){
        new MyViewedTask().execute();
    }

    private class MyViewedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: LOADING");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            //get email
            myDb.profileDataDao().insertSingleResult(modId, email, false, false, false, false, 0, topicIdFK);
            Log.d(TAG, "onSuccess: " + email + modId + topicIdFK);
            
            isVideoViewed = myDb.profileDataDao().getVideoViewed(email, modId);
            isStoryViewed = myDb.profileDataDao().getStoryViewed(email, modId);
            isLearningsViewed = myDb.profileDataDao().getLearningsViewed(email, modId);
            isQuizViewed = myDb.profileDataDao().getQuizViewed(email, modId);
            numStars = myDb.profileDataDao().getQuizStars(email, modId);
            
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            updateViewedData();
            Log.d(TAG, "onPostExecute: FINISHED");
            
        }

    }
    
    private void updateViewedData(){
        if (isVideoViewed == true){
            videoViewed.setVisibility(View.VISIBLE);
        }
        
        if (isStoryViewed == true){
            storyViewed.setVisibility(View.VISIBLE);
        }
        
        if (isLearningsViewed == true){
            learningsViewed.setVisibility(View.VISIBLE);

        }

        if (isQuizViewed == true){

            for (Quiz q: Quiz.getQuiz()){
                if (q.getModuleId() == modId){
                    mQuiz.add(q);
                }

            }

            quizBar.setVisibility(View.VISIBLE);
            quizMark.setVisibility(View.VISIBLE);

            quizMark.setText( numStars + "/" + mQuiz.size() + " stars");
            quizBar.setProgress( (numStars * 100) / mQuiz.size());

        }
        


        Log.d(TAG, "updateViewedData: Finished updating the views");
        
    }

    



}
