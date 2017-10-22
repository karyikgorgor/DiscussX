package com.example.discussx.UI.groupactivity;

import android.media.projection.MediaProjection;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.discussx.Models.CreateGroup;
import com.example.discussx.R;
import com.example.discussx.UI.adapter.GroupAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainJoinGroupActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<CreateGroup>result;
    private GroupAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private TextView emptyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_join_group);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Discussion Groups");

        emptyText = findViewById(R.id.text_no_data);

        result = new ArrayList<>();
        recyclerView = findViewById(R.id.group_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        adapter = new GroupAdapter(result);
        recyclerView.setAdapter(adapter);

        updateList();
        checkIfEmpty();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 0:
                removeGroup(item.getGroupId());
                break;
            case 1:
                changeGroup(item.getGroupId());
                break;
        }


        return super.onContextItemSelected(item);
    }


    private void updateList() {
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                result.add(dataSnapshot.getValue(CreateGroup.class));
                adapter.notifyDataSetChanged();
                checkIfEmpty();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                CreateGroup createGroup = dataSnapshot.getValue(CreateGroup.class);
                int index = getItemIndex(createGroup);
                result.set(index, createGroup);
                adapter.notifyItemChanged(index);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                CreateGroup createGroup = dataSnapshot.getValue(CreateGroup.class);
                int index = getItemIndex(createGroup);
                result.remove(index);
                adapter.notifyItemRemoved(index);
                checkIfEmpty();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private int getItemIndex (CreateGroup createGroup) {
        int index = -1;

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getGroupName().equals(createGroup.getGroupName())){
                index = i;
                break;
            }
        }
        return index;
    }

    private void removeGroup (int position) {
        reference.child(result.get(position).getGroupID()).removeValue();
    }

    private void changeGroup (int position) {
        CreateGroup createGroup = result.get(position);

        Map<String, Object> groupValues = createGroup.toMap();
        Map<String, Object> newGroup = new HashMap<>();

        newGroup.put(createGroup.getGroupID(), groupValues);
        reference.updateChildren(newGroup);

    }

    private void checkIfEmpty () {
        if (result.size() == 0) {
            recyclerView.setVisibility(View.INVISIBLE);
            emptyText.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyText.setVisibility(View.INVISIBLE);
        }
    }

}
