package com.example.baitaptest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListUserApdapter extends BaseAdapter {

    private Context context;
    private List<com.example.baitaptest.User> list;
    private int layout;

    public ListUserApdapter(Context context, List<com.example.baitaptest.User> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView ten = convertView.findViewById(R.id.ten);
        TextView email = convertView.findViewById(R.id.email2);
        TextView mk = convertView.findViewById(R.id.mk);
        TextView tuoi = convertView.findViewById(R.id.tuoi);



        ten.setText(list.get(position).getName());
        email.setText(list.get(position).getName());
        mk.setText(list.get(position).getName());
        tuoi.setText(list.get(position).getName());





        return convertView;
    }
}
