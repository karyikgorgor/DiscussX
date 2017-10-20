package com.example.discussx.Utils;

import android.provider.ContactsContract;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


/**
 * Created by IMCKY on 21-Oct-17.
 */

public class FirebaseUtils {

    public static DatabaseReference getUserRef (String email) {
        return FirebaseDatabase.getInstance()
                .getReference(Constant.USERS_KEY)
                .child(email);
    }
    public static DatabaseReference getPostRef () {
        return FirebaseDatabase.getInstance()
                .getReference(Constant.POST_KEY);

    }

    public static DatabaseReference getPostUpvotedRef () {
        return FirebaseDatabase.getInstance()
                .getReference(Constant.POST_UPVOTED_KEY);

    }

    public static DatabaseReference getPostDownvotedRef () {
        return FirebaseDatabase.getInstance()
                .getReference(Constant.POST_DOWNVOTED_KEY);

    }

    public static DatabaseReference getPostUpvotedRef (String postID) {
        return getPostRef().child(getCurrentUser().getEmail()
                .replace(".",","))
                .child(postID);

    }

    public static FirebaseUser getCurrentUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public static String getUid() {
        String path = FirebaseDatabase.getInstance().getReference().push().toString();
        return path.substring(path.lastIndexOf("/") +1);
    }

    public static StorageReference getImagesRef() {
        return FirebaseStorage.getInstance().getReference(Constant.POST_IMAGES);
    }

    public static DatabaseReference getMyPostRef() {
        return FirebaseDatabase.getInstance().getReference(Constant.MY_POSTS)
                .child(getCurrentUser().getEmail().replace(".",","));
    }

    public static DatabaseReference getCommentRef(String postID) {
        return FirebaseDatabase.getInstance().getReference(Constant.COMMENTS_KEY)
                .child(postID);
    }

    public static DatabaseReference getMyRecordRef () {
        return FirebaseDatabase.getInstance().getReference(Constant.USER_RECORD)
                .child(getCurrentUser().getEmail().replace(".",","));
    }

    public static void addToMyRecord (String node, final String id) {
        getMyRecordRef().child(node).runTransaction(new Transaction.Handler() {
            @Override
            public Transaction.Result doTransaction(MutableData mutableData) {
                ArrayList<String> myRecordCollection;
                if (mutableData.getValue() == null) {
                    myRecordCollection = new ArrayList<String>(1);
                    myRecordCollection.add(id);
                } else {
                    myRecordCollection = (ArrayList<String>)mutableData.getValue();
                    myRecordCollection.add(id);
                }
                mutableData.setValue(myRecordCollection);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(DatabaseError databaseError, boolean b, DataSnapshot dataSnapshot) {

            }
        });
    }

}