package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.monprojetdenaissance.R;


public class conseil_toucher_Activity extends AppCompatActivity {
    private ImageView b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseil_toucher);
        init();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(conseil_toucher_Activity.this,TravailActivity.class);
                startActivity(intent);
            }
        });

    }
    public void init(){
        b1=findViewById(R.id.deleteTouche);
    }
}