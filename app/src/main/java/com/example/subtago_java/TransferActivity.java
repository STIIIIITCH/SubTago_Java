package com.example.subtago_java;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class TransferActivity extends AppCompatActivity {
    Intent intentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakaomap_1);

        intentMain = new Intent(this, MainActivity.class);

    }
    @Override
    public void onBackPressed() {
        startActivity(intentMain);
        finish();
    }
}
