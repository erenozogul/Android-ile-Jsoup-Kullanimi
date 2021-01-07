package com.example.veriekme.gida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class gida extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gida);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.gidatabloyut);
        viewPager = (ViewPager) findViewById(R.id.gidaView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new BebekBeziFragment(),"Bebek Bezi");
        adepter.AddFragment(new BitkiselUrunlerFragment(),"Bitkisel Ürünler");
        adepter.AddFragment(new EtUrunleriFragment(),"Et, Et Ürünleri");
        adepter.AddFragment(new GidaFragment(),"Gıda");
        adepter.AddFragment(new IslakMendilFragment(),"Islak Mendil");
        adepter.AddFragment(new IcecekFragment(),"İçecek");
        adepter.AddFragment(new KagitUrunleriFragment(),"Kağıt Ürünleri");
        adepter.AddFragment(new MutfakSarfMalzemeleriFragment(),"Mutfak Sarf Malzemeleri");
        adepter.AddFragment(new PetshopFragment(),"Petshop");
        adepter.AddFragment(new PilFragment(),"Pil");
        adepter.AddFragment(new SebzeMeyveFragment(),"Sebze, Meyve");
        adepter.AddFragment(new SutKahvaltilikUrunlerFragment(),"Süt, Kahvaltılık Ürünler");
        adepter.AddFragment(new TemizlikFragment(),"Temizlik");

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