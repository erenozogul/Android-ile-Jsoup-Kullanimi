package com.example.veriekme.anne;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class anne extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anne);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.annekategori);
        viewPager = (ViewPager) findViewById(R.id.anneviewPager);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new BebekBeziAnneFragment(),"Bebek Bezi");
        adepter.AddFragment(new BebekBanyoUrunleriFragment(),"Bebek Banyo Ürünleri");
        adepter.AddFragment(new BebekGiyimFragment(),"Bebek Giyim");
        adepter.AddFragment(new BebekAktiviteFragment(),"Bebek Hediyeleri");
        adepter.AddFragment(new BebekOdasiFragment(),"Bebek Odası");
        adepter.AddFragment(new BeslenmeFragment(),"Beslenme");
        adepter.AddFragment(new EmzirmeFragment(),"Emzirme");
        adepter.AddFragment(new GuvenlikFragment(),"Güvenlik");
        adepter.AddFragment(new KanguruVePortbebeFragment(),"Kanguru ve Portbebe");
        adepter.AddFragment(new MamaSandalyesiFragment(),"Mama Sandalyesi");
        adepter.AddFragment(new YurutecFragment(),"Yürüteç");
        adepter.AddFragment(new AnneGiyimFragment(),"Anne Giyim");
        adepter.AddFragment(new AnaKucagiOtoKoltuguFragment(),"Ana Kucağı, Oto Koltuğu");
        adepter.AddFragment(new BebekArabasiFragment(),"Bebek Arabası");
        adepter.AddFragment(new OyuncakFragment(),"Oyuncak");
        adepter.AddFragment(new DevamSutuFragment(),"Devam Sütü");

        viewPager.setAdapter(adepter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}