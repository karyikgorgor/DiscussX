package com.example.discussx.Models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.discussx.R;

import org.w3c.dom.Text;

/**
 * Created by IMCKY on 24-Oct-17.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public PostViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });
        mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

    }

    public void setTitle (String title) {
        TextView post_title = mView.findViewById(R.id.row_title);
        post_title.setText(title);
    }

    public void setDesc (String desc) {
        TextView post_desc = mView.findViewById(R.id.row_desc);
        post_desc.setText(desc);
    }

    public void setPostID (String postID) {
        TextView post_ID = mView.findViewById(R.id.row_post_id);
        post_ID.setText(postID);
    }


    private PostViewHolder.ClickListener mClickListener;

    public interface ClickListener {
    public void onItemClick (View view, int position);
    public void onItemLongClick (View view, int position);
}

    public void setOnClickListener (PostViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }



}