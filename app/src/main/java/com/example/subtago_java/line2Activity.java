package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line2Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine2Result, textStation2Result, textLocation2Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line2layout);

        //xml객체 연결
        textLine2Result = findViewById(R.id.textLine2Result);
        textStation2Result = findViewById(R.id.textStation2Result);
        textLocation2Result = findViewById(R.id.textLocation2Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','건대입구','외선승강장 종점측')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','삼성','코엑스측 연결제단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','성수','외선승강장 시점측')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','성수','내선승강장 시점측')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','신당','4번 출입구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','왕십리','6번 출입구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','잠실','상가측 연결계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('2호선','한양대','섬식(외)3-3')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '2호선'", null);


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
        textLine2Result.setText(strLines);
        textStation2Result.setText(strStations);
        textLocation2Result.setText(strLocations);

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