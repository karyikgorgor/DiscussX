package com.example.discussx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SetUpPersonalProfile3 extends AppCompatActivity {
    private Button btnNext;
    private Spinner spinnerCourse;
    private Spinner spinnerAcademicSchool;
    private final List<String> academicSchoolList = new ArrayList<String>();

    private final List<String> adtpList = new ArrayList<String>();
    private final List<String> celsList = new ArrayList<String>();
    private final List<String> soaList = new ArrayList<String>();
    private final List<String> sohList = new ArrayList<String>();
    private final List<String> somsList = new ArrayList<String>();
    private final List<String> sstList = new ArrayList<String>();
    private final List<String> sihdList = new ArrayList<String>();
    private final List<String> subsList = new ArrayList<String>();

    private static final String TAG = "SetUpPersonalProfile3";
    private DatabaseReference databaseProfile;
    private String userID;
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_personal_profile3);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        databaseProfile = FirebaseDatabase.getInstance().getReference("User Profile");
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();


        btnNext = (Button) findViewById(R.id.next1);
        spinnerCourse = (Spinner) findViewById(R.id.spinner_course);
        spinnerAcademicSchool = (Spinner) findViewById(R.id.spinner_academic_school);

        academicSchoolList.add("American Degree Transfer Program"); //0
        academicSchoolList.add("Centre for English Language Studies"); //1
        academicSchoolList.add("School of Arts"); //2
        academicSchoolList.add("School of Hospitality"); //3
        academicSchoolList.add("School of Mathematical Sciences"); //4
        academicSchoolList.add("School of Science and Technology"); //5
        academicSchoolList.add("Sunway Institute for Healthcare Development"); //6
        academicSchoolList.add("Sunway University Business School"); //7

        sstList.add("Diploma in Information Technology"); //0
        sstList.add("BSc(Hons) Biology with Psychology"); //1
        sstList.add("BSc(Hons) Medical Biotechnology");
        sstList.add("BSc(Hons) in Psychology");
        sstList.add("BSc(Hons) in Computer Science");
        sstList.add("BSc(Hons) Information Systems");
        sstList.add("BSc(Hons) Information Systems (Business Analytics)");
        sstList.add("BSc(Hons) in Information Technology");
        sstList.add("BSc(Hons) in Information Technology (Computer Networking and Security)");
        sstList.add("BSc(Hons) in Mobile Computing with Entrepreneurship");
        sstList.add("Bachelor of Software Engineering (Hons)");
        sstList.add("MSc in Life Sciences");
        sstList.add("MSc in Psychology");
        sstList.add("MSc in Computer Science (By Research)");
        sstList.add("MSc in Information Systems");
        sstList.add("Doctor of Philosophy in Biology");
        sstList.add("Doctor of Philosophy (Computing)");

        sihdList.add("Diploma in Nursing"); //0

        ArrayAdapter<String> academicSchoolAdapter = new ArrayAdapter<String>(SetUpPersonalProfile3.this, R.layout.support_simple_spinner_dropdown_item, academicSchoolList);
        final ArrayAdapter<String> sstAdapter = new ArrayAdapter<String>(SetUpPersonalProfile3.this, R.layout.support_simple_spinner_dropdown_item, sstList);
        final ArrayAdapter<String> sihdAdapter = new ArrayAdapter<String>(SetUpPersonalProfile3.this, R.layout.support_simple_spinner_dropdown_item, sihdList);

        spinnerAcademicSchool.setAdapter(academicSchoolAdapter);

        spinnerAcademicSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 5) {
                    spinnerCourse.setAdapter(sstAdapter);
                } else if (i == 6) {
                    spinnerCourse.setAdapter(sihdAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                
            }
        });

        databaseProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d(TAG, "onDataChange: Added profile to database: \n" + dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to red value.", databaseError.toException());
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerProfile();
                Intent intent = new Intent (SetUpPersonalProfile3.this, AfterProfileSetUp.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

    private void registerProfile () {
        String email = getIntent().getExtras().getString("email3");
        String fullName = getIntent().getExtras().getString("fullName2");
        String gender = getIntent().getExtras().getString("gender2");
        String dob = getIntent().getExtras().getString("dob");
        String uni = getIntent().getExtras().getString("university");
        String academicSchool = spinnerAcademicSchool.getSelectedItem().toString();
        String course = spinnerCourse.getSelectedItem().toString();
        UserProfileEdit userProfileEdit = new UserProfileEdit(userID, email, fullName, gender,dob,uni,academicSchool, course);

        databaseProfile.child(userID).setValue(userProfileEdit);
    }
}
