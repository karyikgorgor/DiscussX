package com.example.discussx;


public class CreateGroup {
    private String creator;
    private String groupID;
    private String groupName;
    private String members;
    private String posts;
    private String comments;
    private String x;

    public CreateGroup () {

    }

    public CreateGroup(String creator, String groupID, String groupName, String members, String posts, String comments) {
        this.creator = creator;
        this.groupID = groupID;
        this.groupName = groupName;
        this.members = members;
        this.posts = posts;
        this.comments = comments;
    }

    public CreateGroup (String x) {
        this.x = x;
    }

    public CreateGroup (String groupID, String creator) {
        this.groupID = groupID;
        this.creator = creator;
    }

    public void setCreateGroup (String x ) {
        this.x = x;
    }

    public String getCreateGroup () {
        return x;
    }
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

