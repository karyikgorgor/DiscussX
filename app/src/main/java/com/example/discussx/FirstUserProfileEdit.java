package com.example.discussx;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstUserProfileEdit extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText fullName;
    private Spinner campus;
    private Spinner academicLevel;
    private Spinner academicSchool;
    private Spinner courses;
    private Spinner intakeMonth;
    private Spinner intakeYear;
    private Button addMoreCourses, nextPage;
    private Button signOut;
    private CheckBox checkBox;
    private ProgressBar progressBar;
    private int coursesCount;
    private DatabaseReference databaseProfile;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_user_profile_edit);

        auth = FirebaseAuth.getInstance();

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(FirstUserProfileEdit.this, LoginActivity.class));
                    finish();
                }
            }
        };

        databaseProfile = FirebaseDatabase.getInstance().getReference("University Profile");

        fullName = (EditText) findViewById(R.id.first_user_profile_full_name);
        signOut = (Button) findViewById(R.id.tempsignout);
        academicLevel = (Spinner) findViewById(R.id.academic_level);
        academicSchool = (Spinner) findViewById(R.id.academic_school);
        courses = (Spinner) findViewById(R.id.uni_courses);
        intakeMonth = (Spinner) findViewById(R.id.intake_month);
        intakeYear = (Spinner) findViewById(R.id.intake_year);
        nextPage = (Button) findViewById(R.id.next_page1);
        checkBox = (CheckBox) findViewById(R.id.checkBoxCurrentCourse);
        campus = (Spinner) findViewById(R.id.university_name);

        spinnerTitle();

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileSetting();
            }
        });
    }


    private void spinnerTitle () {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);
                if (position == getCount()) {
                    ((TextView) v.findViewById(android.R.id.text1)).setText("");
                    ((TextView) v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }

                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() - 1; // you dont display last item. It is used as hint.
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Sunway College");
        adapter.add("Sunway University");
        adapter.add("Campus"); //This is the text that will be displayed as hint.
        campus.setAdapter(adapter);
        campus.setSelection(adapter.getCount()); //set the hint the default selection so it appears on launch.
        campus.setOnItemSelectedListener(this);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.add("Pre-U");
        adapter2.add("Diploma");
        adapter2.add("Bachelor Degree");
        adapter2.add("Masters");
        adapter2.add("Phd");
        adapter2.add("Academic Level");
        academicLevel.setAdapter(adapter2);
        academicLevel.setSelection(adapter2.getCount());
        academicLevel.setOnItemSelectedListener(this);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.add("American Degree Transfer Program");
        adapter3.add("Arts");
        adapter3.add("Business School");
        adapter3.add("Centre for English Language Studies");
        adapter3.add("Hospitality");
        adapter3.add("Science And Technology");
        adapter3.add("Academic School");
        academicSchool.setAdapter(adapter3);
        academicSchool.setSelection(adapter3.getCount());
        academicSchool.setOnItemSelectedListener(this);

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.add("Computer Science");
        adapter4.add("Information Systems");
        adapter4.add("Information Systems (Business Analytics)");
        adapter4.add("Information Technology");
        adapter4.add("Information Technology (Computer Network And Security)");
        adapter4.add("Software Engineering");
        adapter4.add("Mobile Computing With Entrepreneurship");
        adapter4.add("Biology with Psychology");
        adapter4.add("Medical Biotechnology");
        adapter4.add("Psychology");
        adapter4.add("Course");
        courses.setAdapter(adapter4);
        courses.setSelection(adapter4.getCount());
        courses.setOnItemSelectedListener(this);

        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter5.add("January");
        adapter5.add("February");
        adapter5.add("March");
        adapter5.add("April");
        adapter5.add("May");
        adapter5.add("June");
        adapter5.add("July");
        adapter5.add("August");
        adapter5.add("September");
        adapter5.add("October");
        adapter5.add("November");
        adapter5.add("December");
        adapter5.add("Intake Month");
        intakeMonth.setAdapter(adapter5);
        intakeMonth.setSelection(adapter5.getCount());
        intakeMonth.setOnItemSelectedListener(this);

        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter6.add("2009");
        adapter6.add("2010");
        adapter6.add("2011");
        adapter6.add("2012");
        adapter6.add("2013");
        adapter6.add("2014");
        adapter6.add("2015");
        adapter6.add("2016");
        adapter6.add("2017");
        adapter6.add("Intake Year");
        intakeYear.setAdapter(adapter6);
        intakeYear.setSelection(adapter6.getCount());
        intakeYear.setOnItemSelectedListener(this);
    }


        /*addMoreCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {

            }
        }); */



    private void profileSetting() {
        String fullName = this.fullName.getText().toString().trim();
        String campus = this.campus.getSelectedItem().toString();
        String academicLevel = this.academicLevel.getSelectedItem().toString();
        String academicSchool = this.academicSchool.getSelectedItem().toString();
        String courses = this.courses.getSelectedItem().toString();
        String intakeMonth = this.intakeMonth.getSelectedItem().toString();
        String intakeYear = this.intakeYear.getSelectedItem().toString();

        if (!TextUtils.isEmpty(fullName)) {
            String id = databaseProfile.push().getKey();
            UserProfileEdit userProfileEdit = new UserProfileEdit(id, fullName, campus, academicLevel, academicSchool, courses, intakeMonth, intakeYear);
            databaseProfile.child(id).setValue(userProfileEdit);
            Toast.makeText(this, "Profile added!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please do not leave anything blank!", Toast.LENGTH_SHORT).show();
        }

    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(FirstUserProfileEdit.this, LoginActivity.class));
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(FirstUserProfileEdit.this, "Please do not leave anything blank fucker!", Toast.LENGTH_SHORT).show();
    }


}