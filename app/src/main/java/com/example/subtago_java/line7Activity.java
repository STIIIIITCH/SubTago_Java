package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line7Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine7Result, textStation7Result, textLocation7Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line2layout);

        //xml객체 연결
        textLine7Result = findViewById(R.id.textLine7Result);
        textStation7Result = findViewById(R.id.textStation7Result);
        textLocation7Result = findViewById(R.id.textLocation7Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','가산디지털단지','지하 W/L-5')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','가산디지털단지','지하 #2,3번 출구계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','가산디지털단지','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','가산디지털단지','지상환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','강남구청','지하 휠체어-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','건대입구','지하 장암방면')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','건대입구','지하 온수방향')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','건대입구','5번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','건대입구','지하 병원연결-2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','건대입구','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','고속터미널','지하 휠체어-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','고속터미널','지하 휠체어-06')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','고속터미널','지하 휠체어-07')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','고속터니널','지하 휠체어-08')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','고속터미널','지하 승강장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-4')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-5')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-6')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-7')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','6번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-9')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','4번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','남구로','지하 W/L-11')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','논현','지하 휄치어-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','대림(구로구청)','지상환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','마들','지하 1-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','반포','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','수락산','지하 도봉산방향')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','수락산','지하 온수방향')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','어린이대공원','정보없음')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','온수(성공회대입구)','지하 W/L-8')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','온수(성공회대입구)','지하 W/L-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','온수(성공회대입구)','지상환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','온수(성공회대입구)','지상환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','온수(성공회대입구)','지상환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','청담','지하 휠체어-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','청담','지하 휠체어-4')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','총신대입구','지하 W/L-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','총신대입구','지하 W/L-2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','총신대입구','지하 W/L-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('7호선','총신대입구','지하 W/L-4')");


        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '7호선'", null);


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
        textLine7Result.setText(strLines);
        textStation7Result.setText(strStations);
        textLocation7Result.setText(strLocations);

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
