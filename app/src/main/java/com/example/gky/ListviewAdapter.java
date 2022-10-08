package com.example.gky;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListviewAdapter extends BaseAdapter {
    private Activity activity;
    private List<listview> x;


    public ListviewAdapter(Activity activity, List<listview> x){
        this.activity = activity;
        this.x = x;
    }
    @Override
    public int getCount() {
        return x.size();
    }

    @Override
    public Object getItem(int i) {
        return x.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.listview, null);
        TextView ten = (TextView) view.findViewById(R.id.tv_name);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        ten.setText(x.get(i).getName());
        img.setImageResource(x.get(i).getImg());
        return view;
    }
}
