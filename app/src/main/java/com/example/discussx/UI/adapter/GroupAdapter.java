package com.example.discussx.UI.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.discussx.Models.CreateGroup;
import com.example.discussx.R;

import java.util.List;

/**
 * Created by IMCKY on 22-Oct-17.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.UserViewHolder>{

    private List<CreateGroup> groupList;

    public GroupAdapter (List<CreateGroup> groupList) {
        this.groupList = groupList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_join_group,parent,false));
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
        CreateGroup createGroup = groupList.get(position);
        holder.groupName.setText(createGroup.getGroupName());

        holder.itemView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(holder.getAdapterPosition(),0,0,"test");
            }
        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView groupName;

        public UserViewHolder (View itemView) {
            super(itemView);

            groupName =  itemView.findViewById(R.id.groupNames);
        }
    }
}
