package com.example.discussx;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

/**
 * Created by IMCKY on 28-Sep-17.
 */

public class UserProfileEdit {
    private String userID;
    private String email;
    private String fullName;
    private String gender;
    private String dob;
    private String university;
    private String academicSchool;
    private String courses;


    public UserProfileEdit () {
        
    }

    public UserProfileEdit(String userID, String email, String fullName, String gender, String dob, String university, String academicSchool, String courses) {
        this.userID = userID;
        this.email = email;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.university = university;
        this.academicSchool = academicSchool;
        this.courses = courses;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }


}
