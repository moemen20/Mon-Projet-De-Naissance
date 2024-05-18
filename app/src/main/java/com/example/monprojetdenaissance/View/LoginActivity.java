package com.example.monprojetdenaissance.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private TextView signupRedirectText;
    private String email,password;
    private EditText loginEmail,loginPassword;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = loginEmail.getText().toString();
                password = loginPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(LoginActivity.this, "Veuillez saisir tout les champs !", Toast.LENGTH_SHORT).show();
                else {
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Connexion reussite !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Connexion echouée !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }

        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SingupActivity.class);
                startActivity(intent);
            }
        });

    }
    public void init(){
        loginButton= findViewById(R.id.login_button);
        loginEmail=findViewById(R.id.login_email);
        loginPassword=findViewById(R.id.login_password);
        signupRedirectText=findViewById(R.id.signupRedirectText);

    }
}