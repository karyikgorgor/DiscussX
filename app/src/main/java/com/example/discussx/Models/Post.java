package com.example.discussx.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class Post {

    private String title, desc, postID, comment;

    public Post() {
    }

    public Post(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    public Post(String title, String desc, String postID, String comment) {
        this.title = title;
        this.desc = desc;
        this.postID = postID;
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
