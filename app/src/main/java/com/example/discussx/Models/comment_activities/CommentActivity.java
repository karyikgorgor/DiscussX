package com.example.discussx.Models.comment_activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.discussx.Models.Post;
import com.example.discussx.R;
import com.example.discussx.UI.post_activities.NavPostActivity;
import com.example.discussx.UI.post_activities.PostActivity;
import com.example.discussx.UI.post_activities.PostActivityAssist;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CommentActivity extends AppCompatActivity {
    private EditText mComment;
    private Button btnComment;
    private String commentID;
    private String postID;
    private DatabaseReference commentRef;
    private DatabaseReference postDatabase;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_comment);

            mComment = findViewById(R.id.comment);
            btnComment = findViewById(R.id.comment_button);

            mProgress = new ProgressDialog(this);

            btnComment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    createComment();
                }
            });

            postDatabase = FirebaseDatabase.getInstance().getReference("Post");
        }

    private void createComment () {
        postDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String postID = getIntent().getExtras().getString("postIDForComment");
                String postTitle = getIntent().getExtras().getString("postTitleForComment");
                String postDesc = getIntent().getExtras().getString("postDescForComment");

                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Post post = ds.getValue(Post.class);
                    if (postID.equals(post.getPostID()) && postTitle.equals(post.getTitle()) && postDesc.equals(post.getDesc())) {


                        mProgress.setMessage("Commenting...");
                        String commentVal = mComment.getText().toString().trim();

                        if (!TextUtils.isEmpty(commentVal) && !TextUtils.isEmpty(commentVal)) {
                            mProgress.show();

                            commentID = postDatabase.push().getKey();

                            postDatabase.child(postID).child("comment").child(commentID).setValue(commentVal);

                            mProgress.dismiss();

                            Intent intent = new Intent(CommentActivity.this, NavPostActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(CommentActivity.this, "Please enter everything", Toast.LENGTH_LONG).show();
                        }
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    }

