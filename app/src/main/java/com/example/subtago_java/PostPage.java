package com.example.subtago_java;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostPage extends AppCompatActivity {

    Intent intentMain;
    TextView textTitleResult;
    Button btnPostInsert;

    MainActivity.myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postpage);

        btnPostInsert = findViewById(R.id.btnPostInsert);
        Intent intentpostinsert = new Intent(this, PostInsert.class );

        btnPostInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentpostinsert);
                finish();
            }
        });

        textTitleResult = findViewById(R.id.textTitleResult);
        Intent intentpostcontext = new Intent(this, PostInsert.class);
        textTitleResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentpostcontext);
                finish();
            }
        });
    }

}
