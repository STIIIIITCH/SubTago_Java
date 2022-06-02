package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line6Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine6Result, textStation6Result, textLocation6Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line6layout);

        //xml객체 연결
        textLine6Result = findViewById(R.id.textLine6Result);
        textStation6Result = findViewById(R.id.textStation6Result);
        textLocation6Result = findViewById(R.id.textLocation6Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','공덕','지하 5,6호선 환승통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','공덕','지하 공항철도 환승통로(응암)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','공덕','지하 공항철도 환승통로(봉화산)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','광흥창(서강)','지하 4번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','구산','지하 1층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','대흥(서강대앞)','지하 내부용')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','대픙(서강대앞)','2번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','동묘앞','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','동묘앞','5번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','디지털미디어시티','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','디지털미디어시티','3번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','마포구청','지하 B2-B3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','마포구청','지하 1층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','마포구청','지하')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','마포구청','지하 외부출구#6')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','보문','1번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','보문','지하내부용')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','봉화산(서울의료원)','B1-B2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','불광','지하1층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','삼각지','지하 내부계단(승환홀)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','삼각지','7번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','상수','지하1층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','상수','4번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','상월곡','내부용')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','새절(신사)','지하 1층')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','신당','지하 6호선승환용')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','신당','지하 승환홀')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','신당','지하 2호선환승')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','신당','9번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','월곡(동덕여대)','B1-B2')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','합정','정보없음')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','효창공원앞','1번출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('6호선','효창공원앞','3번출구')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '6호선'", null);


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
        textLine6Result.setText(strLines);
        textStation6Result.setText(strStations);
        textLocation6Result.setText(strLocations);

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
