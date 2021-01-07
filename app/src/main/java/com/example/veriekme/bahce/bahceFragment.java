package com.example.veriekme.bahce;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.veriekme.R;

import java.util.ArrayList;
import java.util.List;

public class bahceFragment extends Fragment {


    View view;
    private RecyclerView recyclerView;
    private List<bahce_contack> lstContack;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //kullanıcı resimleri elle giriliyor
        //1 ürünün tüm özellikleri 1 add ile giriliyor. Her add ile 1 ürün giriliyor.

        lstContack = new ArrayList<>();
        lstContack.add(new bahce_contack("İzeltaş 6720 220 mm Bağ Makası","147,27 TL N11","152 TL İzeltaş","158 TL Yollabana", "imgUrl", R.drawable.bahcebir));
        lstContack.add(new bahce_contack("Husqvarna 61 2.9kW Benzinli Ağaç Kesme Makinesi","4.274,05 TL Trendyol","4350 TL Elmaavm","4409 TL İrhal Tarım", "imgUrl", R.drawable.bahceiki));
        lstContack.add(new bahce_contack("Kaan 260 s 7 Hp İpli Benzinli Çapa Makinesi","3.599,00 TL N11","4125 TL Hepsiburada","4599 TL Çiçeksepeti", "imgUrl", R.drawable.bahceuc));
        lstContack.add(new bahce_contack("Guruss Go&Grill Kömürlü Portatif Mangal Barbekü","599,25 TL N11 ","649 TL Koçtaş","604 TL Amazon", "imgUrl", R.drawable.bahcedort));
        lstContack.add(new bahce_contack("Zanon Falcon AL300 Teleskopik Zeytin Hasat Makinası Yeni Model","4.445,10 TL İrha Tarım","4550 TL Ptt Avm","4590 TL gittigidiyor", "imgUrl", R.drawable.bahcebes));
        lstContack.add(new bahce_contack("Max Extra MX8030 Akülü Dal Budama Makinesi","1.085,16 TL  trendyol","1128 TL Hepsiburada","1142 TL AkyolBahce", "imgUrl", R.drawable.bahcealti));
        lstContack.add(new bahce_contack("Veta PA350T 3 Benzinli Su Motoru","1.046,28 TL İrhan tarım","1122 TL ptt avm","1168 TL hepsiburada", "imgUrl", R.drawable.bahceyedi));
        lstContack.add(new bahce_contack("Pro Jcb Plus X-TORQ 8400 5.9 Hp Sjs Metal Şanzuman Yan Tipi Ot Çim Çalı Biçme Tırpanı","600 TL Hepsiburada","617 TL gittigidiyor","749 TL gittigidiyor", "imgUrl", R.drawable.bahcesekiz));
        lstContack.add(new bahce_contack("Keter Novel 340 lt Bahçe Depolama Sandığı","493 TL Trendyol","523 TL Bidesnal.com","559 TL Hebsiburada", "imgUrl", R.drawable.bahcedokuz));
        lstContack.add(new bahce_contack("Palmera ZLAG520B 20 cm Toprak Burgu Makinesi","1114 TL yapıyyo","1115 TL Hebsiburada","1148 N11", "imgUrl", R.drawable.bahceon));
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.bahce_bahce,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.bahce_alt_recycler);
        RecyclerViewAdapter recyclerViewAdapter = new  RecyclerViewAdapter(getContext(),lstContack);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
    public bahceFragment() {
    }

    private class Content extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            /*
            try {
                String url = "https://www.akakce.com/yapi-market-oto-bahce.html";
                Document doc = Jsoup.connect(url).get();

                Elements data = doc.select("li.w");

                int size = data.size();
                for (int i = 0; i<size; i++){
                    String urunGorseli = data.select("li.w")
                            .select("img")
                            .eq(i)
                            .attr("src");
                    String urunAdi = data.select("h3.pn_v8")
                            .select("")
                            .eq(i)
                            .text();

                    lstContack = new ArrayList<>();
                    lstContack.add(new bahce_contack(urunAdi, urunGorseli);
                    Log.d("items","img",+imgUrl+ ". title: " +title);
                }

            }
            catch (IOException e){
                e.printStackTrace();
            }
             */
            return null;
        }
    }
}
