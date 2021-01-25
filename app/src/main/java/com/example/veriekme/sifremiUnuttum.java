package com.example.veriekme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class sifremiUnuttum extends AppCompatActivity {

    ProgressBar progressBar;
    EditText kullaniciEmail;
    Button sifremiSifirla;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sifremi_unuttum);

        kullaniciEmail = findViewById(R.id.epostaSifreYolla);
        sifremiSifirla = findViewById(R.id.sifreGonder);

        firebaseAuth = FirebaseAuth.getInstance();

        sifremiSifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.sendPasswordResetEmail(kullaniciEmail.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(sifremiUnuttum.this,
                                            "Şifreniz Sıfırlandı Lütfen Mailinize bakınız",
                                            Toast.LENGTH_LONG).show();
                                }else {
                                    Toast.makeText(sifremiUnuttum.this,
                                            task.getException().getMessage(),Toast.LENGTH_LONG
                                    ).show();
                                }
                            }
                        });
            }
        });
    }
}