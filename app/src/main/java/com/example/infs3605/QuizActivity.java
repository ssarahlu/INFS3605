package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.Update;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.ProfileData;
import com.example.infs3605.Entities.Quiz;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuizActivity extends AppCompatActivity {
    private int modId, i, quizId, stars;
    private String modName, modDesc, answer, selectedAnswer;
    private RadioButton opt1, opt2, opt3, opt4;
    private RadioGroup grp;
    private TextView question, position, fin;
    private ImageButton next, check, again;
    private ImageButton cancel, returnHome;
    private ImageView img1, img2, img3, img4, imageComplete;
    private ArrayList<Quiz> mQuiz = new ArrayList<>();
    private ArrayList<Modules> mMod = new ArrayList<>();
    private Quiz q;
    private boolean correct = false;
    private String finished;
    MediaPlayer mpWrong;
    MediaPlayer mpRight;
    private static final String TAG = "QuizActivity";
    private int addedStars, mStars;
    private int firebaseStars;
    private ProgressBar quizProgress;


    MyDatabase myDb;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private String email;
    ProfileData mProfileData = new ProfileData();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

//        getActionBar().hide();


        email = user.getEmail();

        Intent intent = getIntent();
        modId = Integer.parseInt(intent.getStringExtra("id"));
        modName = intent.getStringExtra("mod_name");

        mpWrong = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        mpRight = MediaPlayer.create(getApplicationContext(), R.raw.right);

        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);
        question = findViewById(R.id.question);
//        again = findViewById(R.id.again);
        next = findViewById(R.id.next);
        check = findViewById(R.id.check);
        cancel = findViewById(R.id.cancel);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        position = findViewById(R.id.position);
        grp = findViewById(R.id.grp);
        quizProgress = findViewById(R.id.quizProgress);

        cancel.setVisibility(View.VISIBLE);

