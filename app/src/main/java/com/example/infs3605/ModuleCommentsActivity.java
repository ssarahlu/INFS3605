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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ModuleCommentsActivity extends AppCompatActivity {

    private static final String TAG = "";
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private CollectionReference commentRef = db.collection("comments");

    private PostsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private ImageButton btAddPost, btBack;
    private ImageView ivUser;
    private TextView tvTitle, tvAuthor, tvLastPost, tvContent, tvNoPosts;
    private EditText tvAddComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_comments);
        getSupportActionBar().hide();
        Bundle bundle = getIntent().getExtras();

//        tvTitle = findViewById(R.id.tvModuleTitle);
//        tvTitle.setText(bundle.getString("Module"));


        btBack = findViewById(R.id.backButton2);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), ModuleSelection.class);
                intent.putExtra("Module", bundle.getString("Module"));
                intent.putExtra("Description", bundle.getString("Description"));
                intent.putExtra("id", bundle.getString("id"));
                startActivity(intent);
            }
        });

        mRecyclerView = findViewById(R.id.rvComments);
        mRecyclerView.setHasFixedSize(false);

        setData();

        btAddPost = findViewById(R.id.btAddComment);
        btAddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addComment();
            }
        });


    }

    public void addComment() {
        tvAddComment = findViewById(R.id.tvAddPost);
        String comment = tvAddComment.getText().toString();
        Bundle bundle = getIntent().getExtras();
        if (comment.matches("")) {
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
                                Map<String, Object> comment = new HashMap<>();
                                comment.put("comment", tvAddComment.getText().toString());
                                comment.put("author", user.getDisplayName());
                                comment.put("authorID", user.getUid());
                                comment.put("module", bundle.getString("Module"));
                                comment.put("moduleID", bundle.getString("id"));
                                comment.put("postDate", calendar.getTime());
                                comment.put("stars", numStars);

                                // Add the note to the Firestore database
                                commentRef.document().set(comment)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Post Document successfully written!");
                                                Toast.makeText(ModuleCommentsActivity.this, "Post added!", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error writing document", e);
                                            }
                                        });
                               
                                setData();
                                tvAddComment.getText().clear();
                            }
                        }
                    });




        }
    }

    public void setData() {
        ArrayList<Post> comments = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        String threadID = bundle.getString("id");
        Query threadPosts = commentRef.whereEqualTo("moduleID", threadID);

        threadPosts.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "successful");
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                comments.add(new Post(document.getId(),
                                        document.getString("author"),
                                        document.getString("authorID"),
                                        document.getString("comment"),
                                        document.getDate("postDate"),
                                        Integer.parseInt("" + document.get("stars"))));

                            }
                            mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mAdapter = new PostsAdapter(comments, getApplicationContext());
                            mAdapter.sort();
                            mRecyclerView.setAdapter(mAdapter);

                        }
                    }
                });




    }

    public void createDeleteDialog(String commentID) {
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
                commentRef.document(commentID)
                        .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ModuleCommentsActivity.this, "Post Deleted", Toast.LENGTH_SHORT).show();


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
