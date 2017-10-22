package com.example.discussx.Models;

import android.provider.ContactsContract;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class FirebaseHelper {
    private DatabaseReference db;
    private boolean saved;
    private ArrayList<CreateGroup> createGroupArrayList = new ArrayList<>();

    public FirebaseHelper (DatabaseReference db) {
        this.db = db;
    }

    public Boolean save (CreateGroup createGroup) {
        if (createGroup == null) {
            saved = false;
        } else {
            try {
                db.child("dit").push().setValue(createGroup);
            } catch (Exception e) {
                e.printStackTrace();
                saved = false;
            }
        }
        return saved;
    }

    private void fetchData(DataSnapshot dataSnapshot) {
        createGroupArrayList.clear();

        for (DataSnapshot ds: dataSnapshot.getChildren()) {
            CreateGroup createGroup = ds.getValue(CreateGroup.class);
            createGroupArrayList.add(createGroup);
        }
    }

    public ArrayList <CreateGroup> retrieve () {
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
