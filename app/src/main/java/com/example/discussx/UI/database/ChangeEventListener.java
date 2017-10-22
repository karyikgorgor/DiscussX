package com.example.discussx.UI.database;

import com.example.discussx.UI.common.BaseChangeEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

/**
 * Listener for changes to {@link FirebaseArray}.
 */
public interface ChangeEventListener extends BaseChangeEventListener<DataSnapshot, DatabaseError> {}
