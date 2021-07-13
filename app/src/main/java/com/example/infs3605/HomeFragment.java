package com.example.infs3605;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Facts;
import com.example.infs3605.Entities.Modules;
import com.example.infs3605.Entities.ProfileData;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView factTV, name, didyouknow, learn, starTV, artProgress;
    private ArrayList<Facts> mFacts = new ArrayList<>();
    private int factNumber, firebaseStars;
    private Facts fact;
    private ImageButton artButton;
    public static final String TOPIC_ID = "topic_id";
    private String fname, hiString;
    private ImageView starImage;
    private boolean isVideoViewed, isStoryViewed, isLearningsViewed, isQuizViewed;
    private int numArt, numSpirit, numRituals, numLang;

//    private List<ProfileData> artProfileProgress = new ArrayList<>();
//    private List<ProfileData> spiritualityProfileProgress = new ArrayList<>();
//    private List<ProfileData> ritualsProfileProgress = new ArrayList<>();
//    private List<ProfileData> languagesProfileProgress = new ArrayList<>();

    private int artProfileProgress, spiritualityProfileProgress, ritualsProfileProgress, languagesProfileProgress;
    private List<ProfileData> list = new ArrayList<>();

    MyDatabase myDb;

    private String email;
    private static final String TAG = "HomeFragment";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        factTV = view.findViewById(R.id.factTV);
        artButton = view.findViewById(R.id.artButton);
        name = view.findViewById(R.id.name);
        learn = view.findViewById(R.id.learn);
        didyouknow = view.findViewById(R.id.didyouknow);
        starTV = view.findViewById(R.id.starTV);
        starImage = view.findViewById(R.id.starImage);
        artProgress = view.findViewById(R.id.artProgress);

        artProfileProgress = 0;
        spiritualityProfileProgress = 0;
        ritualsProfileProgress = 0;
        languagesProfileProgress = 0;
        numArt = 0;
        numLang = 0;
        numRituals = 0;
        numSpirit = 0;

        email = user.getEmail();

        //to set the Hey <name>
        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){
                            fname = ("" + documentSnapshot.get("fname"));
                            hiString = "Hey " + fname;
                            name.setText(hiString);

                            firebaseStars = Integer.parseInt("" + documentSnapshot.get("stars"));
                            starTV.setText(firebaseStars + "");

                        }
                    }
                });


        for (Facts f : Facts.getFacts()) {
            mFacts.add(f);

        }

        for (Modules m : Modules.getModules()){
            if (m.getTopicId() == 0){
                numArt++;
            } else if (m.getTopicId() == 1){
                numSpirit++;
            } else if (m.getTopicId() == 2){
                numRituals++;
            } else if (m.getTopicId() == 3){
                numLang++;
            } else {

            }

        }

        new MyViewedTask().execute();

        if (mFacts != null){
            factNumber = (int)(Math.random() * mFacts.size() - 1) + 1;
            System.out.println( "my random number is " + factNumber);
            fact = mFacts.get(factNumber);
            System.out.println(fact);
            factTV.setText(fact.getFact());

        }

        artButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Art selected", Toast.LENGTH_SHORT).show();

                factTV.setVisibility(View.INVISIBLE);
                artButton.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                didyouknow.setVisibility(View.INVISIBLE);
                learn.setVisibility(View.INVISIBLE);
                starTV.setVisibility(View.INVISIBLE);
                starImage.setVisibility(View.INVISIBLE);
                artProgress.setVisibility(View.INVISIBLE);

                ModuleFragment fragment = new ModuleFragment();
                Bundle bundle = new Bundle();
                bundle.putString(HomeFragment.TOPIC_ID, "0");
                fragment.setArguments(bundle);

                getParentFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, fragment).commit();

            }
        });




        return view;
    }


    private class MyViewedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: LOADING");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            myDb = Room.databaseBuilder(getActivity().getApplicationContext(), MyDatabase.class, "my-db.db")
                    .build();

            Log.d(TAG, "doInBackground: " + email);

            artProfileProgress = myDb.profileDataDao().countTopicProgress(email, 0, true, true, true, true);
            Log.d(TAG, "doInBackground: art profile progress" + artProfileProgress);

            //TODO - UNCOMMENT THESE ONCE WE HAVE THE OTHER 4 MODULES DONE
//            spiritualityProfileProgress = myDb.profileDataDao().countTopicProgress(email, 1, true, true, true, true);
//            ritualsProfileProgress = myDb.profileDataDao().countTopicProgress(email, 2, true, true, true, true);
//            languagesProfileProgress = myDb.profileDataDao().countTopicProgress(email, 3, true, true, true, true);



            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);
            Log.d(TAG, "onPostExecute: FINISHED");
            updateUi();

        }

        private void updateUi(){

            artProgress.setText( artProfileProgress + "/"+ numArt + " courses");

        }

    }


}