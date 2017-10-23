package com.example.discussx.Models;

/**
 * Created by IMCKY on 23-Oct-17.
 */

public class Group {

    public String groupName;
    public String groupID;
    public String creatorName;
    public String members;
    public String posts;

    public Group() {
    }

    public Group(String groupName, String groupID, String creatorName, String members, String posts) {
        this.groupName = groupName;
        this.groupID = groupID;
        this.creatorName = creatorName;
        this.members = members;
        this.posts = posts;
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }
}
