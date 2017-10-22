package com.example.discussx.UI.groupactivity;

import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.discussx.Models.CreateGroup;
import com.example.discussx.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class JoinGroupActivity extends AppCompatActivity {
    private TextView groupNameTextView;
    private Button btnJoinGroup;
    private ListView groupNameListView;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseGroups;
    private String userID;
    private ArrayList<String> groupName = new ArrayList<>();
    ArrayAdapter<String> groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        getSupportActionBar().setTitle("Join Discussion Group");

        mAuth = FirebaseAuth.getInstance();

        databaseGroups = FirebaseDatabase.getInstance().getReference("Discussion Groups");
        FirebaseUser user = mAuth.getCurrentUser();

      /*  groupNameListView = findViewById(R.id.group_listview);
        groupNameTextView = findViewById(R.id.group_name);
        btnJoinGroup = findViewById(R.id.btn_join_group);
        groupAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,groupName);
        groupNameListView.setAdapter(groupAdapter);

        databaseGroups.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                groupName.add(dataSnapshot.getValue(String.class));
                groupAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }

}
