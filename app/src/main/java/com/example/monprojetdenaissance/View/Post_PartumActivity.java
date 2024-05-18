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
import android.os.Bundle;
import com.example.monprojetdenaissance.Controller.Controller;
import com.example.monprojetdenaissance.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;


public class Post_PartumActivity extends AppCompatActivity {
    private Button next_post;
    private Controller controller;
    private RadioButton oui_1,non_1,oui_22,non_22,oui_33,non_33,oui_44,non_44,DIU,Pilule,Dépopnovera,Implanon,contraception,locaux;
    private ImageView b1;
    FirebaseAuth auth;
    DatabaseReference reference ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_partum);
        auth= FirebaseAuth.getInstance();
        reference= FirebaseDatabase.getInstance().getReference();
        init();
        next_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean oui1Ischecked,non1Ischecked,oui22Ischecked,non22Ischecked,oui33Ischecked,non33Ischecked,oui44Ischecked,non44Ischecked,DIUIschecked,PiluleIschecked,DépopnoveraIschecked,ImplanonIschecked,contraceptionIschecked,locauxIschecked;
                oui1Ischecked = oui_1.isChecked();
                non1Ischecked = non_1.isChecked();
                oui22Ischecked = oui_22.isChecked();
                non22Ischecked = non_22.isChecked();
                oui33Ischecked = oui_33.isChecked();
                non33Ischecked = non_33.isChecked();
                oui44Ischecked = oui_44.isChecked();
                DIUIschecked = DIU.isChecked();
                DépopnoveraIschecked = Dépopnovera.isChecked();
                PiluleIschecked = Pilule.isChecked();
                ImplanonIschecked = Implanon.isChecked();
                contraceptionIschecked = contraception.isChecked();
                locauxIschecked = locaux.isChecked();
                non44Ischecked = non_44.isChecked();
                String uid= Objects.requireNonNull(auth.getCurrentUser()).getUid();
                DatabaseReference userRef = reference.child(uid);
                userRef.child("je souhaiterai que mon bébé soit installé en peau à peau ").setValue(oui1Ischecked);
                userRef.child("je souhaiterai que mon bébé soit installé en peau à peau ").setValue(non1Ischecked);
                userRef.child("je voudrai allaiter mon bébé immédiatement ").setValue(oui22Ischecked);
                userRef.child("je voudrai allaiter mon bébé immédiatement ").setValue(non22Ischecked);
                userRef.child("je voudrai bénéficer de l'aide d'un conseiller en lactation ").setValue(oui33Ischecked);
                userRef.child("je voudrai bénéficer de l'aide d'un conseiller en lactation ").setValue(non33Ischecked);
                userRef.child("je voudrai faire une rééducation périnéale aprés l'accouchement ").setValue(oui44Ischecked);
                userRef.child("je voudrai faire une rééducation périnéale aprés l'accouchement ").setValue(non44Ischecked);
                userRef.child("La méthode contraceptive DIU : ").setValue(DIUIschecked);
                userRef.child("La méthode contraceptive Pilule : ").setValue(PiluleIschecked);
                userRef.child("La méthode contraceptive Dépopnovera : ").setValue(DépopnoveraIschecked);
                userRef.child("La méthode contraceptive Implanon : ").setValue(ImplanonIschecked);
                userRef.child("La méthode contraceptive par des méthodes locaux : ").setValue(locauxIschecked);
                userRef.child("La méthode contraceptive pas de contraception : ").setValue(contraceptionIschecked);

                //controller.createPatientPost(oui1Ischecked,non1Ischecked,oui22Ischecked,non22Ischecked,oui33Ischecked,non33Ischecked,oui44Ischecked,non44Ischecked,DIUIschecked,PiluleIschecked,DépopnoveraIschecked,ImplanonIschecked,contraceptionIschecked,locauxIschecked);
                Intent intent = new Intent(Post_PartumActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post_PartumActivity.this,Allaitement_Activity.class);
                startActivity(intent);
            }
        });


    }
    private void init(){
        oui_1 = findViewById(R.id.oui_1);
        non_1 = findViewById(R.id.non_1);
        oui_22 = findViewById(R.id.oui_22);
        non_22 = findViewById(R.id.non_22);
        oui_33 = findViewById(R.id.oui_33);
        non_33 = findViewById(R.id.non_33);
        oui_44 = findViewById(R.id.oui_44);
        non_44 = findViewById(R.id.non_44);
        DIU = findViewById(R.id.DIU);
        Pilule = findViewById(R.id.Pilule);
        Dépopnovera = findViewById(R.id.Dépopnovera);
        Implanon = findViewById(R.id.Implanon);
        contraception = findViewById(R.id.contraception);
        next_post = findViewById(R.id.next_post);
        controller = Controller.getInstance();
        locaux = findViewById(R.id.locaux);
        b1=findViewById(R.id.cosneil_post);
    }
}
