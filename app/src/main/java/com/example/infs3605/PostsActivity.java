package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infs3605.Entities.DiscussionThread;
import com.example.infs3605.Entities.Levels;
import com.example.infs3605.Entities.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PostsActivity extends AppCompatActivity {

    private static final String TAG = "";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private CollectionReference postRef = db.collection("posts");

    private PostsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private ImageButton btAddPost;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ImageView ivUser;
    private TextView tvTitle, tvAuthor, tvLastPost, tvContent, tvNoPosts;
    private EditText tvAddPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Bundle bundle = getIntent().getExtras();
        ivUser = findViewById(R.id.ivUser);
        db.collection("profiles").document(bundle.getString("authorID")).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            int numStars = Integer.parseInt("" + documentSnapshot.get("stars"));
                            int numLevel = Levels.getLevel(numStars);
                            ivUser.setImageResource(Levels.getAvatar(numLevel));
                        }
                    }
                });

        tvTitle = findViewById(R.id.tvTitle);
        tvAuthor = findViewById(R.id.tvAuthor);
        tvLastPost = findViewById(R.id.tvLastPost);
        tvContent = findViewById(R.id.tvContent);

        tvTitle.setText(bundle.getString("title"));
        tvAuthor.setText(bundle.getString("author"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
        String date = dateFormat.format(bundle.get("lastPost"));
        tvLastPost.setText("Last post: " + date);
        tvContent.setText(bundle.getString("post"));

        mRecyclerView = findViewById(R.id.rvPosts);
        mRecyclerView.setHasFixedSize(false);

        setData();

        btAddPost = findViewById(R.id.btAddPost);
        btAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });


    }

    public void addPost() {
        tvAddPost = findViewById(R.id.tvAddPost);
        String title = tvAddPost.getText().toString();
        Bundle bundle = getIntent().getExtras();
        if (title.matches("")) {
            Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
        } else {

            Calendar calendar = Calendar.getInstance();
            // Store the note under an author and for a specific module
            db.collection("profiles").document(user.getUid()).get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists()) {
                                int numStars = Integer.parseInt("" + documentSnapshot.get("stars"));
                                Map<String, Object> thread = new HashMap<>();
                                thread.put("post", tvAddPost.getText().toString());
                                thread.put("author", user.getDisplayName());
                                thread.put("thread", bundle.getString("title"));
                                thread.put("threadID", bundle.getString("threadID"));
                                thread.put("postDate", calendar.getTime());
                                thread.put("stars", numStars);

                                // Add the note to the Firestore database
                                postRef.document().set(thread)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Post Document successfully written!");
                                                Toast.makeText(PostsActivity.this, "Post added!", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error writing document", e);
                                            }
                                        });
                                setData();
                            }
                        }
                    });




        }
    }

    public void setData() {
        ArrayList<Post> posts = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String threadID = bundle.getString("threadID");
        Query threadPosts = postRef.whereEqualTo("threadID", threadID);

        threadPosts.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "successful");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                posts.add(new Post(document.getString("author"),
                                        user.getUid(),
                                        document.getString("post"),
                                        document.getDate("postDate"),
                                        Integer.parseInt("" + document.get("stars"))));

                            }
                            mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mAdapter = new PostsAdapter(posts);
                            mAdapter.sort();
                            mRecyclerView.setAdapter(mAdapter);

                        }
                    }
                });




    }
}
