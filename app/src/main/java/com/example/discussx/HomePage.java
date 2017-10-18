package com.example.discussx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {
       private Button btnLogOut;
       private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnLogOut = (Button) findViewById(R.id.logout);
        auth = FirebaseAuth.getInstance();
        //get current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
                Intent intent = new Intent(HomePage.this, OpenAppPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
    public void signOut() {
        auth.signOut();
    }
}
