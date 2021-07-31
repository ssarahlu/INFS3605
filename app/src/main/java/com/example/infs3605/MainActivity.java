package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.page_1:
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.fragment_container, homeFragment, "FragmentName");
                    fragmentTransaction1.commit();
                    break;
                case R.id.page_2:
                    DiscussionFragment discussionFragment = new DiscussionFragment();
                    FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction3.replace(R.id.fragment_container, discussionFragment, "FragmentName");
                    fragmentTransaction3.commit();

                    break;
                case R.id.page_3:

                    ExploreFragment exploreFragment = new ExploreFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.fragment_container, exploreFragment, "FragmentName");
                    fragmentTransaction2.commit();

                    break;

                /*
                case R.id.page_4:
                    Toast.makeText(MainActivity.this, "Meditate", Toast.LENGTH_SHORT).show();
                    MeditateFragment meditateFragment = new MeditateFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.fragment_container, meditateFragment, "FragmentName");
                    fragmentTransaction4.commit();
                    break;

                 */

                case R.id.page_4:
                    ProfileFragment profileFragment = new ProfileFragment();
                    FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction5.replace(R.id.fragment_container, profileFragment, "FragmentName");
                    fragmentTransaction5.commit();

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
                        Log.d(TAG, e.toString());

                    }
                });

        setContentView(R.layout.activity_main);

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

//            } else if (s1.equals("4")) {
//
//                s1 = "";
//                bottomNav.setSelectedItemId(R.id.page_4);
            } else if (s1.equals("2")) {

                s1 = "";
                bottomNav.setSelectedItemId(R.id.page_3);
            } else if (s1.equals("3")) {

                s1 = "";
                bottomNav.setSelectedItemId(R.id.page_2);
            } else if (s1.equals("5")) {
                bottomNav.setSelectedItemId(R.id.page_4);
            }

        } else {
            //or default
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
        String[] nameArr = user.getDisplayName().split(" ");
        String fname, lname;

        if (nameArr.length > 1){
             fname = nameArr[0];
             lname = nameArr[1];
        } else {
            fname = nameArr[0];
            lname = " ";

        }




        // Create a Hash Map with the desired values
        Map<String, Object> profile = new HashMap<>();
        profile.put("name", name);
        profile.put("email", email);
        profile.put("stars", stars);
        profile.put("fname", fname);
        profile.put("lname", lname);
        profile.put("levelAnimal", "joey");
        profile.put("level", 1);

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




