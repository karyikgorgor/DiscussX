package com.example.discussx.UI.database;

import com.example.discussx.UI.common.BaseCachingSnapshotParser;
import com.example.discussx.UI.common.BaseSnapshotParser;
import com.google.firebase.database.DataSnapshot;

/**
 * Implementation of {@link BaseCachingSnapshotParser} for {@link DataSnapshot}.
 */
public class CachingSnapshotParser<T> extends BaseCachingSnapshotParser<DataSnapshot, T> {

    public CachingSnapshotParser(BaseSnapshotParser<DataSnapshot, T> parser) {
        super(parser);
    }

    @Override
    public String getId(DataSnapshot snapshot) {
        return snapshot.getKey();
    }
}
