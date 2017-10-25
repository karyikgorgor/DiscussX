package com.example.discussx.UI.post_activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.discussx.Models.Post;
import com.example.discussx.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class PostActivity extends AppCompatActivity {
    private EditText mPostTitle;
    private EditText mPostDesc;
    private Button btnPost;
    private String postID;
    private String comment = "";
    private DatabaseReference postDatabase;

    private DatabaseReference titleRef;
    private DatabaseReference descRef;
    private DatabaseReference commentRef;


    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_create);

        mPostTitle = findViewById(R.id.post_title);
        mPostDesc = findViewById(R.id.post_desc);
        btnPost = findViewById(R.id.post_button);

        mProgress = new ProgressDialog(this);


        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });
    }

    private void createPost () {
        mProgress.setMessage("Posting...");


        String postTitleVal = mPostTitle.getText().toString().trim();
        String postDescVal = mPostDesc.getText().toString().trim();

        if (!TextUtils.isEmpty(postTitleVal) && !TextUtils.isEmpty(postDescVal)) {
            mProgress.show();

            postDatabase = FirebaseDatabase.getInstance().getReference("Post");
            postID = postDatabase.push().getKey();
            Post post = new Post (postTitleVal, postDescVal, postID, comment);

         //   newPost.child("title").setValue(postTitleVal);
           // newPost.child("desc").setValue(postDescVal);

            postDatabase.child(postID).setValue(post);

            mProgress.dismiss();
            Intent intent = new Intent(PostActivity.this, PostActivityAssist.class);
            startActivity(intent);

        } else {
            Toast.makeText(PostActivity.this, "Please enter everything", Toast.LENGTH_LONG).show();
        }
    }
}



