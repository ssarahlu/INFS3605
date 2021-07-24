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
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import com.google.firebase.firestore.SetOptions;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private ImageButton btAddPost, btBack;
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
        tvLastPost = findViewById(R.id.tvPostTime);
        tvContent = findViewById(R.id.tvContent);

        btBack = findViewById(R.id.backButton2);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", "0");
                intent.putExtra("Check", "3");
                startActivity(intent);
            }
            });

        tvTitle.setText(bundle.getString("title"));
        tvAuthor.setText(bundle.getString("author"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
        String date = dateFormat.format(bundle.get("postTime"));
        tvLastPost.setText("" + date);
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

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);


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
                                Map<String, Object> post = new HashMap<>();
                                post.put("post", tvAddPost.getText().toString());
                                post.put("author", user.getDisplayName());
                                post.put("authorID", user.getUid());
                                post.put("thread", bundle.getString("title"));
                                post.put("threadID", bundle.getString("threadID"));
                                post.put("postDate", calendar.getTime());
                                post.put("stars", numStars);

                                // Add the note to the Firestore database
                                postRef.document().set(post)
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
                                Bundle bundle = getIntent().getExtras();
                                String threadID = bundle.getString("threadID");
                                db.collection("discussion_threads").document(threadID).get()
                                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                if(documentSnapshot.exists()){
                                                    int numReplies = Integer.parseInt(documentSnapshot.get("numberOfReplies").toString()) + 1;
                                                    Map<String, Object> thread = new HashMap<>();
                                                    thread.put("lastPostTime", calendar.getTime());
                                                    thread.put("numberOfReplies", numReplies);
                                                    db.collection("discussion_threads").document(threadID)
                                                            .set(thread, SetOptions.merge())
                                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void unused) {
                                                                Log.d(TAG, "thread details saved");
                                                                }
                                                            });

                                                }
                                            }
                                        });
                                setData();
                                tvAddPost.getText().clear();
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
                                posts.add(new Post(document.getId(),
                                        document.getString("author"),
                                        document.getString("authorID"),
                                        document.getString("post"),
                                        document.getDate("postDate"),
                                        Integer.parseInt("" + document.get("stars"))));

                            }
                            mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mAdapter = new PostsAdapter(posts, getApplicationContext());
                            mAdapter.sort();
                            mRecyclerView.setAdapter(mAdapter);

                        }
                    }
                });




    }

    public void createDeleteDialog(String postID) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        Button btConfirm, btCancel;

        final View addThreadPopup = getLayoutInflater().inflate(R.layout.delete_confirmation, null);

        btConfirm = addThreadPopup.findViewById(R.id.btConfirm);
        btCancel = addThreadPopup.findViewById(R.id.btCancel);

        // Show the popup
        dialogBuilder.setView(addThreadPopup);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        // Set the save button to save the note
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postRef.document(postID)
                        .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(PostsActivity.this, "Post Deleted", Toast.LENGTH_SHORT).show();
                        Bundle bundle = getIntent().getExtras();
                        String threadID = bundle.getString("threadID");
                        db.collection("discussion_threads").document(threadID).get()
                                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        if(documentSnapshot.exists()){
                                            int numReplies = Integer.parseInt(documentSnapshot.get("numberOfReplies").toString()) - 1;
                                            Map<String, Object> thread = new HashMap<>();
                                            thread.put("numberOfReplies", numReplies);
                                            db.collection("discussion_threads").document(threadID)
                                                    .set(thread, SetOptions.merge())
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void unused) {
                                                            Log.d(TAG, "thread details saved");
                                                        }
                                                    });

                                        }
                                    }
                                });

                    }
                });
                setData();
                dialog.dismiss();
            }
        });

        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
