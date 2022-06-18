package com.example.subtago_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class line1Activity extends AppCompatActivity {
    Intent intentMain;
    Button call1;

    MainActivity.myDBHelper myHelper;
    TextView textLine1Result, textStation1Result, textLocation1Result;
    SQLiteDatabase sqlDB1, sqlDB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.line1layout);
        call1 = findViewById(R.id.call1);

        Intent intentline = new Intent(this, call1Activity.class);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentline);
            }
        });

        //xml객체 연결
        textLine1Result = findViewById(R.id.textLine1Result);
        textStation1Result = findViewById(R.id.textStation1Result);
        textLocation1Result = findViewById(R.id.textLocation1Result);

        //DB클래스 객체 생성(이 자바클래스에선 처음이니까 또 선언함)
        myHelper = new MainActivity.myDBHelper(this);

        sqlDB1 = myHelper.getWritableDatabase();
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','서울역','내부C계단')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','신설동','1번 출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','신설동','6번 출구')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','청량리','대합실 연결통로')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','청량리','제기동측 승강장')");
        sqlDB1.execSQL("INSERT INTO WheelChairTBL VALUES ('1호선','청량리','섬식(상)8-2')");

        sqlDB2 = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB2.rawQuery("SELECT * FROM WheelChairTBL WHERE lineName = '1호선'", null);


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
        textLine1Result.setText(strLines);
        textStation1Result.setText(strStations);
        textLocation1Result.setText(strLocations);

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
