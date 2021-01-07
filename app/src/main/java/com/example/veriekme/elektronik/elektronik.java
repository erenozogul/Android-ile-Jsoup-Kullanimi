package com.example.veriekme.elektronik;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.veriekme.R;
import com.example.veriekme.ViewPagerAdepter;
import com.google.android.material.tabs.TabLayout;

public class elektronik extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdepter adepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eletronik);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.ElektronikTabloyut);
        viewPager = (ViewPager) findViewById(R.id.elektronikView);
        adepter = new ViewPagerAdepter(getSupportFragmentManager());

        adepter.AddFragment(new BeyazEsyaFragment(),"Beyaz Eşya");
        adepter.AddFragment(new BilgisayarDonanimFragment(),"Bilgisayar, Donanım");
        adepter.AddFragment(new FotografKameraFragment(),"Fotoğraf, Kamera");
        adepter.AddFragment(new KlimaIsiticiSogutucuFragment(),"Klima, Isıtıcı Soğutucu");
        adepter.AddFragment(new KucukEvAletleriFragmentFragment(),"Küçük Ev Aletleri");
        adepter.AddFragment(new OyunKonsoluFragment(),"Oyun Konsolu");
        adepter.AddFragment(new TVSesGoruntuSistemleriFragment(),"TV, Ses, Görüntü Sistemleri");
        adepter.AddFragment(new TelefonFragment(),"Telefon");

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
