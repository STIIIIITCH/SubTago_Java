package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line5Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine5Result, textStation5Result, textLocation5Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line5layout);

        //xml객체 연결
        textLine5Result = findViewById(R.id.textLine5Result);
        textStation5Result = findViewById(R.id.textStation5Result);
        textLocation5Result = findViewById(R.id.textLocation5Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','강동','지하 상선승강장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','강동','지하 대합실')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','광나루(장신대)','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','광나루(세종문화회관)','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','광나루(세종문화회관)','지하 종점')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','광나루(세종문화회관)','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','광나루(세종문화회관)','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','까치산','지하 상선B5-B4')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','까치산','지하 하선B5-B4')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','까치산','2번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','답십리','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','동대문역사문화공원','지하 승강장#1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','동대문역사문화공원','6번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','마장','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','마장','1번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','마천','지하 B4-B2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','마천','지하 1-13')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','마천','1번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','상일동','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','상일동','4번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','서대문','지하 5,6번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','신길','지하 상선승환통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','신길','지하 환승통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','영등포구청','지하 상선승환통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','영등포구청','지하 환승통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','장한평','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('5호선','종로3가(탑골공원)','지하')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '5호선'", null);


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
        textLine5Result.setText(strLines);
        textStation5Result.setText(strStations);
        textLocation5Result.setText(strLocations);

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
