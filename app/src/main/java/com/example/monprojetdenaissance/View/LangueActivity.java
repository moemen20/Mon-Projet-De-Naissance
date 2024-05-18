package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.monprojetdenaissance.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class LangueActivity extends AppCompatActivity{
    Button btnLangFr,btnLangEn;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langue);
         init();
         mAuth = FirebaseAuth.getInstance();
        if (isCurrentUserLoggedIn()) {
            // Utilisateur connecté, passer à l'activité principale ou à l'écran approprié
            startActivity(new Intent(this, MenuActivity.class));
        }
        btnLangFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("fr");
                recreate();
                Intent intent = new Intent(LangueActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        btnLangEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocale("ar");
                recreate();
                Intent intent = new Intent(LangueActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
    public void init(){
        btnLangFr = findViewById(R.id.frButton);
        btnLangEn = findViewById(R.id.arButton);
    }
    private boolean isCurrentUserLoggedIn() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        return currentUser != null;
    }
}
