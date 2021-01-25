package com.example.veriekme.brosurler;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.veriekme.ItemAdapter;
import com.example.veriekme.ItemClass;
import com.example.veriekme.R;
import com.example.veriekme.brosurAdapter;
import com.example.veriekme.brosurClass;
import com.example.veriekme.elektronik.BeyazEsyaFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class BimFragment extends Fragment {

    private  ArrayList<brosurClass> brosurClassArrayList = new ArrayList<brosurClass>();
    //private ArrayList<ItemClass> itemClassArrayList = new ArrayList<>();
    private ListView listView;
    private brosurAdapter brosurAdapter;
    private static String URL="https://www.cimri.com/brosur/bim-com-tr";
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.brosur_bim, container, false);
        //listView = (ListView)view.findViewById(R.id.listview_news);
        //new VeriGetir().execute();

        return view;
    }/*
    private class VeriGetir extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Broşür Kategorisi");
            progressDialog.setMessage("Broşürler Yükleniyor...");
            progressDialog.setIndeterminate(false);
            progressDialog.show();
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            listView.setAdapter((ListAdapter) brosurAdapter);
            progressDialog.dismiss();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(URL).timeout(30*1000).get();
                Elements gorseller = doc.select("div.s19k03z0-0");
                for (int i=0; i<gorseller.size(); i++){
                    String imageLink = gorseller.select("a.s1ra91yk-9.hTOLj").select("img").eq(i).attr("data-src");

                    brosurClass news = new brosurClass();
                    news.imagePath2 = imageLink;
                    brosurClassArrayList.add(news);

                    Log.i("mytag", "image:  " + imageLink);

                }
                Log.i("mytag", "items found: " + gorseller.size());
                Log.i("mytag", "items in news List: " + brosurClassArrayList.size());
                brosurAdapter = new brosurAdapter(getActivity(), brosurClassArrayList);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
*/
}