package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infs3605.Entities.Levels;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileFragment extends Fragment {

    private TextView email, stars, animal, name;
    private int numStars, numLevel;
    private ImageButton btSignOut, btLeaderboard, help, feedback, rewardsButton;
    private ImageView avatar;
    private String emailString, animalLevelString;
    private static final String TAG = "ProfileFragment";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //profile = view.findViewById(R.id.profile);

        //profile.setText("Profile Screen");

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        btSignOut = view.findViewById(R.id.btSignOut);
        email = view.findViewById(R.id.email);
        stars = view.findViewById(R.id.stars);
        animal = view.findViewById(R.id.animal);
        name = view.findViewById(R.id.name);
        avatar = view.findViewById(R.id.avatar);
        help = view.findViewById(R.id.help);
        feedback = view.findViewById(R.id.feedback);
        rewardsButton = view.findViewById(R.id.rewardsButton);

        emailString = user.getEmail();
        email.setText(emailString);
//        name.setText(user.getDisplayName());

        //to set the Hey <name>
        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()){

                            name.setText(documentSnapshot.get("fname") + " " + documentSnapshot.get("lname") + "");
                            numStars = Integer.parseInt("" + documentSnapshot.get("stars"));

                            stars.setText(numStars + "");

                            numLevel = Levels.getLevel(numStars);

                            animalLevelString = "<b>" + Levels.getAnimal(numLevel) + "</b> " + " | Level " + numLevel;
                            animal.setText(Html.fromHtml(animalLevelString));

                            avatar.setImageResource(Levels.getAvatar(Levels.getLevel(numStars)));



                        }
                    }
                });



        btSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });

        btLeaderboard = view.findViewById(R.id.btLeaderboard);

        btLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LeaderboardActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void signOut() {
        AuthUI.getInstance()
                .signOut(getActivity())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        logOut();
                    }
                });

    }


    // Log out the user and prevent the user from accessing anything until logging in again
    public void logOut() {
        Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }





}