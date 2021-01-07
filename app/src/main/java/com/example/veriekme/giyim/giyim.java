package com.example.veriekme.giyim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class giyim extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giyim);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.giyimTabloyut);
        viewPager = (ViewPager) findViewById(R.id.giyimViewPager);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new ayakkabiFragment(),"Ayakkabı");
        adepter.AddFragment(new cocukFragment(),"Erkek Cocuk");
        adepter.AddFragment(new erkekFragment(),"Erkek");
        adepter.AddFragment(new gozlukFragment(),"Gözlük");
        adepter.AddFragment(new kadinFragment(),"Kadın");
        adepter.AddFragment(new saatFragment(),"Saat");
        adepter.AddFragment(new kızCocukFragment(),"Kız Çocuk ");
        adepter.AddFragment(new takiFragment(),"Takı");

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