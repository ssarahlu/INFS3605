package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.content.Intent;

import com.firebase.ui.auth.AuthUI;

import com.google.firebase.auth.FirebaseAuth;


import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the Current User instance. If not signed in, go to LoginActivity, otherwise go straight to HomeActivity
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.EmailBuilder().build());
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setLogo(R.mipmap.logo_orange)
//                            .setTheme(R.style.LoginTheme)
                            .setAvailableProviders(providers)
                            .build(), RC_SIGN_IN);

        } else {

            launchHome();
        }
    }


    // Once signed in, Start the HomeActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_SIGN_IN && resultCode == RESULT_OK) {
            launchHome();
        }
    }

    public void launchHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    }
