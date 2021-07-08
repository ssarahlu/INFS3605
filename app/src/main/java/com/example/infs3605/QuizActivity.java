package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.Quiz;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private int modId, i, quizId, stars;
    private String modName, modDesc, answer, selectedAnswer;
    private RadioButton opt1, opt2, opt3, opt4;
    private RadioGroup grp;
    private TextView question, position, fin;
    private Button next, check, again;
    private ImageButton cancel;
    private ImageView img1, img2, img3, img4;
    private ArrayList<Quiz> mQuiz = new ArrayList<>();
    private ArrayList<Modules> mMod = new ArrayList<>();
    private Quiz q;
    private boolean correct = false;
    private String finished;
    MediaPlayer mpWrong;
    MediaPlayer mpRight;
    private static final String TAG = "QuizActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setTitle("Quiz");

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
        again = findViewById(R.id.again);
        next = findViewById(R.id.next);
        check = findViewById(R.id.check);
        cancel = findViewById(R.id.cancel);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        position = findViewById(R.id.position);
        grp = findViewById(R.id.grp);
        fin = findViewById(R.id.finished);

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
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText(i + 1 + "/" + mQuiz.size());
            next.setVisibility(View.GONE);
            img1.setImageResource(android.R.color.transparent);
            img2.setImageResource(android.R.color.transparent);
            img3.setImageResource(android.R.color.transparent);
            img4.setImageResource(android.R.color.transparent);
            check.setVisibility(View.VISIBLE);
            again.setVisibility(View.GONE);

        } else {
            question.setText("Module quiz not available. Please come back when the app updates.");
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO - check if null
                img1.setImageResource(android.R.color.transparent);
                img2.setImageResource(android.R.color.transparent);
                img3.setImageResource(android.R.color.transparent);
                img4.setImageResource(android.R.color.transparent);
                boolean answered = checkResult();
                if (answered == true) {
                    again.setVisibility(View.GONE);
                    check.setVisibility(View.GONE);
                    next.setVisibility(View.VISIBLE);
                } else {
                    again.setVisibility(View.GONE);
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

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fin.setText("");
                if (mQuiz != null) {
                    i = 0;
                    stars = 0;
                    q = mQuiz.get(i);
                    question.setText(q.getQuestion());
                    opt1.setText(q.getOp1());
                    opt2.setText(q.getOp2());
                    opt3.setText(q.getOp3());
                    opt4.setText(q.getOp4());
                    answer = q.getAnswer();
                    quizId = q.getId();
                    position.setText(i + 1 + "/" + mQuiz.size());
                    next.setVisibility(View.GONE);
                    img1.setImageResource(android.R.color.transparent);
                    img2.setImageResource(android.R.color.transparent);
                    img3.setImageResource(android.R.color.transparent);
                    img4.setImageResource(android.R.color.transparent);
                    check.setVisibility(View.VISIBLE);
                    again.setVisibility(View.GONE);
                    grp.setVisibility(View.VISIBLE);

                } else {
                    question.setText("Nothing has been added yet. Please come back when the app updates.");
                }

            }
        });


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
        img1.setImageResource(android.R.color.transparent);
        img2.setImageResource(android.R.color.transparent);
        img3.setImageResource(android.R.color.transparent);
        img4.setImageResource(android.R.color.transparent);
        grp.clearCheck();
        if (i >= mQuiz.size()) {
//            new MyViewedTask().execute();
//            new GetStarsTask().execute();
//            tr = new TopicResult(topicId, email, stars, true);
//            new UpdateStarsTask().execute();
            next.setVisibility(View.GONE);
            grp.setVisibility(View.GONE);
            check.setVisibility(View.GONE);
            again.setVisibility(View.VISIBLE);
            //displays stars earnt in the mini quiz

            i = mQuiz.size();
            updateUi();



        } else if (i <= 0) {
            i = 1;
            Log.d(TAG, "onClick: line 170 displays index at " + i);
            next.setVisibility(View.VISIBLE);
            check.setVisibility(View.VISIBLE);
            again.setVisibility(View.GONE);
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText(i + 1 + "/" + mQuiz.size());
        } else {
            i++;
            Log.d(TAG, "onClick: line 187 displays index at " + i);
            check.setVisibility(View.VISIBLE);
            again.setVisibility(View.GONE);
            next.setVisibility(View.VISIBLE);
            q = mQuiz.get(i);
            question.setText(q.getQuestion());
            opt1.setText(q.getOp1());
            opt2.setText(q.getOp2());
            opt3.setText(q.getOp3());
            opt4.setText(q.getOp4());
            answer = q.getAnswer();
            quizId = q.getId();
            position.setText(i + 1 + "/" + mQuiz.size());

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
        question.setText("You have finished this topic's knowledge check. Your result is " + stars + "/" + mQuiz.size() + "");
        position.setText("");
        fin.setText(finished);
    }
}