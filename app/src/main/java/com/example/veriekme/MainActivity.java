package com.example.veriekme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.veriekme.anne.anne;
import com.example.veriekme.bahce.bahce;
import com.example.veriekme.brosurler.brosurler;
import com.example.veriekme.elektronik.elektronik;
import com.example.veriekme.ev.ev;
import com.example.veriekme.gida.gida;
import com.example.veriekme.giyim.giyim;
import com.example.veriekme.kozmetik.kozmetik;
import com.example.veriekme.spor.spor;

public class MainActivity extends AppCompatActivity {

    ImageButton elektronikk, gidaa, evv, annee, giyimm, sporr, kozmetikk, bahcee, kullanicii, brosürler, reklam1, reklam2, reklam3, reklam4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elektronikk = findViewById(R.id.elektronik);
        elektronikk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, elektronik.class);
                startActivity(gecisYap);
            }
        });
        gidaa = findViewById(R.id.gida);
        gidaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, gida.class);
                startActivity(gecisYap);
            }
        });
        evv = findViewById(R.id.ev);
        evv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, ev.class);
                startActivity(gecisYap);
            }
        });
        annee = findViewById(R.id.AnneCocukOyuncak);
        annee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, anne.class);
                startActivity(gecisYap);
            }
        });
        giyimm = findViewById(R.id.giyim);
        giyimm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, giyim.class);
                startActivity(gecisYap);
            }
        });
        sporr = findViewById(R.id.spor);
        sporr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, spor.class);
                startActivity(gecisYap);
            }
        });
        kozmetikk = findViewById(R.id.kozmetik);
        kozmetikk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, kozmetik.class);
                startActivity(gecisYap);
            }
        });
        bahcee = findViewById(R.id.Bahce);
        bahcee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, bahce.class);
                startActivity(gecisYap);
            }
        });
        kullanicii = findViewById(R.id.KullaniciEkrani);
        kullanicii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, KullaniciSayfasi.class);
                startActivity(gecisYap);
            }
        });
        brosürler = findViewById(R.id.BrosurEkrani);
        brosürler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, brosurler.class);
                startActivity(gecisYap);
            }
        });
        reklam1 = findViewById(R.id.reklam1);
        reklam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, bahce.class);
                startActivity(gecisYap);
            }
        });
        reklam2 = findViewById(R.id.reklam2);
        reklam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, gida.class);
                startActivity(gecisYap);
            }
        });
        reklam3 = findViewById(R.id.reklam3);
        reklam3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, kozmetik.class);
                startActivity(gecisYap);
            }
        });
        reklam4 = findViewById(R.id.reklam4);
        reklam4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, elektronik.class);
                startActivity(gecisYap);
            }
        });
    }
}