package com.example.discussx.Models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.discussx.R;



public class CommentViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public CommentViewHolder(View itemView) {
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

    public void setComment (String comment) {
        TextView mComment = mView.findViewById(R.id.row_comment);
        mComment.setText(comment);
    }


    private CommentViewHolder.ClickListener mClickListener;

    public interface ClickListener {
        public void onItemClick (View view, int position);
        public void onItemLongClick (View view, int position);
    }

    public void setOnClickListener (CommentViewHolder.ClickListener clickListener) {
        mClickListener = clickListener;
    }



}