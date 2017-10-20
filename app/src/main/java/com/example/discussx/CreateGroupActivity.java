package com.example.discussx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateGroupActivity extends AppCompatActivity {
    private Button btnCreateGroup;
    private EditText groupNameEditText;
    private DatabaseReference databaseGroups;
    private String userID;
    private String creator = "";
    private String groupID;
    private String groupName;
    private String members = "";
    private String posts = "Post";
    private String comments = "Comments";
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private static final String TAG = "CreateGroupActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        getSupportActionBar().setTitle("Creating New Discussion Group");

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseGroups = FirebaseDatabase.getInstance().getReference("Discussion Groups");
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        btnCreateGroup = (Button) findViewById(R.id.create_group);
        groupNameEditText = (EditText) findViewById(R.id.group_name);

        databaseGroups.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: Added profile to database: \n" + dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to red value.", databaseError.toException());
            }
        });

         btnCreateGroup.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     createGroups();
                 } catch (Exception e) {
                     Toast.makeText(CreateGroupActivity.this, "null ah diu", Toast.LENGTH_LONG).show();
                 }

             }
         });
    }

    private void createGroups () {

        groupID = databaseGroups.push().getKey();
        groupName = groupNameEditText.getText().toString().trim();
        CreateGroup createGroup = new CreateGroup(groupID,userID);
        CreateGroup createGroup1 = new CreateGroup("testing2");
        databaseGroups.child(groupName).child(posts).child(comments);

    }

}

