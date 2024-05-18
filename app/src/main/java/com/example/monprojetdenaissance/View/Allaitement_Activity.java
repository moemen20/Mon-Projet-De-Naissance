package com.example.monprojetdenaissance.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.monprojetdenaissance.R;

public class Allaitement_Activity extends AppCompatActivity {
    private ImageView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allaitement);
        init();
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Allaitement_Activity.this, Post_PartumActivity.class);
                startActivity(intent);
            }
        });
    }
    public void init(){
        c=findViewById(R.id.delete_allaitement);
    }
}