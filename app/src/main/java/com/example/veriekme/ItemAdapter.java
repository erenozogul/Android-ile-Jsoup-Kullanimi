package com.example.veriekme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter {

    Context context;
    ArrayList<ItemClass> newsList;

    public ItemAdapter(Context context, ArrayList<ItemClass> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = View.inflate(context, R.layout.listview_gorunum, null);
        }
        ItemClass currentNews = newsList.get(i);

        ImageView iv1 = (ImageView) view.findViewById(R.id.imageview_1);
        TextView tvTitle = (TextView) view.findViewById(R.id.textview_1);
        TextView tvDate = (TextView) view.findViewById(R.id.textview_2);
        TextView tvDescription = (TextView) view.findViewById(R.id.textview_3);

        Picasso.get().load("https:"+ currentNews.imagePath).placeholder(R.drawable.placeholder).into(iv1);
        tvTitle.setText(currentNews.UrunBaslik);
        tvDate.setText(currentNews.fiyatlar);

        return view;
    }
}
