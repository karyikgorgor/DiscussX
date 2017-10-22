package com.example.discussx.UI.useractivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.discussx.R;


public class SetUpPersonalProfile extends AppCompatActivity {
    private Button btnNext;
    private EditText editTextFullName;
    private RadioGroup genderGroup;
    private RadioButton radioButtonGender;
    private String fullName;
    private String gender;

    /*public SetUpPersonalProfile (EditText editTextFullName, RadioButton gender) {
        this.editTextFullName = editTextFullName;
        this.gender = gender;
    }*/


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_set_up_personal_profile);

            btnNext = (Button) findViewById(R.id.next1);
            editTextFullName = (EditText) findViewById(R.id.fullname);
            genderGroup = (RadioGroup) findViewById(R.id.gender_group);

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fullName = editTextFullName.getText().toString().trim();
                    int radioID = genderGroup.getCheckedRadioButtonId();
                    radioButtonGender = (RadioButton) findViewById(radioID);
                    Toast.makeText(getBaseContext(), radioButtonGender.getText(), Toast.LENGTH_LONG).show();

                    if (TextUtils.isEmpty(fullName)) {
                        Toast.makeText(getApplicationContext(), "Enter your name!", Toast.LENGTH_LONG).show();
                    } else {
                        String email = getIntent().getExtras().getString("email");
                        Intent intent = new Intent(SetUpPersonalProfile.this, SetUpPersonalProfile2.class);
                        intent.putExtra("email2",email);
                        intent.putExtra("fullName1", editTextFullName.getText().toString().trim());
                        intent.putExtra("gender1",radioButtonGender.getText().toString());
                        startActivity(intent);
                    }

                }
            });

        }

    public void genderChoice (View v) {
        int radioID = genderGroup.getCheckedRadioButtonId();
        radioButtonGender = (RadioButton) findViewById(radioID);
        Toast.makeText(getBaseContext(), radioButtonGender.getText(), Toast.LENGTH_LONG).show();
    }



}
