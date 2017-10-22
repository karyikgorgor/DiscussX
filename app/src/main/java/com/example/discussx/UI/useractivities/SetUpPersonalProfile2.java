package com.example.discussx.UI.useractivities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.discussx.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SetUpPersonalProfile2 extends AppCompatActivity {
    private Button displayDate, btnNext;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Spinner uniSpinner;
    private String dateFormat;
    private final List<String> uniList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_personal_profile2);

        displayDate = (Button) findViewById(R.id.dob);
        btnNext = (Button) findViewById(R.id.next1);
        uniSpinner = (Spinner) findViewById(R.id.spinner_uni);

        //dob
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        SetUpPersonalProfile2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            public static final String TAG = "";

            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                displayDate.setText(date);
            }
        };

        //university
        uniList.add("Sunway College");
        uniList.add("Sunway University");

        ArrayAdapter<String> uniAdapter = new ArrayAdapter<String>(SetUpPersonalProfile2.this, R.layout.support_simple_spinner_dropdown_item, uniList);
        uniSpinner.setAdapter(uniAdapter);

        uniSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Please choose an university!", Toast.LENGTH_LONG).show();
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = getIntent().getExtras().getString("email2");
                String fullName = getIntent().getExtras().getString("fullName1");
                String gender = getIntent().getExtras().getString("gender1");
                Intent intent = new Intent(SetUpPersonalProfile2.this, SetUpPersonalProfile3.class);
                intent.putExtra("email3", email);
                intent.putExtra("fullName2", fullName);
                intent.putExtra("gender2", gender);
                intent.putExtra("dob", displayDate.getText().toString());
                intent.putExtra("university",uniSpinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }


}
