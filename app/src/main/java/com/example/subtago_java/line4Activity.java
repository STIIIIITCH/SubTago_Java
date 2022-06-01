package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line4Activity extends AppCompatActivity {
    Intent intentMain;

    MainActivity.myDBHelper myHelper;
    TextView textLine4Result, textStation4Result, textLocation4Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line4layout);

        //xml객체 연결
        textLine4Result = findViewById(R.id.textLine4Result);
        textStation4Result = findViewById(R.id.textStation4Result);
        textLocation4Result = findViewById(R.id.textLocation4Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','동대문','1,4호선(환승통로)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','명동','B2-B3 대합실')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','명동','B1-B2 대합실')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','사당','승강장 X-32')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','상계','상행 3-1')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','상계','하행 8-3')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','서울역','9-1번 출구교통섬')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','신용산','2번 출입구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','이촌','정보없음')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','상선승강장,C계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','하선승강장,D계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','1호선 연결통로(2번출구)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','1호선 상선측 승강장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','1호선 하선측 승각장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','창동','1호선 연결통로(1번출구)')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','충무로','3호선 승강장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('4호선','회현','5번 출입구')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '4호선'", null);


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
        textLine4Result.setText(strLines);
        textStation4Result.setText(strStations);
        textLocation4Result.setText(strLocations);

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
