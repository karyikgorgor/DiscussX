package com.example.discussx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiscussionGroupActivity extends AppCompatActivity {
    private DatabaseReference databaseGroups;
    private DatabaseReference databasePost;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private String userID;
    private String groupID;
    private String postID;
    private String groupName;
    private EditText editTextTitle, editTextDesc;
    private Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_group);

        getSupportActionBar().setTitle(groupName);
        editTextTitle = (EditText)findViewById(R.id.title);
        editTextDesc = (EditText)findViewById(R.id.desc);

        databaseGroups.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showGroupName(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showGroupName(DataSnapshot dataSnapshot) {
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            CreateGroup createGroup = new CreateGroup();
            createGroup.setGroupName(ds.child(createGroup.getGroupID()).getValue(CreateGroup.class).getGroupName());
            groupName = createGroup.getGroupName();
        }
    }

    private void createPost() {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseGroups = FirebaseDatabase.getInstance().getReference("Discussion Groups");
        databasePost = FirebaseDatabase.getInstance().getReference("Posts");
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        postID = databasePost.push().getKey();
        CreateGroup createGroup = new CreateGroup();


    }

}
