package com.example.monprojetdenaissance.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.monprojetdenaissance.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.Objects;

public class ResultActivity extends AppCompatActivity {
    private TextView nom,prenom, date_acc, doctor_name, sexe_baby, baby_name, Husband_name, Husband_LastName, Husband_number,
            q10 ,q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,q31,q32,q33,q34,q35,q36,q37,q38,q39,q40,
            q41,q42,q43,q44,q45,q46,q47,q48,q49,q50,q51,q52,q53,q54,q55,q56,q57,q58,q59,q60,q61,q62,q63,q64,q65,q66,q67,q68,q69;
    private Button back;
    FirebaseAuth auth;
    DatabaseReference reference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
        auth= FirebaseAuth.getInstance();
        reference=FirebaseDatabase.getInstance().getReference();
        String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
        DatabaseReference userRef = reference.child(uid);
        userRef.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    //////////////////informations personnels//////////////////
                    String name = snapshot.child("name").getValue(String.class);
                    nom.setText("Nom : "+name);
                    String last_name = snapshot.child("last_name").getValue(String.class);
                    prenom.setText("Prenom : " +last_name);
                    String acc_date = snapshot.child("date_ac").getValue(String.class);
                    date_acc.setText("Date d'accouchement prévu : "+acc_date);
                    String doctor = snapshot.child("doctor_name").getValue(String.class);
                    doctor_name.setText("Nom du medecin ou du sage femme : "+doctor);
                    String sex_baby = snapshot.child("sexe_baby").getValue(String.class);
                    sexe_baby.setText("Sexe de mon enfant : "+sex_baby);
                    String nom_baby = snapshot.child("baby_name").getValue(String.class);
                    baby_name.setText("Prénom de mon enfant : "+nom_baby);
                    String part_name = snapshot.child("Husband_name").getValue(String.class);
                    Husband_name.setText("Nom du partenaire : "+part_name);
                    String part_last_name = snapshot.child("Husband_LastNam").getValue(String.class);
                    Husband_LastName.setText("Prénom du partenaire : "+part_last_name);
                    long numero_part = snapshot.child("Husband_Numbe").getValue(long.class);
                    Husband_number.setText("Numéro de téléphone : "+numero_part);
                    //////////////////////////pendant la periode prenatale///////////////////////////////////
                    Boolean q_10 = snapshot.child("un gynécologue de l'hopital").getValue(Boolean.class);
                    q10.setText(q_10.toString());
                    Boolean q_11 = snapshot.child("un gynécologue de liberale").getValue(Boolean.class);
                    q11.setText(q_11.toString());
                    Boolean q_12 = snapshot.child("un médecin généraliste").getValue(Boolean.class);
                    q12.setText(q_12.toString());
                    Boolean q_13 = snapshot.child("une sage femme de l'hopitale").getValue(Boolean.class);
                    q13.setText(q_13.toString());
                    Boolean q_14 = snapshot.child("une sage femme libérale").getValue(Boolean.class);
                    q14.setText(q_14.toString());
                    Boolean q_15 = snapshot.child("je voudrai etre prise en charge par mon équipe préférée").getValue(Boolean.class);
                    q15.setText(q_15.toString());
                    Boolean q_16 = snapshot.child("Hopital universitaire").getValue(Boolean.class);
                    q16.setText(q_16.toString());
                    Boolean q_17 = snapshot.child("Hopital régional").getValue(Boolean.class);
                    q17.setText(q_17.toString());
                    Boolean q_18 = snapshot.child("Hopital de circonscription").getValue(Boolean.class);
                    q18.setText(q_18.toString());
                    Boolean q_19 = snapshot.child("En matérnité privée").getValue(Boolean.class);
                    q19.setText(q_19.toString());
                    Boolean q_20 = snapshot.child("La Grossesse").getValue(Boolean.class);
                    q20.setText(q_20.toString());
                    Boolean q_21 = snapshot.child("L'accouchement").getValue(Boolean.class);
                    q21.setText(q_21.toString());
                    Boolean q_22 = snapshot.child("Suites couches").getValue(Boolean.class);
                    q22.setText(q_22.toString());
                    Boolean q_23 = snapshot.child("Les differents moments").getValue(Boolean.class);
                    q23.setText(q_23.toString());
                    Boolean q_24 = snapshot.child("La meme personne de santé qui m'acceuille").getValue(Boolean.class);
                    q24.setText(q_24.toString());
                    Boolean q_25 = snapshot.child("Par la sage femme").getValue(Boolean.class);
                    q25.setText(q_25.toString());
                    Boolean q_26 = snapshot.child("Par le medecin gynécologue").getValue(Boolean.class);
                    q26.setText(q_26.toString());
                    Boolean q_27 = snapshot.child("durant le travail je veux de mon entourage mon partenaire").getValue(Boolean.class);
                    q27.setText(q_27.toString());
                    Boolean q_28 = snapshot.child("durant le travail je veux de mon entourage ma maman").getValue(Boolean.class);
                    q28.setText(q_28.toString());
                    Boolean q_29 = snapshot.child("durant le travail je veux de mon entourage un amie").getValue(Boolean.class);
                    q29.setText(q_29.toString());
                    Boolean q_30 = snapshot.child("je voudrai un accouchement Naturel : ").getValue(Boolean.class);
                    q30.setText(q_30.toString());
                    Boolean q_31 = snapshot.child("je voudrai un accouchement déclenché : ").getValue(Boolean.class);
                    q31.setText(q_31.toString());
                    Boolean q_32 = snapshot.child("je voudrai un abord veineux en place : ").getValue(Boolean.class);
                    q32.setText(q_32.toString());
                    Boolean q_33 = snapshot.child("je voudrai un abord veineux en place sauf en necéssité :").getValue(Boolean.class);
                    q33.setText(q_33.toString());
                    Boolean q_34 = snapshot.child("je voudrai un ERCF continu :").getValue(Boolean.class);
                    q34.setText(q_34.toString());
                    Boolean q_35 = snapshot.child("je voudrai un ERCF Intermittent :").getValue(Boolean.class);
                    q35.setText(q_35.toString());
                    Boolean q_36 = snapshot.child("je voudrai etre examinée par un toucher vaginal d'heure en heure : ").getValue(Boolean.class);
                    q36.setText(q_36.toString());
                    Boolean q_37 = snapshot.child("je voudrai etre examinée par un toucher vaginal selon la nécessité : ").getValue(Boolean.class);
                    q37.setText(q_37.toString());
                    Boolean q_38 = snapshot.child("je voudrai faire pendant le travail des exercices de préparation a la naissance :").getValue(Boolean.class);
                    q38.setText(q_38.toString());
                    Boolean q_39 = snapshot.child("je voudrai faire pendant le travail de se coucher :").getValue(Boolean.class);
                    q39.setText(q_39.toString());
                    Boolean q_40 = snapshot.child("je voudrai faire pendant le travail de se déplacer :").getValue(Boolean.class);
                    q40.setText(q_40.toString());
                    Boolean q_41 = snapshot.child("je voudrai gérer les douleurs par utilisation de ballon :").getValue(Boolean.class);
                    q41.setText(q_41.toString());
                    Boolean q_42 = snapshot.child("je voudrai gérer les douleurs par massage :").getValue(Boolean.class);
                    q42.setText(q_42.toString());
                    Boolean q_43 = snapshot.child("je voudrai gérer les douleurs par acupuncture :").getValue(Boolean.class);
                    q43.setText(q_43.toString());
                    Boolean q_44 = snapshot.child("je voudrai gérer les douleurs par prendre une douche ou un bain :").getValue(Boolean.class);
                    q44.setText(q_44.toString());
                    Boolean q_45 = snapshot.child("je voudrai etre informée avant chaque intervention : ").getValue(Boolean.class);
                    if(q_45) {q45.setText(q_45.toString());}
                    else {
                    q45.setText("False");}
                    Boolean q_46 = snapshot.child("je voudrai accoucher par voie basse").getValue(Boolean.class);
                    q46.setText(q_46.toString());
                    Boolean q_47 = snapshot.child("je voudrai accoucher par césarienne").getValue(Boolean.class);
                    q47.setText(q_47.toString());
                    Boolean q_48 = snapshot.child("je voudrai que l'accouchement soit accélérée :").getValue(Boolean.class);
                    if(q_48) {q48.setText(q_48.toString());}
                    else {
                        q48.setText("False");}
                    Boolean q_49 = snapshot.child("ambiance generale").getValue(Boolean.class);
                    q49.setText(q_49.toString());
                    Boolean q_50 = snapshot.child("lumiere douce").getValue(Boolean.class);
                    q50.setText(q_50.toString());
                    Boolean q_51 = snapshot.child("parler doucement").getValue(Boolean.class);
                    q51.setText(q_51.toString());
                    Boolean q_52 = snapshot.child("climat intime").getValue(Boolean.class);
                    q52.setText(q_52.toString());
                    Boolean q_53 = snapshot.child("je voudrai faire l'analgésie péridurale :").getValue(Boolean.class);
                    if(q_53) {q53.setText(q_48.toString());}
                    else {
                        q53.setText("False");}
                    Boolean q_54 = snapshot.child("je voudrai accoucher en position : Gynécologue").getValue(Boolean.class);
                    q54.setText(q_54.toString());
                    Boolean q_55 = snapshot.child("je voudrai accoucher en position : Debout").getValue(Boolean.class);
                    q55.setText(q_55.toString());
                    Boolean q_56 = snapshot.child("je voudrai accoucher en position : Décubitus Latéral").getValue(Boolean.class);
                    q56.setText(q_56.toString());
                    Boolean q_57 = snapshot.child("je voudrai accoucher en position : a quatre pattes").getValue(Boolean.class);
                    q57.setText(q_57.toString());
                    Boolean q_58 = snapshot.child("j'accepterai la présence d'un autre personnel :").getValue(Boolean.class);
                    if(q_58) {q58.setText(q_48.toString());}
                    else {
                        q58.setText("False");}
                    Boolean q_59 = snapshot.child("je voudrai que mon partenaire coupe le cordon ombilical :").getValue(Boolean.class);
                    if(q_59) {q59.setText(q_48.toString());}
                    else {
                        q59.setText("False");}
                    Boolean q_60= snapshot.child("je souhaiterai que mon bébé soit installé en peau à peau ").getValue(Boolean.class);
                    if(q_60) {q60.setText(q_48.toString());}
                    else {
                        q60.setText("False");}
                    Boolean q_61 = snapshot.child("je voudrai allaiter mon bébé immédiatement ").getValue(Boolean.class);
                    if(q_61) {q61.setText(q_48.toString());}
                    else {
                        q61.setText("False");}
                    Boolean q_62 = snapshot.child("je voudrai bénéficer de l'aide d'un conseiller en lactation ").getValue(Boolean.class);
                    if(q_62) {q62.setText(q_48.toString());}
                    else {
                        q62.setText("False");}
                    Boolean q_63 = snapshot.child("je voudrai faire une rééducation périnéale aprés l'accouchement ").getValue(Boolean.class);
                    if(q_63) {q63.setText(q_48.toString());}
                    else {
                        q63.setText("False");}
                    Boolean q_64 = snapshot.child("La méthode contraceptive DIU : ").getValue(Boolean.class);
                    q64.setText(q_64.toString());
                    Boolean q_65 = snapshot.child("La méthode contraceptive Pilule : ").getValue(Boolean.class);
                    q65.setText(q_65.toString());
                    Boolean q_66 = snapshot.child("La méthode contraceptive Dépopnovera : ").getValue(Boolean.class);
                    q66.setText(q_66.toString());
                    Boolean q_67 = snapshot.child("La méthode contraceptive Implanon : ").getValue(Boolean.class);
                    q67.setText(q_67.toString());
                    Boolean q_68 = snapshot.child("La méthode contraceptive par des méthodes locaux : ").getValue(Boolean.class);
                    q68.setText(q_68.toString());
                    Boolean q_69 = snapshot.child("La méthode contraceptive pas de contraception : ").getValue(Boolean.class);
                    q69.setText(q_69.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

    }
    public void init(){
        nom = findViewById(R.id.rep1);
        prenom = findViewById(R.id.rep2);
        date_acc=findViewById(R.id.rep3);
        doctor_name = findViewById(R.id.rep4);
        sexe_baby = findViewById(R.id.rep5);
        baby_name = findViewById(R.id.rep6);
        Husband_name = findViewById(R.id.rep7);
        Husband_LastName = findViewById(R.id.rep8);
        Husband_number = findViewById(R.id.rep9);
        q10=findViewById(R.id.rep10);
        q11=findViewById(R.id.rep11);
        q12=findViewById(R.id.rep12);
        q13=findViewById(R.id.rep13);
        q14=findViewById(R.id.rep14);
        q15=findViewById(R.id.rep15);
        q16=findViewById(R.id.rep16);
        q17=findViewById(R.id.rep17);
        q18=findViewById(R.id.rep18);
        q19=findViewById(R.id.rep19);
        q20=findViewById(R.id.rep20);
        q21=findViewById(R.id.rep21);
        q22=findViewById(R.id.rep22);
        q23=findViewById(R.id.rep23);
        q24=findViewById(R.id.rep24);
        q25=findViewById(R.id.rep25);
        q26=findViewById(R.id.rep26);
        q27=findViewById(R.id.rep27);
        q28=findViewById(R.id.rep28);
        q29=findViewById(R.id.rep29);
        q30=findViewById(R.id.rep30);
        q31=findViewById(R.id.rep31);
        q32=findViewById(R.id.rep32);
        q33=findViewById(R.id.rep33);
        q34=findViewById(R.id.rep34);
        q35=findViewById(R.id.rep35);
        q36=findViewById(R.id.rep36);
        q37=findViewById(R.id.rep37);
        q38=findViewById(R.id.rep38);
        q39=findViewById(R.id.rep39);
        q40=findViewById(R.id.rep40);
        q41=findViewById(R.id.rep41);
        q42=findViewById(R.id.rep42);
        q43=findViewById(R.id.rep43);
        q44=findViewById(R.id.rep44);
        q45=findViewById(R.id.rep45);
        q46=findViewById(R.id.rep46);
        q47=findViewById(R.id.rep47);
        q48=findViewById(R.id.rep48);
        q49=findViewById(R.id.rep49);
        q50=findViewById(R.id.rep50);
        q51=findViewById(R.id.rep51);
        q52=findViewById(R.id.rep52);
        q53=findViewById(R.id.rep53);
        q54=findViewById(R.id.rep54);
        q55=findViewById(R.id.rep55);
        q56=findViewById(R.id.rep56);
        q57=findViewById(R.id.rep57);
        q58=findViewById(R.id.rep58);
        q59=findViewById(R.id.rep59);
        q60=findViewById(R.id.rep60);
        q61=findViewById(R.id.rep61);
        q62=findViewById(R.id.rep62);
        q63=findViewById(R.id.rep63);
        q64=findViewById(R.id.rep64);
        q65=findViewById(R.id.rep65);
        q66=findViewById(R.id.rep66);
        q67=findViewById(R.id.rep67);
        q68=findViewById(R.id.rep68);
        q69=findViewById(R.id.rep69);
        back=findViewById(R.id.back_result);
    }
}