package com.example.veriekme.giyim;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.veriekme.ItemAdapter;
import com.example.veriekme.ItemClass;
import com.example.veriekme.R;
import com.example.veriekme.gida.BebekBeziFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ayakkabiFragment extends Fragment {

    private ArrayList<ItemClass> itemClassArrayList = new ArrayList<>();
    private ListView listView;
    private ItemAdapter itemAdapter;
    private static String URL="https://www.cimri.com/ayakkabilar-ve-cantalar";
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.giyim_ayakkabi, container, false);
        listView = (ListView)view.findViewById(R.id.listview_news);
        new VeriGetir().execute();

        return view;
    }
    private class VeriGetir extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Giyim Kategorisi");
            progressDialog.setMessage("Ürünler Yükleniyor...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter((ListAdapter) itemAdapter);
            progressDialog.dismiss();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(URL).timeout(30*1000).get();
                Elements oyunadi = doc.select("h3[title]");
                Elements fiyatlar = doc.select("div.top-offers");
                Elements gorseller = doc.select("img.s51lp5-0");
                for (int i=0; i<oyunadi.size(); i++){
                    //liste.add(oyunadi.get(i).text());
                    //liste.add(fiyatlar.get(i).text());

                    String title = oyunadi.get(i).text();
                    String feyatlar = fiyatlar.get(i).text();

                    String gorseldeneme = gorseller.select("img.s51lp5-0")
                            .select("img")
                            .eq(i)
                            .attr("src");

                    //String gorsellerr = gorseller.get(i).text();
                    //Document doc2 = Jsoup.parse(gorseldeneme);
                    //String imageLink = doc2.getElementsByTag("img").first().attr("src");
                    //String txt = doc2.getElementsByTag("p").text();

                    ItemClass news = new ItemClass();
                    news.UrunBaslik = title;
                    news.fiyatlar = feyatlar;
                    news.goruntu = gorseldeneme;
                    news.imagePath = gorseldeneme;
                    itemClassArrayList.add(news);

                    Log.i("mytag", "title: " + title);
                    //Log.i("mytag", "image:  " + imageLink);
                    Log.i("mytag", "text:  " + feyatlar);
                    Log.i("mytag", "text:  " + gorseldeneme);

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