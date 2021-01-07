package com.example.veriekme;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class detail extends AppCompatActivity {

    ImageView iv1;
    TextView tvTitle;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iv1 = (ImageView) findViewById(R.id.imageview_1);
        tvTitle = (TextView) findViewById(R.id.textview_1);
        tvDescription = (TextView) findViewById(R.id.textview_2);

        ItemClass newsItem = (ItemClass) getIntent().getSerializableExtra("news_item");
        Picasso.get().load(newsItem.imagePath).placeholder(R.drawable.placeholder).into(iv1);
        tvTitle.setText(newsItem.UrunBaslik);
    }
}