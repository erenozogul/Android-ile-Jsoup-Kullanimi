package com.example.veriekme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class KullaniciSayfasi extends AppCompatActivity {

    private EditText parola, posta;
    private Button giris,kayit,unuttum;
    private FirebaseUser currentUser;
    private FirebaseAuth auth;
    private TextView eposta,sifre;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_sayfasi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        posta = findViewById(R.id.editTextTextEmailAddress);
        parola = findViewById(R.id.editTextTextPassword);
        giris = findViewById(R.id.Giris);
        kayit = findViewById(R.id.kayıtOl);
        unuttum = findViewById(R.id.sifremiUnuttum);
        eposta = findViewById(R.id.epostaisim);
        sifre = findViewById(R.id.parolaisim);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginUser();

            }
        });
        unuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent unuttumtIntent = new Intent(KullaniciSayfasi.this,sifremiUnuttum.class);
                startActivity(unuttumtIntent);
            }
        });
        kayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent kayitIntent = new Intent(KullaniciSayfasi.this,kayitEkrani.class);
                startActivity(kayitIntent);
            }
        });
    }

    private void loginUser() {

        String email = posta.getText().toString();
        String password = parola.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"EPosta Alanı Boş Bırakılamaz.", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Parola Alanı Boş Bırakılamaz.",Toast.LENGTH_LONG).show();
        }else {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(KullaniciSayfasi.this,"Giriş Başarılı",Toast.LENGTH_LONG).show();
                        Intent girisIntent = new Intent(KullaniciSayfasi.this,MainActivity.class);
                        startActivity(girisIntent);
                        finish();

                        posta.setVisibility(View.INVISIBLE);
                        parola.setVisibility(View.INVISIBLE);
                        giris.setVisibility(View.INVISIBLE);
                        kayit.setVisibility(View.INVISIBLE);
                        unuttum.setVisibility(View.INVISIBLE);
                        eposta.setVisibility(View.INVISIBLE);
                        sifre.setVisibility(View.INVISIBLE);
                    }else {
                        Toast.makeText(KullaniciSayfasi.this,"Giriş Başarısız",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}