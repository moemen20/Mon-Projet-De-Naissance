package com.example.monprojetdenaissance.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.monprojetdenaissance.Controller.Controller;
import com.example.monprojetdenaissance.R;
import com.example.monprojetdenaissance.databinding.ActivityPersonalInfoBinding;
import com.example.monprojetdenaissance.model.Patient.Patient_InfoPerso;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class PersonalInfoActivity extends AppCompatActivity {
    private TextView info_personnel, name_user, firstname_user, date_acc_user, Husband_Phone_number, doctorname_user, sexe_baby_user, name_baby_user, name_Husband_user, LastName_Husband_user;
    private EditText name, last_name, date_acc, doctor_name, sexe_baby, baby_name, Husband_name, Husband_LastName, Husband_Number;
    private Button next_personal;
    private Controller controller;
    FirebaseAuth auth;
    DatabaseReference reference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        auth= FirebaseAuth.getInstance();
        reference=FirebaseDatabase.getInstance().getReference();
        init();
        next_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");
                boolean verifLastName = false, verifDateAcc = false, verifName = false, verifDoctorName = false;
                boolean verifSexeBb = false, verifBbName = false, verifHN = false, verifHLN = false, verifHPN = false;
                String nam,last_nam,doctor_nam,sexe_bab,baby_nam,Husband_nam,Husband_LastNam,date_ac;
                long Husband_Numbe;
                if(!name.getText().toString().isEmpty())
                    verifName = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir votre prenom !", Toast.LENGTH_LONG).show();
                if(!last_name.getText().toString().isEmpty())
                    verifLastName = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir votre nom !", Toast.LENGTH_LONG).show();
                if(!date_acc.getText().toString().isEmpty())
                    verifDateAcc = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir votre Date d'accouchement prevu !", Toast.LENGTH_LONG).show();
                if(!doctor_name.getText().toString().isEmpty())
                    verifDoctorName = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le nom du docteur !", Toast.LENGTH_LONG).show();
                if(!sexe_baby.getText().toString().isEmpty())
                    verifSexeBb = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le sexe du bébé !", Toast.LENGTH_LONG).show();
                if(!baby_name.getText().toString().isEmpty())
                    verifBbName = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le nom du bébé !", Toast.LENGTH_LONG).show();
                if(!Husband_name.getText().toString().isEmpty())
                    verifHN = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le prenom du patrenaire !", Toast.LENGTH_LONG).show();
                if(!Husband_LastName.getText().toString().isEmpty())
                    verifHLN = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le nom du partenaire !", Toast.LENGTH_LONG).show();
                if(!Husband_Number.getText().toString().isEmpty())
                    verifHPN = true;
                else
                    Toast.makeText(PersonalInfoActivity.this, "Veuillez saisir le numero du partenaire !", Toast.LENGTH_LONG).show();
                if(verifLastName && verifDateAcc && verifName && verifDoctorName && verifSexeBb && verifBbName && verifHN && verifHLN && verifHPN){
                    nam = name.getText().toString();
                    last_nam= last_name.getText().toString();
                    doctor_nam= doctor_name.getText().toString();
                    sexe_bab= sexe_baby.getText().toString();
                    baby_nam= baby_name.getText().toString();
                    Husband_nam= Husband_name.getText().toString();
                    Husband_LastNam= Husband_LastName.getText().toString();
                    date_ac= date_acc.getText().toString();
                    Husband_Numbe = Long.parseLong(Husband_Number.getText().toString());
                    String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
                    DatabaseReference userRef = reference.child(uid);
                    userRef.child("name").setValue(nam);
                    userRef.child("last_name").setValue(last_nam);
                    userRef.child("doctor_name").setValue(doctor_nam);
                    userRef.child("sexe_baby").setValue(sexe_bab);
                    userRef.child("baby_name").setValue(baby_nam);
                    userRef.child("Husband_name").setValue(Husband_nam);
                    userRef.child("Husband_LastNam").setValue(Husband_LastNam);
                    userRef.child("date_ac").setValue(date_ac);
                    userRef.child("Husband_Numbe").setValue(Husband_Numbe);

                  //  controller.createPatientInfoPerso(nam,last_nam,doctor_nam,sexe_bab,baby_nam,Husband_nam,Husband_LastNam,date_ac,Husband_Numbe);
                   // Patient_InfoPerso info = new Patient_InfoPerso(nam,last_nam,doctor_nam,sexe_bab,baby_nam,Husband_nam,Husband_LastNam,date_ac,Husband_Numbe);
                    Toast.makeText(PersonalInfoActivity.this, "envoi avec succes !", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PersonalInfoActivity.this, MenuActivity.class);
                    startActivity(intent);


                }
            }
        });

    }
    private void init() {
        info_personnel = findViewById(R.id.info_personnel);
        name_user = findViewById(R.id.name_user);
        firstname_user = findViewById(R.id.firstname_user);
        date_acc_user = findViewById(R.id.date_acc_user);
        Husband_Phone_number = findViewById(R.id.Husband_Phone_number);
        doctorname_user = findViewById(R.id.doctorname_user);
        sexe_baby_user = findViewById(R.id.sexe_baby_user);
        name_baby_user = findViewById(R.id.name_baby_user);
        name_Husband_user = findViewById(R.id.name_Husband_user);
        LastName_Husband_user = findViewById(R.id.LastName_Husband_user);


        name = findViewById(R.id.name);
        last_name = findViewById(R.id.last_name);
        date_acc = findViewById(R.id.date_acc);
        doctor_name = findViewById(R.id.doctor_name);
        sexe_baby = findViewById(R.id.sexe_baby);
        doctorname_user = findViewById(R.id.doctorname_user);
        sexe_baby_user = findViewById(R.id.sexe_baby_user);
        baby_name = findViewById(R.id.baby_name);
        Husband_name = findViewById(R.id.Husband_name);
        Husband_LastName = findViewById(R.id.Husband_LastName);
        Husband_Number = findViewById(R.id.Husband_Number);
        next_personal = findViewById(R.id.next_personal);

        controller = Controller.getInstance();
    }
}
