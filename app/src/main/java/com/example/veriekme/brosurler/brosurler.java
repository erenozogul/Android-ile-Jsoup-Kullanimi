package com.example.veriekme.brosurler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class brosurler extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brosurler);

        tabLayout = (TabLayout) findViewById(R.id.brosurTablayout);
        viewPager = (ViewPager) findViewById(R.id.brosurView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new BimFragment(),"Bim");
        adepter.AddFragment(new A101Fragment(),"A101");
        adepter.AddFragment(new SokFragment(),"Şok");
        adepter.AddFragment(new HakmarFragment(),"Hakmar");
        adepter.AddFragment(new MigrosFragment(),"Migros");
        adepter.AddFragment(new CarrefourSaFragment(),"CarrefourSa");
        adepter.AddFragment(new BizimFragment(),"Bizim");

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