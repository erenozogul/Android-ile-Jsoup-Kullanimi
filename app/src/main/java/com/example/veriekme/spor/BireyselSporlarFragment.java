package com.example.veriekme.spor;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.veriekme.ItemAdapter;
import com.example.veriekme.ItemClass;
import com.example.veriekme.R;
import com.example.veriekme.kozmetik.ParfumKozmetikFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class BireyselSporlarFragment extends Fragment {

    private View view;
    private ArrayList<ItemClass> itemClassArrayList = new ArrayList<>();
    private ListView listView;
    private ItemAdapter itemAdapter;
    private static String URL="https://www.cimri.com/paten-kaykay-scooter";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.spor_bireysel_sporlar, container, false);
        listView = (ListView)view.findViewById(R.id.listview_news);
        new VeriGetir().execute();
        return view;
    }
    private class VeriGetir extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter((ListAdapter) itemAdapter);
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(URL).timeout(30*1000).get();
                Elements oyunadi = doc.select("h3[title]");
                Elements fiyatlar = doc.select("div.top-offers");
                Elements gorseller = doc.select("div.z7ntrt-0");
                for (int i=0; i<oyunadi.size(); i++){
                    String title = oyunadi.get(i).text();
                    String feyatlar = fiyatlar.get(i).text();
                    String imageLink = gorseller.select("div.m50b2p-0.iHtcZy").select("img").eq(i).attr("data-src");

                    ItemClass news = new ItemClass();
                    news.UrunBaslik = title;
                    news.fiyatlar = feyatlar;
                    news.imagePath = imageLink;
                    itemClassArrayList.add(news);

                    Log.i("mytag", "title: " + title);
                    Log.i("mytag", "image:  " + imageLink);
                    Log.i("mytag", "text:  " + feyatlar);

                }
                Log.i("mytag", "items found: " + oyunadi.size());
                Log.i("mytag", "items in news List: " + itemClassArrayList.size());
                itemAdapter = new ItemAdapter(getActivity(), itemClassArrayList);
/*
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                        ItemClass currentNews = itemClassArrayList.get(i);
                        Intent intent = new Intent(BebekBeziAnneFragment.this, ScrollingActivity.class);
                        intent.putExtra("news_item", (Parcelable) currentNews);
                        startActivity(intent);

                    }
                });
 */
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}