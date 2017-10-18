package com.example.discussx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class AfterProfileSetUp extends AppCompatActivity {
    private Button joinGroupLink, createGroupLink;
    private TextView displayUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_profile_set_up);

        joinGroupLink = (Button) findViewById(R.id.join_group);
        createGroupLink = (Button) findViewById(R.id.create_group);
        displayUserName = (TextView) findViewById(R.id.welcome_name);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user!= null) {
            String name = user.getDisplayName();
        }
    }
}
