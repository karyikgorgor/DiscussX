package com.example.discussx.UI.post_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.discussx.R;


public class NavPostActivity extends AppCompatActivity {
    private TextView mPostTitle;
    private TextView mPostDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_post);

        mPostTitle = findViewById(R.id.row_title_show);
        mPostDesc = findViewById(R.id.row_desc_show);

        String postTitle = getIntent().getExtras().getString("postTitle");
        String postDesc = getIntent().getExtras().getString("postDesc");

        mPostTitle.setText(postTitle);
        mPostDesc.setText(postDesc);
    }
}
