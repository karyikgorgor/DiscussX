package com.example.discussx;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

/**
 * Created by IMCKY on 28-Sep-17.
 */

public class UserProfileEdit {
    private String userID;
    private String fullName;
    private String gender;
    private String dob;
    private String university;
    private String academicSchool;
    private String courses;


    public UserProfileEdit () {
        
    }

    public UserProfileEdit(String userID, String fullName, String gender, String dob, String university, String academicSchool, String courses) {
        this.userID = userID;
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.university = university;
        this.academicSchool = academicSchool;
        this.courses = courses;

    }

    public String getUserID () {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender () { return gender; }

    public String getDob () { return dob; }

    public String getUniversity() {
        return university;
    }

    public String getAcademicSchool() {
        return academicSchool;
    }

    public String getCourses() {
        return courses;
    }

}
