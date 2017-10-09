package com.example.discussx;

/**
 * Created by IMCKY on 28-Sep-17.
 */

public class UserProfileEdit {
    private String userID;
    private String fullName;
    private String university;
    private String academicLevel;
    private String academicSchool;
    private String courses;
    private String intakeMonth;
    private String intakeYear;

    public UserProfileEdit () {

    }

    public UserProfileEdit(String userID, String fullName, String university, String academicLevel, String academicSchool, String courses, String intakeMonth, String intakeYear) {
        this.userID = userID;
        this.fullName = fullName;
        this.university = university;
        this.academicLevel = academicLevel;
        this.academicSchool = academicSchool;
        this.courses = courses;
        this.intakeMonth = intakeMonth;
        this.intakeYear = intakeYear;
    }

    public String getUserID () {
        return userID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversity() {
        return university;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public String getAcademicSchool() {
        return academicSchool;
    }

    public String getCourses() {
        return courses;
    }

    public String getIntakeMonth() {
        return intakeMonth;
    }

    public String getIntakeYear() {
        return intakeYear;
    }
}
