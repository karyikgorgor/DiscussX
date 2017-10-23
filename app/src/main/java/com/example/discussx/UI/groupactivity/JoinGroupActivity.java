package com.example.discussx.UI.groupactivity;


import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.discussx.Models.FirebaseHelper;
import com.example.discussx.Models.Group;
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



public class JoinGroupActivity extends AppCompatActivity {
    private TextView groupNameTextView;
    private Button btnJoinGroup;
    private ListView groupNameListView;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseGroups;
    private String userID;
    private FirebaseHelper firebaseHelper;
    ArrayList<String> groupName = new ArrayList<>();
    ArrayAdapter<String> groupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);
        getSupportActionBar().setTitle("Join Discussion Group");


        groupNameListView = findViewById(R.id.group_listview);
        btnJoinGroup = findViewById(R.id.btn_join_group);


        databaseGroups = FirebaseDatabase.getInstance().getReference("Discussion Group");


        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();


    }

    @Override
    public void onStart () {
        super.onStart();

        ValueEventListener groupListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Group group = dataSnapshot.getValue(Group.class);
                groupName.add(group.getGroupName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseGroups.addValueEventListener(groupListener);


    }

}
