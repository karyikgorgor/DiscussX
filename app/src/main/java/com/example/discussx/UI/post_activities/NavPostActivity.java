package com.example.discussx.UI.post_activities;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.discussx.Models.Comment;
import com.example.discussx.Models.CommentViewHolder;
import com.example.discussx.Models.Post;
import com.example.discussx.Models.PostViewHolder;
import com.example.discussx.Models.comment_activities.CommentActivity;
import com.example.discussx.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class NavPostActivity extends AppCompatActivity {
    private TextView mPostTitle;
    private TextView mPostDesc;
    private RecyclerView mCommentList;
    private DatabaseReference databasePost;
    private Intent intent;
    private static final String TAG = "NavPostActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_post);

        mPostTitle = findViewById(R.id.row_title_show);
        mPostDesc = findViewById(R.id.row_desc_show);



        retrievePostData();

    }



    private void retrievePostData () {
        final String postID = getIntent().getExtras().getString("postID");
        final String postTitle = getIntent().getExtras().getString("postTitle");
        final String postDesc = getIntent().getExtras().getString("postDesc");
      databasePost = FirebaseDatabase.getInstance().getReference("Post").child(postID);
        databasePost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.w(TAG, "" + dataSnapshot);
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Log.w(TAG, "Fuck " + dataSnapshot);
                    Post post = ds.getValue(Post.class);
                    if (postID.equals(post.getPostID()) && postTitle.equals(post.getTitle()) && postDesc.equals(post.getDesc())) {
                        mPostTitle.setText(post.getTitle());
                        mPostDesc.setText(post.getDesc());

                        intent = new Intent(NavPostActivity.this, CommentActivity.class);
                        intent.putExtra("postIDForComment", postID);
                        intent.putExtra("postTitleForComment", postTitle);
                        intent.putExtra("postDescForComment", postDesc);
                    }
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_post) {
            Intent intent = new Intent (NavPostActivity.this, PostActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
