package com.example.veriekme.ev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class ev extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ev);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.evtabloyut);
        viewPager = (ViewPager) findViewById(R.id.evView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new DekorasyonFragment(),"Dekorasyon");
        adepter.AddFragment(new EvGerecleriFragment(),"Mutfak Gereçleri");
        adepter.AddFragment(new EvTeksitiliFragment(),"Ev Tekstili");
        adepter.AddFragment(new KirtasiyeFragmant(),"Kırtasiye");
        adepter.AddFragment(new KucukEvAletleriFragment(),"Küçük Ev Aletleri");
        adepter.AddFragment(new MobilyaFragment(),"Mobilya");
        adepter.AddFragment(new OfisFragment(),"Ofis");
        adepter.AddFragment(new TvSatisUrunuFragment(),"Elektrikli Mutfak Ürünleri");
        adepter.AddFragment(new ZuccaciyeFragment(),"Züccaciye");

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