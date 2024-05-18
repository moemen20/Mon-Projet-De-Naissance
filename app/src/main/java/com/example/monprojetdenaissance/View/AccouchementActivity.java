package com.example.monprojetdenaissance.View;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.monprojetdenaissance.Controller.Controller;
import com.example.monprojetdenaissance.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class AccouchementActivity extends AppCompatActivity {
    private CheckBox aaaa,bbbb,cccc,dddd,eeee,ffff,gggg,hhhh;
    private Button next_acc;
    private RadioButton voie_basse,cesarienne,oui_2,non_2,oui_4,non_4,oui_6,non_6,oui_7,non_7;
    private Controller controller;
    private ImageView c1,c2;
    FirebaseAuth auth;
    DatabaseReference reference ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accouchement);
        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        init();
        next_acc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                boolean checkBox1States = aaaa.isChecked() || bbbb.isChecked() || cccc.isChecked() || dddd.isChecked();
                boolean checkBox2States = eeee.isChecked() || ffff.isChecked() || gggg.isChecked() || hhhh.isChecked();
                boolean aaaaIsChecked, bbbbIsChecked,ccccIsChecked,ddddIsChecked,eeeeIsChecked, ffffIsChecked,ggggIsChecked,hhhhIsChecked,voie_basseIsChecked,cesarienneIsChecked,oui_2IsChecked,non_2IsChecked,oui_4IsChecked,non_4IsChecked,oui_6IsChecked,non_6IsChecked,oui_7IsChecked,non_7IsChecked;
                aaaaIsChecked = aaaa.isChecked();
                bbbbIsChecked = bbbb.isChecked();
                ccccIsChecked = cccc.isChecked();
                ddddIsChecked = dddd.isChecked();
                eeeeIsChecked = eeee.isChecked();
                ffffIsChecked = ffff.isChecked();
                ggggIsChecked = gggg.isChecked();
                hhhhIsChecked = hhhh.isChecked();
                voie_basseIsChecked=voie_basse.isChecked();
                cesarienneIsChecked=cesarienne.isChecked();
                oui_2IsChecked=oui_2.isChecked();
                non_2IsChecked=non_2.isChecked();
                oui_4IsChecked=oui_4.isChecked();
                non_4IsChecked=non_4.isChecked();
                oui_6IsChecked=oui_6.isChecked();
                non_6IsChecked=non_6.isChecked();
                oui_7IsChecked=oui_7.isChecked();
                non_7IsChecked=non_7.isChecked();

                if (!checkBox1States)
                    Toast.makeText(AccouchementActivity.this, "Veuillez cocher 3- !", Toast.LENGTH_LONG).show();
                if (!checkBox2States)
                    Toast.makeText(AccouchementActivity.this, "Veuillez cocher 5- !", Toast.LENGTH_LONG).show();
                if (checkBox1States && checkBox2States) {
                   // controller.createPatientAccouchement(aaaaIsChecked, bbbbIsChecked,ccccIsChecked,ddddIsChecked,eeeeIsChecked, ffffIsChecked,ggggIsChecked,hhhhIsChecked,voie_basseIsChecked,cesarienneIsChecked,oui_2IsChecked,non_2IsChecked,oui_4IsChecked,non_4IsChecked,oui_6IsChecked,non_6IsChecked,oui_7IsChecked,non_7IsChecked);
                    String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
                    DatabaseReference userRef = reference.child(uid);
                    userRef.child("je voudrai accoucher par voie basse").setValue(voie_basseIsChecked);
                    userRef.child("je voudrai accoucher par césarienne").setValue(cesarienneIsChecked);
                    userRef.child("je voudrai que l'accouchement soit accélérée :").setValue(oui_2IsChecked);
                    userRef.child("je voudrai que l'vaccouchement soit accélérée :").setValue(non_2IsChecked);
                    userRef.child("je voudrai faire l'analgésie péridurale :").setValue(oui_4IsChecked);
                    userRef.child("je voudrai faire l'analgésie péridurale :").setValue(non_4IsChecked);
                    userRef.child("ambiance generale").setValue(aaaaIsChecked);
                    userRef.child("lumiere douce").setValue(bbbbIsChecked);
                    userRef.child("parler doucement").setValue(ccccIsChecked);
                    userRef.child("climat intime").setValue(ddddIsChecked);
                    userRef.child("je voudrai accoucher en position : Gynécologue").setValue(eeeeIsChecked);
                    userRef.child("je voudrai accoucher en position : Debout").setValue(ffffIsChecked);
                    userRef.child("je voudrai accoucher en position : Décubitus Latéral").setValue(ggggIsChecked);
                    userRef.child("je voudrai accoucher en position : a quatre pattes").setValue(hhhhIsChecked);
                    userRef.child("j'accepterai la présence d'un autre personnel :").setValue(oui_6IsChecked);
                    userRef.child("j'accepterai la présence d'un autre personnel :").setValue(non_6IsChecked);
                    userRef.child("je voudrai que mon partenaire coupe le cordon ombilical :").setValue(oui_7IsChecked);
                    userRef.child("je voudrai que mon partenaire coupe le cordon ombilical :").setValue(non_7IsChecked);
                    Toast.makeText(AccouchementActivity.this, "envoi avec succée !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AccouchementActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccouchementActivity.this,Conseil_accoucher_Activity.class);
                startActivity(intent);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccouchementActivity.this, conseil_analgesie_Activity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        aaaa = findViewById(R.id.aaaa);
        bbbb = findViewById(R.id.bbbb);
        cccc = findViewById(R.id.cccc);
        dddd = findViewById(R.id.dddd);
        eeee = findViewById(R.id.eeee);
        ffff = findViewById(R.id.ffff);
        gggg = findViewById(R.id.gggg);
        hhhh = findViewById(R.id.hhhh);
        voie_basse = findViewById(R.id.voie_basse);
        cesarienne = findViewById(R.id.cesarienne);
        oui_2 = findViewById(R.id.oui_2);
        non_2 = findViewById(R.id.non_2);
        oui_4 = findViewById(R.id.oui_4);
        non_4 = findViewById(R.id.non_4);
        oui_6 = findViewById(R.id.oui_6);
        non_6 = findViewById(R.id.non_6);
        oui_7 = findViewById(R.id.oui_7);
        non_7 = findViewById(R.id.non_7);
        next_acc = findViewById(R.id.next_acc);
        controller = Controller.getInstance();
        c1=findViewById(R.id.cosneilq6);
        c2=findViewById(R.id.cosneilq44);
    }
}
