package com.example.veriekme.spor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class spor extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.sporTabloyut);
        viewPager = (ViewPager) findViewById(R.id.sporView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new AntrenmanMalzemesi(),"Antrenman Malzemesi");
        adepter.AddFragment(new BireyselSporlarFragment(),"Bireysel Sporlar");
        adepter.AddFragment(new BisikletlerAksesuarlarıFragment(),"Bisikletler, Aksesuarları");
        adepter.AddFragment(new DenizveHavuzÜrünleriFragment(),"Deniz ve Havuz Ürünleri");
        adepter.AddFragment(new FitnessKardiyoFragment(),"Fitness, Kardiyo");
        adepter.AddFragment(new OutdoorFragment(),"Outdoor");
        adepter.AddFragment(new OutdoorGiyimFragment(),"Outdoor Giyim");
        adepter.AddFragment(new SporGiyimFragment(),"Spor Giyim");
        adepter.AddFragment(new SporcuBesinleriFragment(),"Sporcu Besinleri");
        adepter.AddFragment(new KampMalzemeleriFragment(),"Takım Sporları");
        adepter.AddFragment(new TaraftarÜrünleriFragment(),"Taraftar Ürünleri");
        adepter.AddFragment(new ZayiflamaUrunuFragment(),"Zayıflama Ürünü");

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