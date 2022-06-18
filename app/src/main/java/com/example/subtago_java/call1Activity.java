package com.example.subtago_java;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class call1Activity extends AppCompatActivity {
    Intent intentMain;
    Button btncall1,btncall2,btncall3,btncall4,btncall5,btncall6,btncall7,btncall8,btncall9,btncall10,btncall11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call1layout);

        btncall1 = findViewById(R.id.a1);
        btncall2 = findViewById(R.id.a2);
        btncall3 = findViewById(R.id.a3);
        btncall4 = findViewById(R.id.a4);
        btncall5 = findViewById(R.id.a5);
        btncall6 = findViewById(R.id.a6);
        btncall7 = findViewById(R.id.a7);
        btncall8 = findViewById(R.id.a8);
        btncall9 = findViewById(R.id.a9);
        btncall10 = findViewById(R.id.a10);
        btncall11 = findViewById(R.id.a11);

        btncall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1281"));
                startActivity(intent1);
            }
        });
        btncall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1271"));
                startActivity(intent2);
            }
        });
        btncall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1331"));
                startActivity(intent3);
            }
        });
        btncall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1321"));
                startActivity(intent4);
            }
        });
        btncall5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1261"));
                startActivity(intent5);
            }
        });
        btncall6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1251"));
                startActivity(intent6);
            }
        });
        btncall7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1311"));
                startActivity(intent7);
            }
        });
        btncall8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1301"));
                startActivity(intent8);
            }
        });
        btncall9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent9 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1291"));
                startActivity(intent9);
            }
        });
        btncall10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent10 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1241"));
                startActivity(intent10);
            }
        });
        btncall11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:6110-1251"));
                startActivity(intent11);
            }
        });
    }
}
