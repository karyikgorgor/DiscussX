package com.example.discussx.Models;

/**
 * Created by IMCKY on 23-Oct-17.
 */

public class User {

    public String userID;
    public String email;
    public String fullName;
    public String gender;
    public String dob;
    public String university;
    public String academicSchool;
    public String course;

    public User() {
    }

    public User(String userID, String email, String fullName, String gender, String dob, String university, String academicSchool, String course) {
        this.userID = userID;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.university = university;
        this.academicSchool = academicSchool;
        this.course = course;
    }

    public User(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAcademicSchool() {
        return academicSchool;
    }

    public void setAcademicSchool(String academicSchool) {
        this.academicSchool = academicSchool;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
