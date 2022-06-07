package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line8Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine8Result, textStation8Result, textLocation8Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line8layout);

        //xml객체 연결
        textLine8Result = findViewById(R.id.textLine8Result);
        textStation8Result = findViewById(R.id.textStation8Result);
        textLocation8Result = findViewById(R.id.textLocation8Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','남한산성입구','4번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','남한산성입구','지하 4번출구-2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','모란','지하 환승수진측')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','모란','지하 환승복정측')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','복정','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','수진','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','잠실(송파구청)','지하 1-5')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','잠실(송파구청)','지하 1-6')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','잠실(송파구청)','지하 1-7')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','천호(풍납토성)','지하 1-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','천호(풍납토성)','지하 1-2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','천호(풍납토성)','지하 1-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('8호선','천호(풍납토성)','지하 1-4')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '8호선'", null);


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
        textLine8Result.setText(strLines);
        textStation8Result.setText(strStations);
        textLocation8Result.setText(strLocations);

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