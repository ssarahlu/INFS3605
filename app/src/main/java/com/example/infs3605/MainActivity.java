package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.Facts;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.page_1:
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment_container, homeFragment, "FragmentName");
                    fragmentTransaction1.commit();
                    break;
                case R.id.page_2:
                    Toast.makeText(MainActivity.this, "Explore", Toast.LENGTH_SHORT).show();
                    ExploreFragment exploreFragment = new ExploreFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment_container, exploreFragment, "FragmentName");
                    fragmentTransaction2.commit();

                    break;
                case R.id.page_3:
                    Toast.makeText(MainActivity.this, "Rewards", Toast.LENGTH_SHORT).show();
                    RewardsFragment rewardsFragment = new RewardsFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragment_container, rewardsFragment, "FragmentName");
                    fragmentTransaction3.commit();

                    break;
                case R.id.page_4:
                    Toast.makeText(MainActivity.this, "Meditate", Toast.LENGTH_SHORT).show();
                    MeditateFragment meditateFragment = new MeditateFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fragment_container, meditateFragment, "FragmentName");
                    fragmentTransaction4.commit();
                    break;

                case R.id.page_5:
                    Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.fragment_container, profileFragment, "FragmentName");
                    fragmentTransaction5.commit();

                    System.out.println("switch ");

                    break;
            }
            return true;
        }
    };

    private static final String TAG = "MainActivity";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DocumentReference userRef = db.collection("profiles").document(user.getUid());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        userRef.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            Log.d(TAG, "Profile Exists");


                        } else {
                            // References the createProfile method
                            createProfile();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.toString());

                    }
                });


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Intent intent = getIntent();

        if (intent.getStringExtra("id") != null){

            String s1 = intent.getStringExtra("Check");
            int topicId = Integer.parseInt(intent.getStringExtra("id"));
            if (s1.equals("1")){

                s1 = "";
                ModuleFragment fragment = new ModuleFragment();
                Bundle bundle = new Bundle();
                bundle.putString(HomeFragment.TOPIC_ID, String.valueOf(topicId));
                fragment.setArguments(bundle);

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_container, fragment).commit();

                //or default
            } if (s1.equals("4")) {

                s1 = "";
                bottomNav.setSelectedItemId(R.id.page_4);
            }
        } else {

            HomeFragment hf = new HomeFragment();
            FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.fragment_container, hf, "FragmentName");
            fragmentTransaction1.commit();

            System.out.println("Here");
        }

    }

    public void createProfile(){
        // Get name and email from Firebase Authentication
        String name = user.getDisplayName();
        String email = user.getEmail();
        int stars = 0;

        // Create a Hash Map with the desired values
        Map<String, Object> profile = new HashMap<>();
        profile.put("name", name);
        profile.put("email", email);
        profile.put("stars", stars);

        // Create a document with UID as the reference
        userRef.set(profile)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "Profiles Document successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });





    }


}




