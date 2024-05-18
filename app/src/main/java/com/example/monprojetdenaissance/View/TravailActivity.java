package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;




import com.example.monprojetdenaissance.Controller.Controller;
import com.example.monprojetdenaissance.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;


public class TravailActivity extends AppCompatActivity {
    private CheckBox aa,bb,cc,aaa,bbb,ccc,ddd,eee,fff,ggg;
    private RadioButton dd,ee,ff;
    private Button next_travail;
    private RadioButton gg,hh,oui,necessaire,continu,Intermittent,recommandation,necessite,oui_9,non_9;
    private Controller controller;
    FirebaseAuth auth;
    DatabaseReference reference ;
    private ImageView c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travail);
        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        init();
        next_travail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkBox1States = aa.isChecked()|| bb.isChecked() || cc.isChecked();
                boolean checkBox2States = aaa.isChecked()|| bbb.isChecked() || ccc.isChecked();
                boolean checkBox3States = ddd.isChecked()|| eee.isChecked() || fff.isChecked()|| ggg.isChecked();
                boolean necessiteIsChecked ,aaIsChecked, bbIsChecked,ccIsChecked,dddIsChecked,ddIsChecked,eeIsChecked,eeeIsChecked,ffIsChecked,recommandationIsChecked, fffIsChecked,ggIsChecked,gggIsChecked,hhIsChecked,aaaIsChecked,bbbIsChecked,cccIsChecked,ouiIsChecked,oui_9IsChecked,non_9IsChecked,IntermittentIsChecked,continuIsChecked,necessaireIsChecked;
                necessaireIsChecked=necessaire.isChecked();
                necessiteIsChecked=necessite.isChecked();
                aaIsChecked=aa.isChecked();
                bbIsChecked=bb.isChecked();
                ccIsChecked=cc.isChecked();


                dddIsChecked=ddd.isChecked();
                cccIsChecked=ccc.isChecked();
                ddIsChecked=dd.isChecked();
                aaaIsChecked=aaa.isChecked();
                bbbIsChecked=bbb.isChecked();
                eeIsChecked=ee.isChecked();


                eeeIsChecked=eee.isChecked();
                ffIsChecked=ff.isChecked();
                fffIsChecked=fff.isChecked();
                recommandationIsChecked=recommandation.isChecked();
                oui_9IsChecked=oui_9.isChecked();


                non_9IsChecked=non_9.isChecked();
                gggIsChecked=ggg.isChecked();
                ggIsChecked=gg.isChecked();
                hhIsChecked=hh.isChecked();
                ouiIsChecked=oui.isChecked();


                continuIsChecked=continu.isChecked();
                IntermittentIsChecked=Intermittent.isChecked();


                //
                if(!checkBox1States)
                    Toast.makeText(TravailActivity.this, "Veuillez cocher 1- !", Toast.LENGTH_LONG).show();
                if(!checkBox2States)
                    Toast.makeText(TravailActivity.this, "Veuillez cocher 7- !", Toast.LENGTH_LONG).show();
                if(!checkBox3States)
                    Toast.makeText(TravailActivity.this, "Veuillez cocher 8- !", Toast.LENGTH_LONG).show();
                if(checkBox1States && checkBox2States && checkBox3States){
                    String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
                    DatabaseReference userRef = reference.child(uid);
                   userRef.child("La meme personne de santé qui m'acceuille").setValue(aaIsChecked);
                   userRef.child("Par la sage femme").setValue(bbIsChecked);
                   userRef.child("Par le medecin gynécologue").setValue(ccIsChecked);
                   userRef.child("durant le travail je veux de mon entourage mon partenaire").setValue(ddIsChecked);
                   userRef.child("durant le travail je veux de mon entourage ma maman").setValue(eeIsChecked);
                   userRef.child("durant le travail je veux de mon entourage un amie").setValue(ffIsChecked);
                   userRef.child("je voudrai un accouchement Naturel : ").setValue(hhIsChecked);
                   userRef.child("je voudrai un accouchement déclenché : ").setValue(ggIsChecked);
                   userRef.child("je voudrai un abord veineux en place : ").setValue(ouiIsChecked);
                   userRef.child("je voudrai un abord veineux en place sauf en necéssité :").setValue(necessaireIsChecked);
                   userRef.child("je voudrai un ERCF continu :").setValue(continuIsChecked);
                   userRef.child("je voudrai un ERCF Intermittent :").setValue(IntermittentIsChecked);
                   userRef.child("je voudrai etre examinée par un toucher vaginal d'heure en heure : ").setValue(recommandationIsChecked);
                   userRef.child("je voudrai etre examinée par un toucher vaginal selon la nécessité : ").setValue(necessiteIsChecked);
                   userRef.child("je voudrai faire pendant le travail des exercices de préparation a la naissance :").setValue(aaaIsChecked);
                   userRef.child("je voudrai faire pendant le travail de se coucher :").setValue(bbbIsChecked);
                   userRef.child("je voudrai faire pendant le travail de se déplacer :").setValue(bbbIsChecked);
                   userRef.child("je voudrai gérer les douleurs par utilisation de ballon :").setValue(dddIsChecked);
                   userRef.child("je voudrai gérer les douleurs par massage :").setValue(eeeIsChecked);
                   userRef.child("je voudrai gérer les douleurs par acupuncture :").setValue(fffIsChecked);
                   userRef.child("je voudrai gérer les douleurs par prendre une douche ou un bain :").setValue(gggIsChecked);
                   userRef.child("je voudrai etre informée avant chaque intervention : ").setValue(oui_9IsChecked);
                   userRef.child("je voudrai etre informée avant chaque intervention").setValue(non_9IsChecked);
                    //controller.createPatientTravail(necessiteIsChecked ,aaIsChecked, bbIsChecked,ccIsChecked,dddIsChecked,ddIsChecked,eeIsChecked,eeeIsChecked,ffIsChecked,recommandationIsChecked, fffIsChecked,ggIsChecked,gggIsChecked,hhIsChecked,aaaIsChecked,bbbIsChecked,cccIsChecked,ouiIsChecked,oui_9IsChecked,non_9IsChecked,IntermittentIsChecked,continuIsChecked,necessaireIsChecked);
                    Toast.makeText(TravailActivity.this, "envoi avec succée !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TravailActivity.this,MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TravailActivity.this,conseil_toucher_Activity.class);
                startActivity(intent);

            }
        });
    }
    private void init(){
        aa=findViewById(R.id.aa);
        bb=findViewById(R.id.bb);
        cc=findViewById(R.id.cc);
        dd=findViewById(R.id.dd);
        ee=findViewById(R.id.ee);
        ff=findViewById(R.id.ff);
        aaa=findViewById(R.id.aaa);
        bbb=findViewById(R.id.bbb);
        ccc=findViewById(R.id.ccc);
        ddd=findViewById(R.id.ddd);
        eee=findViewById(R.id.eee);
        fff=findViewById(R.id.fff);
        ggg=findViewById(R.id.ggg);
        next_travail = findViewById(R.id.next_travail);
        controller = Controller.getInstance();
        gg=findViewById(R.id.gg);
        hh=findViewById(R.id.hh);
        oui=findViewById(R.id.oui);
        necessaire=findViewById(R.id.necessaire);
        continu=findViewById(R.id.continu);
        recommandation=findViewById(R.id.recommandation);
        Intermittent=findViewById(R.id.Intermittent);
        necessite=findViewById(R.id.necessite);
        oui_9=findViewById(R.id.oui_9);
        non_9=findViewById(R.id.non_9);
        c1=findViewById(R.id.cosneilq6);


    }
}
