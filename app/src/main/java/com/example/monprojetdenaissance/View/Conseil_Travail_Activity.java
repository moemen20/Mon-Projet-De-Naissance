package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.monprojetdenaissance.R;

public class Conseil_Travail_Activity extends AppCompatActivity {
    private ImageView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseil_travail);
        init();
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Conseil_Travail_Activity.this,TravailActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        c=findViewById(R.id.delete_travail);
    }
}