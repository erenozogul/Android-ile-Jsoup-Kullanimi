package com.example.veriekme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.squareup.picasso.Picasso;

public class kayitEkrani extends AppCompatActivity {

    private FirebaseUser currentUser;
    private FirebaseAuth auth;
    private EditText adı,soyadı,sifresi,tekrarSifresi,mail,tekrarmail;
    private Button hesapOlustur;
    private Button googlecikis,twitter;
    private SignInButton signInButton;
    private GoogleSignInClient mGoogleSignInClient;
    private String TAG = "kayitEkrani";
    private final static int RC_SIGN_IN = 1;
    private CallbackManager mCallbackManager;
    private LoginButton loginButton;

    private FirebaseAuth.AuthStateListener authStateListener;
    private AccessTokenTracker accessTokenTracker;
    private ImageView mLogo;
    private TextView textViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();

        textViewUser = findViewById(R.id.deneme);
        mLogo = findViewById(R.id.logo);

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_kayit_ekrani);
        loginButton = findViewById(R.id.facebookButton);
        loginButton.setReadPermissions("email","public_profile");
        mCallbackManager = CallbackManager.Factory.create();
        /*
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG,"Giriş Başarılı"+ loginResult);
                handleFacebookToken(loginResult.getAccessToken());
            }
            @Override
            public void onCancel() {
                Log.d(TAG,"Giriş Başarılı");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG,"Giriş Başarılı"+ error);
            }
        });
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    updadeUIFacebook(user);
                }else{
                    updadeUIFacebook(null);
                }
            }
        };
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
                if (currentAccessToken==null){
                    auth.signOut();
                }
            }
        };
 */
        adı = findViewById(R.id.kullanıcıAdı);
        soyadı = findViewById(R.id.kullanıcıSoyadı);
        sifresi = findViewById(R.id.sifre);
        tekrarSifresi = findViewById(R.id.sifreTekrar);
        mail = findViewById(R.id.posta);
        tekrarmail = findViewById(R.id.postaTekrarı);

        hesapOlustur = findViewById(R.id.hesapOlustur);

        hesapOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }
        });

        signInButton = findViewById(R.id.googlebutton);
        googlecikis = findViewById(R.id.googlebuttoncikis);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        googlecikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.signOut();
                Toast.makeText(kayitEkrani.this,"çıkış başarılı", Toast.LENGTH_SHORT).show();
                googlecikis.setVisibility(View.INVISIBLE);
            }
        });
    }
/*
    private void handleFacebookToken(AccessToken accessToken) {
        Log.d(TAG,"handleFacebookToken"+ accessToken);

        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        auth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG,"sign in with credential: successful");
                    FirebaseUser user = auth.getCurrentUser();
                    updadeUIFacebook(user);
                }
                else{
                    Log.d(TAG,"sign in with credential: failure",task.getException());
                    Toast.makeText(kayitEkrani.this,"sign in with credential: failure", Toast.LENGTH_SHORT).show();
                    updadeUIFacebook(null);
                }
            }
        });
    }
    private void updadeUIFacebook(FirebaseUser user) {
        if (user != null){
            if (user.getPhotoUrl() != null){
                String photoUrl = user.getPhotoUrl().toString();
                photoUrl = photoUrl + "?type = large";
                Picasso.get().load(photoUrl).into(mLogo);
            }
            else{
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authStateListener != null){
            auth.removeAuthStateListener(authStateListener);
        }
    }

 */
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
     if (requestCode == RC_SIGN_IN){
         Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
         handleSingInResult(task);
     }
     mCallbackManager.onActivityResult(requestCode,resultCode,data);
     super.onActivityResult(requestCode,resultCode,data);
    }
    private void handleSingInResult(Task<GoogleSignInAccount> completedTask) {
        try{
            GoogleSignInAccount acc = completedTask.getResult(ApiException.class);
            Toast.makeText(kayitEkrani.this,"Giriş Başarılı", Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(acc);
        } catch (ApiException e) {
            Toast.makeText(kayitEkrani.this,"Giriş Başarısız",Toast.LENGTH_SHORT).show();
            FirebaseGoogleAuth(null);
        }
    }
    private void FirebaseGoogleAuth(GoogleSignInAccount acct) {
        AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        auth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(kayitEkrani.this,"Başarılı",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = auth.getCurrentUser();
                    updateUI(user);

                }else {
                    Toast.makeText(kayitEkrani.this,"Başarısız",Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    private void updateUI(FirebaseUser fuser) {
        googlecikis.setVisibility(View.VISIBLE);
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if (account != null){
            String personName = account.getDisplayName();
            String personGivenName = account.getGivenName();
            String personFamilyName = account.getFamilyName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            Uri personPhoto = account.getPhotoUrl();

            Toast.makeText(kayitEkrani.this,personName + personEmail ,Toast.LENGTH_SHORT).show();
        }
    }
    private void createNewAccount() {

        String email = mail.getText().toString();
        String password = sifresi.getText().toString();
        String ad = adı.getText().toString();
        String soyad = soyadı.getText().toString();
        String emailTekrar = tekrarmail.getText().toString();
        String tekrarsifre = tekrarSifresi.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"EPosta Alanı Boş Bırakılamaz.", Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"Parola Alanı Boş Bırakılamaz.",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(ad)){
            Toast.makeText(this,"Adınızı Girmelisiniz.",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(soyad)){
            Toast.makeText(this,"Soyadınızı Girmelisiniz.",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(emailTekrar)){
            Toast.makeText(this,"EPosta Tekrar alanını Lütfen doldurunuz.",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(tekrarsifre)){
            Toast.makeText(this,"Parola Tekrar alanını Lütfen doldurunuz.",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(email) != TextUtils.isEmpty(emailTekrar)){
            Toast.makeText(this,"Girilen E-Posta adresleri eşleşmiyor .",Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(password) != TextUtils.isEmpty(tekrarsifre)){
            Toast.makeText(this,"Girilen Sifreler eşleşmiyor .",Toast.LENGTH_LONG).show();
        }else {
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(kayitEkrani.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();
                        Intent girisIntent = new Intent(kayitEkrani.this,KullaniciSayfasi.class);
                        startActivity(girisIntent);
                        finish();
                    }else {
                        Toast.makeText(kayitEkrani.this,"Kayıt Başarısız Lütfen Mail ve Parolanızı Kontrol Ediniz !!",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}