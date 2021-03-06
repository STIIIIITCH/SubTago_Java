package com.example.subtago_java;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;

    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubway = findViewById(R.id.subway);
        Button btnTransfer = findViewById(R.id.transfer);
        Button btnLift = findViewById(R.id.lift);
        Button btnConvenience = findViewById(R.id.convenience);

        ImageView imglogo = findViewById(R.id.logo);

        Intent intentSubway = new Intent(this, SubwayActivity.class);
        Intent intentTransfer = new Intent(this, kakaoMapActivity.class);
        Intent intentLift = new Intent(this, LiftActivity.class);
        Intent intentConvenience = new Intent(this, ConvenienceActivity.class);
        Intent intentImgLogo = new Intent(this, PostPage.class);

        myHelper = new myDBHelper(this);

        imglogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentImgLogo);
                finish();
            }
        });

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

        sqlDB = myHelper.getWritableDatabase();
        sqlDB = myHelper.getReadableDatabase();
        myHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();

        onBackPressed();

    }

    //DB??? ???????????? ??????????????? DB????????? ??????
    public static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "WheelChairDB", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            //WheelChairTBL????????? ?????????????????? lineName, stationName, Location ????????? ???????????????
            db.execSQL("CREATE TABLE WheelChairTBL (lineName CHAR(10), stationName CHAR(20), Location CHAR(50));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //???????????? ???????????? ???????????? ????????? ?????? ???????????????.
            db.execSQL("DROP TABLE IF EXISTS WheelChairTBL");
            onCreate(db);
        }
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