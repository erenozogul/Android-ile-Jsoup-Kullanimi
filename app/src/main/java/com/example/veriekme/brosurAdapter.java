package com.example.veriekme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class brosurAdapter extends BaseAdapter {

    Context context;
    ArrayList<brosurClass> newsList2;

    public brosurAdapter(Context context, ArrayList<brosurClass> newsList2) {
        this.context = context;
        this.newsList2 = newsList2;
    }

    @Override
    public int getCount() {
        return newsList2.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList2.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = View.inflate(context, R.layout.brosur_gorunum, null);
        }
        brosurClass currentNews = newsList2.get(i);
        ImageView iv1 = (ImageView) view.findViewById(R.id.imageview_1);
        Picasso.get().load(currentNews.imagePath2).placeholder(R.drawable.placeholder).into(iv1);

        return view;
    }
}
