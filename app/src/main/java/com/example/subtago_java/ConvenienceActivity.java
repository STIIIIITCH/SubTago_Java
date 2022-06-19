package com.example.subtago_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ConvenienceActivity extends AppCompatActivity {

    Intent intentMain;

    Button btnline1, btnline2, btnline3, btnline4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convenience_1);

        //xml버튼들 객체연결
        btnline1 = findViewById(R.id.btnline1);
        btnline2 = findViewById(R.id.btnline2);
        btnline3 = findViewById(R.id.btnline3);
        btnline4 = findViewById(R.id.btnline4);

        Intent intentline1 = new Intent(this, line1Activity1.class);
        Intent intentline2 = new Intent(this, bikeActivity.class);
        Intent intentline3 = new Intent(this, cutomerActivity.class);
        Intent intentline4 = new Intent(this, placeActivity.class);


        btnline1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline1);
            }
        });
        btnline2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline2);
            }
        });
        btnline3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline3);
            }
        });
        btnline4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline4);
            }
        });

    }
    @Override
    public void onBackPressed() {
        startActivity(intentMain);
        finish();
    }
}