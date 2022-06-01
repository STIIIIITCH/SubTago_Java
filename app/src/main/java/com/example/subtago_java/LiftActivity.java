package com.example.subtago_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LiftActivity extends AppCompatActivity {

    Intent intentMain;

    Button btnline1, btnline2, btnline3, btnline4, btnline5, btnline6, btnline7, btnline8, btnline9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lift_1);

        //xml버튼들 객체연결
        btnline1 = findViewById(R.id.btnline1);
        btnline2 = findViewById(R.id.btnline2);
        btnline3 = findViewById(R.id.btnline3);
        btnline4 = findViewById(R.id.btnline4);
        btnline5 = findViewById(R.id.btnline5);
        btnline6 = findViewById(R.id.btnline6);
        btnline7 = findViewById(R.id.btnline7);
        btnline8 = findViewById(R.id.btnline8);
        btnline9 = findViewById(R.id.btnline9);

        Intent intentline1 = new Intent(this, line1Activity.class);
        Intent intentline2 = new Intent(this, line2Activity.class);
        Intent intentline3 = new Intent(this, line3Activity.class);
        Intent intentline4 = new Intent(this, line4Activity.class);
        Intent intentline5 = new Intent(this, line5Activity.class);
        Intent intentline6 = new Intent(this, line6Activity.class);
        Intent intentline7 = new Intent(this, line7Activity.class);
        Intent intentline8 = new Intent(this, line8Activity.class);
        Intent intentline9 = new Intent(this, line9Activity.class);

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
        btnline5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline5);
            }
        });
        btnline6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline6);
            }
        });
        btnline7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline7);
            }
        });
        btnline8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline8);
            }
        });
        btnline9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline9);
            }
        });

        intentMain = new Intent(this, MainActivity.class);

    }
    @Override
    public void onBackPressed() {
        startActivity(intentMain);
        finish();
    }
}

