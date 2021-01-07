package com.example.veriekme.bahce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import com.example.veriekme.R;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<bahce_contack> mData;

    public RecyclerViewAdapter(Context mContext, List<bahce_contack> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        view = LayoutInflater.from(parent.getContext()/*mContext*/).inflate(R.layout.item_bahce,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //netten veri çekerken burada değişiklik oluyor


        holder.tv_fiyat1.setText(mData.get(position).getFiyat1());
        holder.tv_fiyat2.setText(mData.get(position).getFiyat2());
        holder.tv_fiyat3.setText(mData.get(position).getFiyat3());
        holder.tv_urunAdi.setText(mData.get(position).getUrunAdi());
        holder.img.setImageResource(mData.get(position).getResim());

        //Picasso.get().load(mData.getImgUrl()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_fiyat1;
        private TextView tv_fiyat2;
        private TextView tv_fiyat3;
        private TextView tv_urunAdi;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_fiyat1 =(TextView) itemView.findViewById(R.id.fiyat1);
            tv_fiyat2 =(TextView) itemView.findViewById(R.id.fiyat2);
            tv_fiyat3 =(TextView) itemView.findViewById(R.id.fiyat3);
            tv_urunAdi =(TextView) itemView.findViewById(R.id.urunAdi);
            img =(ImageView) itemView.findViewById(R.id.urunGorseli);
        }
    }
}
