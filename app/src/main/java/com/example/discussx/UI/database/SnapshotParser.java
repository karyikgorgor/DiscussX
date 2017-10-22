package com.example.discussx.UI.database;

import com.example.discussx.UI.common.BaseSnapshotParser;
import com.google.firebase.database.DataSnapshot;

public interface SnapshotParser<T> extends BaseSnapshotParser<DataSnapshot, T> {}
