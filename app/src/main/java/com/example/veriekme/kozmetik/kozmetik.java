package com.example.veriekme.kozmetik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class kozmetik extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saglik);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.sagliktablayout);
        viewPager = (ViewPager) findViewById(R.id.kozmetikView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new KisiselBakimFragment(),"Kişisel Bakım");
        adepter.AddFragment(new ParfumKozmetikFragment(),"Parfüm, Kozmetik");
        adepter.AddFragment(new SaglikUrunleriFragment(),"Sağlık Ürünleri");

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