package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line3Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine3Result, textStation3Result, textLocation3Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line3layout);

        //xml객체 연결
        textLine3Result = findViewById(R.id.textLine3Result);
        textStation3Result = findViewById(R.id.textStation3Result);
        textLocation3Result = findViewById(R.id.textLocation3Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','고속터미널','2층 대합실 중앙')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','교대','B1층 2,3호선 연결계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','옥수','상선종점 D계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','옥수','하선종점 E계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','종로3가','7번 출입구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','종로3가','을지3가측 2-3층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('3호선','종로3가','을지3가측 1-2층')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '3호선'", null);


        //노선명과 역명, 위치를 나타내 줄 문자열 선언
        String strLines = "노선명" + "\n\n" + "-------" + "\n\n";
        String strStations = "역명" + "\n\n" + "-------" + "\n\n";
        String strLocations = "위치" + "\n\n" + "-------" + "\n\n";

        //커서가 움직이면서 현재 커서의 열 번호 데이터값을 반환해서 문자열 변수에 계속 누적한다.
        //0은 0번째열(노선명), 1은 1번째열(역명), 2는 2번째열(위치)가 된다.
        while (cursor.moveToNext()) {
            strLines += cursor.getString(0) + "\n\n";
            strStations += cursor.getString(1) + "\n\n";
            strLocations += cursor.getString(2) + "\n\n";
        }

        //출력해주기
        textLine3Result.setText(strLines);
        textStation3Result.setText(strStations);
        textLocation3Result.setText(strLocations);

        cursor.close();
        sqlDB1.close();
        sqlDB2.close();
    }

    @Override
    public void onBackPressed() {
        startActivity(intentMain);
        finish();
    }
}