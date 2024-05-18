package com.example.monprojetdenaissance.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.monprojetdenaissance.Controller.Controller;
import com.example.monprojetdenaissance.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;



public class MenuActivity extends AppCompatActivity {
    private TextView entete,infoP,Post,Acc,Travail,Prenatal;
    private Button reponse,confirmer;
    private FirebaseAuth mAuth;


    private Controller controller;
    private SeekBar seek;
    private Controller cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();

        infoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress((seek.getProgress() + (seek.getMax() - seek.getMin()) / 5));
                Intent intent =new  Intent(MenuActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
        Post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress((seek.getProgress() + (seek.getMax() - seek.getMin()) / 5));
                Intent intent =new  Intent(MenuActivity.this, Post_PartumActivity.class);
                startActivity(intent);
            }
        });
        Acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress((seek.getProgress() + (seek.getMax() - seek.getMin()) / 5));
                Intent intent =new  Intent(MenuActivity.this,AccouchementActivity.class);
                startActivity(intent);
            }
        });
        Travail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress((seek.getProgress() + (seek.getMax() - seek.getMin()) / 5));
                Intent intent =new  Intent(MenuActivity.this,TravailActivity.class);
                startActivity(intent);
            }
        });
        Prenatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seek.setProgress((seek.getProgress() + (seek.getMax() - seek.getMin()) / 5));
                Intent intent =new  Intent(MenuActivity.this, PrenataleActivity.class);
                startActivity(intent);
            }
        });
        reponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });
        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth=FirebaseAuth.getInstance();
                mAuth.signOut();
                Intent intent = new Intent(MenuActivity.this, LangueActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    private void init(){


        entete = findViewById(R.id.entete);
        infoP = findViewById(R.id.infoP);
        Post = findViewById(R.id.Post);
        Acc = findViewById(R.id.Acc);
        Travail = findViewById(R.id.Travail);
        Prenatal = findViewById(R.id.Prenatal);
        controller = Controller.getInstance();
        cont = Controller.getInstance();
        seek=findViewById(R.id.seek);
        reponse=findViewById(R.id.reponses);
        confirmer=findViewById(R.id.decon);
    }




}
