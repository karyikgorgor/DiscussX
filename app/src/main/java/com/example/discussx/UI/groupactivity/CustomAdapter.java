package com.example.discussx.UI.groupactivity;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.discussx.Models.CreateGroup;
import com.example.discussx.R;

import java.util.ArrayList;

/**
 * Created by IMCKY on 21-Oct-17.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<CreateGroup> createGroup;

    public CustomAdapter(Context c, ArrayList<CreateGroup> createGroup) {
        this.c = c;
        this.createGroup = createGroup;
    }

    @Override
    public int getCount() {
        return createGroup.size();
    }

    @Override
    public Object getItem(int i) {
        return createGroup.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

        }


        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
