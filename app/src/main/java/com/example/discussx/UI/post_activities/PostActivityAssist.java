package com.example.discussx.UI.post_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.discussx.Models.Post;
import com.example.discussx.Models.PostViewHolder;
import com.example.discussx.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class PostActivityAssist extends AppCompatActivity {

    private RecyclerView mPostList;
    private DatabaseReference databasePost;
    private TextView postTitleTextView, postDescTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist_post);



        databasePost = FirebaseDatabase.getInstance().getReference().child("Post");

        mPostList = findViewById(R.id.post_list);
        mPostList.setHasFixedSize(true);
        mPostList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart () {
        super.onStart();

        final FirebaseRecyclerAdapter<Post, PostViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post, PostViewHolder> (
                Post.class,
                R.layout.post_row,
                PostViewHolder.class,
                databasePost
        ) {

            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());

            }
            @Override
            public PostViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
                final PostViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                viewHolder.setOnClickListener(new PostViewHolder.ClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        postTitleTextView = view.findViewById(R.id.row_title);
                        postDescTextView = view.findViewById(R.id.row_desc);

                        String postTitle = postTitleTextView.getText().toString();
                        String postDesc = postDescTextView.getText().toString();

                        Intent intent = new Intent(PostActivityAssist.this, NavPostActivity.class);
                        intent.putExtra("postTitle", postTitle);
                        intent.putExtra("postDesc", postDesc);
                        Toast.makeText(PostActivityAssist.this, "You clicked "+ position, Toast.LENGTH_SHORT).show();

                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(PostActivityAssist.this, "You clicked "+ position, Toast.LENGTH_SHORT).show();
                    }
                });
                return viewHolder;
            }
        };
        mPostList.setAdapter(firebaseRecyclerAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_post) {
            Intent intent = new Intent (PostActivityAssist.this, PostActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
