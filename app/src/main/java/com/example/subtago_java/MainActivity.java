package com.example.subtago_java;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubway = findViewById(R.id.subway);
        Button btnTransfer = findViewById(R.id.transfer);
        Button btnLift = findViewById(R.id.lift);
        Button btnConvenience = findViewById(R.id.convenience);

        Intent intentSubway = new Intent(this, SubwayActivity.class);
        Intent intentTransfer = new Intent(this, TransferActivity.class);
        Intent intentLift = new Intent(this, LiftActivity.class);
        Intent intentConvenience = new Intent(this, ConvenienceActivity.class);

        btnSubway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentSubway);
                finish();
            }
        });

        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentTransfer);
                finish();
            }
        });

        btnLift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentLift);
                finish();
            }
        });

        btnConvenience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentConvenience);
                finish();
            }
        });

        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }
}