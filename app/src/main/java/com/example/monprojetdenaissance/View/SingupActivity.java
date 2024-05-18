package com.example.monprojetdenaissance.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.monprojetdenaissance.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingupActivity extends AppCompatActivity {

    private  Button signupButton;
    private String email,password,confirmPassword;
    private EditText signEmail,signPassword,signConfirm;
    private TextView redirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        signupButton = findViewById(R.id.login_button);
        signEmail=findViewById(R.id.signup_email);
        signPassword=findViewById(R.id.signup_password);
        signConfirm=findViewById(R.id.signup_confirm);
        redirectText = findViewById(R.id.loginRedirectText);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = signEmail.getText().toString();
                password = signPassword.getText().toString();
                confirmPassword = signConfirm.getText().toString();

                if(email.isEmpty()||password.isEmpty()||confirmPassword.isEmpty())
                    Toast.makeText(SingupActivity.this, "Veuillez remplir tout les champs !!", Toast.LENGTH_SHORT).show();
                else {
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(SingupActivity.this, "Création du compte reussite !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

                }

                if(!password.equals(confirmPassword)){
                        Toast.makeText(SingupActivity.this, "Veuillez entrer le meme Mot de passe !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        redirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });



    }
}