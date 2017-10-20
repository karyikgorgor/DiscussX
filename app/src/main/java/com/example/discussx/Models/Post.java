package com.example.discussx.Models;

import java.io.Serializable;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class Post implements Serializable {
    private User user;
    private String postText;
    private String postIamgeUrl;
    private String postId;
    private long numUpvotes;
    private long numDownvotes;
    private long numComments;
    private long timeCreated;

    public Post() {
    }

    public Post(User user, String postText, String postIamgeUrl, String postId, long numUpvotes, long numDownvotes, long numComments, long timeCreated) {
        this.user = user;
        this.postText = postText;
        this.postIamgeUrl = postIamgeUrl;
        this.postId = postId;
        this.numUpvotes = numUpvotes;
        this.numDownvotes = numDownvotes;
        this.numComments = numComments;
        this.timeCreated = timeCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostIamgeUrl() {
        return postIamgeUrl;
    }

    public void setPostIamgeUrl(String postIamgeUrl) {
        this.postIamgeUrl = postIamgeUrl;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public long getNumUpvotes() {
        return numUpvotes;
    }

    public void setNumUpvotes(long numUpvotes) {
        this.numUpvotes = numUpvotes;
    }

    public long getNumDownvotes() {
        return numDownvotes;
    }

    public void setNumDownvotes(long numDownvotes) {
        this.numDownvotes = numDownvotes;
    }

    public long getNumComments() {
        return numComments;
    }

    public void setNumComments(long numComments) {
        this.numComments = numComments;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }
}
