package com.example.discussx.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public int upvoteCount = 0;
    public int downvoteCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("upvoteCount", upvoteCount);
        result.put("downvoteCount", downvoteCount);
        result.put("stars", stars);

        return result;
    }

}
