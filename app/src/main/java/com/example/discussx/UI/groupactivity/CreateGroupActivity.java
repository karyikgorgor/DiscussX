package com.example.discussx.UI.groupactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.discussx.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateGroupActivity extends AppCompatActivity implements ValueEventListener{
    private EditText groupNameEditText;
    private Button btnCreateGroup;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference databaseGroups;
    private DatabaseReference groupNameRef;
    private DatabaseReference groupIDRef;
    private DatabaseReference creatorNameRef;
    private DatabaseReference memberRef;
    private String creator = "";
    private String groupID;
    private String userID;
    private String groupName;
    private String members = "Members";
    private String posts = "Post";
    private String comments = "Comments";
    private FirebaseAuth mAuth;
    private static final String TAG = "CreateGroupActivity";
    private TextView showGroupName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_group);

        groupNameEditText = findViewById(R.id.group_name);
        showGroupName = findViewById(R.id.show_group_name);
        btnCreateGroup = findViewById(R.id.create_group);

        btnCreateGroup();



    }

   /* public void createGroups (View view) {
        groupName = groupNameEditText.getText().toString();

        groupNameEditText.setText("");
    }*/

    private void btnCreateGroup () {
        btnCreateGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupName = groupNameEditText.getText().toString();

                mFirebaseDatabase = FirebaseDatabase.getInstance();
                databaseGroups = mFirebaseDatabase.getReference("Discussion Group").child(groupName);

                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                groupID = databaseGroups.push().getKey();
                userID = user.getUid();


                groupIDRef = databaseGroups.child("Group ID");
                creatorNameRef = databaseGroups.child("Group Creator");
                memberRef = databaseGroups.child("Members").child("Member Name");

                groupIDRef.setValue(groupID);
                creatorNameRef.setValue(userID);
                memberRef.setValue("LOLOL");


            }
        });
    }



    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.getValue(String.class) != null) {
            String key = dataSnapshot.getKey();

            if (key.equals("Group Name")) {
                String groupNameX = dataSnapshot.getValue(String.class);
                showGroupName.setText(groupNameX);
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }


}