//        fin = findViewById(R.id.finished);
//        imageComplete = findViewById(R.id.imageComplete);
//        imageComplete.setVisibility(View.GONE);
//        returnHome = findViewById(R.id.returnHome);
//        returnHome.setVisibility(View.INVISIBLE);

        for (Quiz q: Quiz.getQuiz()){
            if (q.getModuleId() == modId){
                mQuiz.add(q);
            }

        }


        for (Modules m: Modules.getModules()){
            if (m.getModuleId() == modId){
                mMod.add(m);
                modDesc = m.getModuleDescription();
            }

        }
        setTitle(modName);

        if (mQuiz != null) {
            i = 0;
            quizProgress.setProgress(((i+1) * 100) / mQuiz.size());
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText("Question " + (i + 1) + "/" + mQuiz.size());
            next.setVisibility(View.GONE);
            img1.setImageResource(android.R.color.transparent);
            img2.setImageResource(android.R.color.transparent);
            img3.setImageResource(android.R.color.transparent);
            img4.setImageResource(android.R.color.transparent);
            check.setVisibility(View.VISIBLE);
//            again.setVisibility(View.GONE);

        } else {
            question.setText("Module quiz not available. Please come back when the app updates.");
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(android.R.color.transparent);
                img2.setImageResource(android.R.color.transparent);
                img3.setImageResource(android.R.color.transparent);
                img4.setImageResource(android.R.color.transparent);
                boolean answered = checkResult();
                if (answered == true) {
//                    again.setVisibility(View.GONE);
                    check.setVisibility(View.GONE);
                    next.setVisibility(View.VISIBLE);
                } else {
//                    again.setVisibility(View.GONE);
                    check.setVisibility(View.VISIBLE);
                    next.setVisibility(View.GONE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                next.setVisibility(View.GONE);

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

//        returnHome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        again.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fin.setText("");
//                if (mQuiz != null) {
//                    i = 0;
//                    stars = 0;
//                    q = mQuiz.get(i);
//                    question.setText(q.getQuestion());
//                    opt1.setText(q.getOp1());
//                    opt2.setText(q.getOp2());
//                    opt3.setText(q.getOp3());
//                    opt4.setText(q.getOp4());
//                    answer = q.getAnswer();
//                    quizId = q.getId();
//                    position.setText("Question " + i + 1 + "/" + mQuiz.size());
//                    next.setVisibility(View.GONE);
//                    img1.setImageResource(android.R.color.transparent);
//                    img2.setImageResource(android.R.color.transparent);
//                    img3.setImageResource(android.R.color.transparent);
//                    img4.setImageResource(android.R.color.transparent);
//                    check.setVisibility(View.VISIBLE);
//                    again.setVisibility(View.GONE);
//                    grp.setVisibility(View.VISIBLE);
//
//                } else {
//                    question.setText("Nothing has been added yet. Please come back when the app updates.");
//                }
//
//            }
//        });


    }

    private boolean checkResult() {
        if (opt1.isChecked()) {
            selectedAnswer = opt1.getText().toString();
            if (selectedAnswer.equals(answer)) {
                img1.setImageResource(R.drawable.correct);
                correct = true;
                mpRight.start();
                stars++;
            } else {
                img1.setImageResource(R.drawable.wrong);
                displayTick();
                correct = false;
            }
            return true;
        } else if (opt2.isChecked()) {
            selectedAnswer = opt2.getText().toString();
            if (selectedAnswer.equals(answer)) {
                img2.setImageResource(R.drawable.correct);
                correct = true;
                mpRight.start();
                stars++;
            } else {
                img2.setImageResource(R.drawable.wrong);
                displayTick();
                correct = false;
                mpWrong.start();
            }
            return true;
        } else if (opt3.isChecked()) {
            selectedAnswer = opt3.getText().toString();
            if (selectedAnswer.equals(answer)) {
                img3.setImageResource(R.drawable.correct);
                correct = true;
                mpRight.start();
                stars++;
            } else {
                img3.setImageResource(R.drawable.wrong);
                displayTick();
                correct = false;
                mpWrong.start();
            }
            return true;
        } else if (opt4.isChecked()) {
            selectedAnswer = opt4.getText().toString();
            if (selectedAnswer.equals(answer)) {
                img4.setImageResource(R.drawable.correct);
                correct = true;
                mpRight.start();
                stars++;
            } else {
                img4.setImageResource(R.drawable.wrong);
                displayTick();
                correct = false;
                mpWrong.start();
            }
            return true;

        } else {
            next.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), "Please select an answer", Toast.LENGTH_SHORT).show();
            mpWrong.start();
            return false;
        }
    }

    //displays the correct answer if the user is wrong
    public void displayTick() {
        if (answer.equals(opt1.getText().toString())) {
            img1.setImageResource(R.drawable.correct);
        } else if (answer.equals(opt2.getText().toString())) {
            img2.setImageResource(R.drawable.correct);
        } else if (answer.equals(opt3.getText().toString())) {
            img3.setImageResource(R.drawable.correct);
        } else if (answer.equals(opt4.getText().toString())) {
            img4.setImageResource(R.drawable.correct);

        } else {
            img1.setImageResource(android.R.color.transparent);
            img2.setImageResource(android.R.color.transparent);
            img3.setImageResource(android.R.color.transparent);
            img4.setImageResource(android.R.color.transparent);
        }
    }


    private void next() {
//        mpRight.stop();
//        mpWrong.stop();
        img1.setImageResource(android.R.color.transparent);
        img2.setImageResource(android.R.color.transparent);
        img3.setImageResource(android.R.color.transparent);
        img4.setImageResource(android.R.color.transparent);
        grp.clearCheck();

        //if the quiz has finished
        if (i >= mQuiz.size()) {
            new MyQuizViewedTask().execute();
            new GetStarsTask().execute();
//            tr = new TopicResult(topicId, email, stars, true);
//            new UpdateStarsTask().execute();
            next.setVisibility(View.GONE);
            grp.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
//            again.setVisibility(View.VISIBLE);
            //displays stars earnt in the mini quiz

            i = mQuiz.size();

            quizProgress.setProgress((i * 100) / mQuiz.size());

            new UpdateStarsTask().execute();


        } else if (i <= 0) {
            i = 1;
            Log.d(TAG, "onClick: line 170 displays index at " + i);
            next.setVisibility(View.VISIBLE);
            check.setVisibility(View.VISIBLE);
//            again.setVisibility(View.GONE);
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText("Question " + (i + 1) + "/" + mQuiz.size());
            quizProgress.setProgress(((i + 1) * 100) / mQuiz.size());


        } else {
            i++;
            Log.d(TAG, "onClick: line 187 displays index at " + i);
            check.setVisibility(View.VISIBLE);
//            again.setVisibility(View.GONE);
            next.setVisibility(View.VISIBLE);
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText("Question " + (i + 1) + "/" + mQuiz.size());
            quizProgress.setProgress(((i + 1) * 100) / mQuiz.size());

            if (i == (mQuiz.size() - 1)) {
                i++;
            }
        }

    }


    private void updateUi() {
//        switch (stars) {
//            case 1:
//                imgquest.setImageResource(R.drawable.one_star);
//                break;
//            case 2:
//                imgquest.setImageResource(R.drawable.two_star);
//                break;
//            case 3:
//                imgquest.setImageResource(R.drawable.three_star);
//                break;
//            case 4:
//                imgquest.setImageResource(R.drawable.four_star);
//                break;
//            case 5:
//                imgquest.setImageResource(R.drawable.five_star);
//                break;
//            case 6:
//                imgquest.setImageResource(R.drawable.six_star);
//                break;
//            case 0:
//                imgquest.setImageResource(R.drawable.no_star);
//                break;
//            default:
//                imgquest.setImageResource(R.drawable.tick);
//        }
//        question.setText( "Quiz complete!" + " \n \n You have finished this topic's knowledge check. Your result is " + stars + "/" + mQuiz.size() + "");
//        position.setText("");
//        quizProgress.setVisibility(View.INVISIBLE);
//        fin.setText(finished);
//        returnHome.setVisibility(View.VISIBLE);
//        imageComplete.setVisibility(View.VISIBLE);

        Intent intent = new Intent(getApplicationContext(), QuizCompleteActivity.class);
        intent.putExtra("result", "Your result is " + stars + "/" +  mQuiz.size());
        intent.putExtra("finished", finished);
        intent.putExtra("addedStars", String.valueOf(addedStars));
        startActivity(intent);

    }

    //update quiz viewed to true
    private class MyQuizViewedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: LOADING");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            myDb.profileDataDao().updateQuizViewed(true, email , modId);

            //check data added correctly
            mProfileData = myDb.profileDataDao().getUserProfileData(email, modId);
            System.out.println("check quiz viewed data is added " + mProfileData.isQuizViewed());

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
        }

    }


    private class GetStarsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            mStars = myDb.profileDataDao().getQuizStars(email, modId);
            Log.d(TAG, "doInBackground: Current stars for this topic are:  " + mStars);
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");

        }

    }

    private class UpdateStarsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: LOADING");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();
            Log.d(TAG, "doInBackground: The stars before updating are " + mStars);

            //if my stars is maxed out
            if (mStars >= mQuiz.size()) {
                addedStars = 0;
                finished = "You have already achieved the maximum " + mStars + "/" + mQuiz.size() + " stars for this module.";
                Log.d(TAG, "doInBackground: " + finished);
                Log.d(TAG, "doInBackground: if one" );

                //if the stars you earned from this quiz plus past quizzes is greater than the maximum value
            } else if ((mStars + stars) > mQuiz.size()) {
                if (stars == mQuiz.size()){ //if user gets full marks, give them all the stars left
                    addedStars = mQuiz.size()-mStars;
                    System.out.println("Inside added stars ");
                    System.out.println(addedStars);
                } else {
                    addedStars = (mStars + stars) - mQuiz.size();
                }

                //the addedStars == 1 statements are just so that i can change the text inside textview from star to starS - basically just for grammar
                if (addedStars == 1) {
                    finished = "You will get an additional " + addedStars + " star \n \nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                } else {
                    finished = "You will get an additional " + addedStars + " stars \n \nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                }

                Log.d(TAG, "doInBackground: if two");

                //if your current recorded number is 0 (haven't attempted quiz or haven't gotten anything right in past attempts)
            } else if (mStars == 0) {
                addedStars = stars;

                //the addedStars == 1 statements are just so that i can change the text inside textview from star to starS - basically just for grammar
                if (addedStars == 1) {
                    finished = "You have earned " + addedStars + " star \n\nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                } else {
                    finished = "You have earned " + addedStars + " stars \n\nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                }

                Log.d(TAG, "doInBackground:  if three" );
                
                //if there's room to add more stars
            } else {
                addedStars = stars;

                //the addedStars == 1 statements are just so that i can change the text inside textview from star to starS - basically just for grammar
                if (addedStars == 1) {
                    finished = "You will get an additional " + addedStars + " star \n\nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                } else {
                    finished = "You will get an additional " + addedStars + " stars \n\nYour new total is " + (addedStars + mStars) + "/" + mQuiz.size() + " stars for this module";
                    Log.d(TAG, "doInBackground: " + finished);
                }

                Log.d(TAG, "doInBackground: if four");
            }
            myDb.profileDataDao().updateQuizStars((mStars + addedStars), email, modId);
            mStars = myDb.profileDataDao().getQuizStars(email, modId);
            Log.d(TAG, "onPostExecute: my new total stars " + mStars);
            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");

            myDb.close();
            updateFirebase();
            updateUi();

        }

    }


    //basically use added stars to add shit to the db

    private void updateFirebase(){
        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            firebaseStars = Integer.parseInt("" + documentSnapshot.get("stars"));
                            Map<String, Object> stars = new HashMap<>();

                            //add their current stars plus the new ones they got from the quiz
                            stars.put("stars", (addedStars + firebaseStars));
                            userRef.set(stars, SetOptions.merge())
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, firebaseStars + " stars saved to database");
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(QuizActivity.this, "Error", Toast.LENGTH_SHORT).show();
                                            Log.d(TAG, e.toString());
                                        }
                                    });


                        }
                    }
                });


    }




}