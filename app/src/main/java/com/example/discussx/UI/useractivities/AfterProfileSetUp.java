package com.example.discussx.UI.useractivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.discussx.UI.groupactivity.CreateGroupActivity;
import com.example.discussx.UI.groupactivity.JoinGroupActivity;
import com.example.discussx.R;
import com.example.discussx.UI.groupactivity.MainJoinGroupActivity;

public class AfterProfileSetUp extends AppCompatActivity {
    private Button joinGroupLink, createGroupLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_profile_set_up);

        joinGroupLink = (Button) findViewById(R.id.join_group);
        createGroupLink = (Button) findViewById(R.id.create_group);


        joinGroupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AfterProfileSetUp.this, MainJoinGroupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        createGroupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AfterProfileSetUp.this, CreateGroupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }



}

