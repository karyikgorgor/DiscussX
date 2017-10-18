package com.example.discussx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.Login;

public class OpenAppPage extends AppCompatActivity {

    private Button btnSignIn, btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_app_page);

        btnSignIn = (Button) findViewById(R.id.intro_signin);
        btnRegister = (Button) findViewById(R.id.intro_register);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpenAppPage.this, LoginActivity.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpenAppPage.this, SignUpActivity.class));
            }
        });
    }
}
