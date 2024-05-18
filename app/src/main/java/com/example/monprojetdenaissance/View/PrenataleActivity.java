package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;


import com.example.monprojetdenaissance.R;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;


import com.example.monprojetdenaissance.Controller.Controller;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class PrenataleActivity extends AppCompatActivity {
    private CheckBox a,b,c,d,e,j,k,l,m;
    private Button conf;
    private RadioButton f,g,h,i,Oui,Non;
    private Controller controller;
    private ImageView b1;
    FirebaseAuth auth;
    DatabaseReference reference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenatale);
        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        init();
        conf.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean aIschecked,bIschecked,cIschecked,dIschecked,eIschecked,fIschecked,gIschecked,hIschecked,iIschecked,jIschecked,kIschecked,lIschecked,mIschecked,ouiIschecked;
                boolean checkBox1States = a.isChecked()|| b.isChecked() || c.isChecked() || d.isChecked() || e.isChecked();
                boolean checkBox2States = j.isChecked() || k.isChecked() || l.isChecked() || m.isChecked();
                if(!checkBox1States)
                    Toast.makeText(PrenataleActivity.this, "Veuillez cocher 1- !", Toast.LENGTH_LONG).show();
                if(!checkBox2States)
                    Toast.makeText(PrenataleActivity.this, "Veuillez cocher 4- !", Toast.LENGTH_LONG).show();
                if( checkBox1States && checkBox2States ){
                    aIschecked = a.isChecked();
                    bIschecked = b.isChecked();
                    cIschecked = c.isChecked();
                    dIschecked = d.isChecked();
                    eIschecked = e.isChecked();
                    fIschecked = f.isChecked();
                    gIschecked = g.isChecked();
                    hIschecked = h.isChecked();
                    iIschecked = i.isChecked();
                    jIschecked = j.isChecked();
                    kIschecked = k.isChecked();
                    lIschecked = l.isChecked();
                    mIschecked = m.isChecked();
                    ouiIschecked = Oui.isChecked();
                    //controller.createPatientPrenatal(aIschecked,bIschecked,cIschecked,dIschecked,eIschecked,fIschecked,gIschecked,hIschecked,iIschecked,jIschecked,kIschecked,lIschecked,mIschecked,ouiIschecked);
                    String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
                    DatabaseReference userRef = reference.child(uid);
                    userRef.child("un gynécologue de l'hopital").setValue(aIschecked);
                    userRef.child("un gynécologue de liberale").setValue(bIschecked);
                    userRef.child("un médecin généraliste").setValue(cIschecked);
                    userRef.child("une sage femme de l'hopitale").setValue(dIschecked);
                    userRef.child("une sage femme libérale").setValue(eIschecked);
                    userRef.child("je voudrai etre prise en charge par mon équipe préférée").setValue(ouiIschecked);
                    userRef.child("Hopital universitaire").setValue(fIschecked);
                    userRef.child("Hopital régional").setValue(gIschecked);
                    userRef.child("Hopital de circonscription").setValue(hIschecked);
                    userRef.child("En matérnité privée").setValue(iIschecked);
                    userRef.child("La Grossesse").setValue(jIschecked);
                    userRef.child("L'accouchement").setValue(kIschecked);
                    userRef.child("Suites couches").setValue(lIschecked);
                    userRef.child("Les differents moments").setValue(mIschecked);
                    Toast.makeText(PrenataleActivity.this, "envoi avec succée !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PrenataleActivity.this, MenuActivity.class);
                    startActivity(intent);
                }


            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrenataleActivity.this,Conseil_Travail_Activity.class);
                startActivity(intent);
            }
        });
    }
    private void init(){
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        conf = findViewById(R.id.conf);
        controller = Controller.getInstance();
        Oui = findViewById(R.id.Oui);
        Non = findViewById(R.id.Non);
        b1=findViewById(R.id.conseilq4);
    }
}
