package com.example.discussx.Models;

import android.provider.ContactsContract;

import com.example.discussx.UI.groupactivity.CreateGroupActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved = null;
    String groupNameX;
    ArrayList<String> createGroupArrayList = new ArrayList<>();

    public FirebaseHelper (DatabaseReference db) {
        this.db = db;
    }

    public Boolean save (CreateGroup createGroup) {
        if (createGroup == null) {
            saved = false;
        } else {
            try {
                db.child("Discussion Group").push().setValue(createGroup);
            } catch (Exception e) {
                e.printStackTrace();
                saved = false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot) {
        createGroupArrayList.clear();

        if (dataSnapshot.getValue(String.class) != null) {
            String key = dataSnapshot.getKey();

            if (key.equals("Group Name")) {
                groupNameX = dataSnapshot.getValue(String.class);
                createGroupArrayList.add(groupNameX);
            }
        }
    }

    public String returnGroupName () {
        return groupNameX;
    }


    public ArrayList <String> retrieve () {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
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
        });
        return createGroupArrayList;
    }
}
