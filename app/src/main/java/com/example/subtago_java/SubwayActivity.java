package com.example.subtago_java;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.IOException;

public class SubwayActivity extends AppCompatActivity {
    SubsamplingScaleImageView imageView;
    private static final String TAG = "* 클릭 좌표";
    Cursor c = null;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway_1);

        seoulSubwayMap myDbHelper = new seoulSubwayMap(SubwayActivity.this); // Reading SQLite database.
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }

        imageView = findViewById(R.id.subwayImage); // 지하철역 고해상도 이미지뷰
        imageView.setImage(ImageSource.resource(R.drawable.smap_sg_all));
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        imageView.setMaximumDpi(1100);
        imageView.setMinimumDpi(300);

        GestureDetector gestureDetector = getGestureDetector(imageView);
        imageView.setOnTouchListener((v, event) -> {
            gestureDetector.onTouchEvent(event);
            return false;
        });

    }

    private GestureDetector getGestureDetector(SubsamplingScaleImageView subsamplingScaleImageView)
    {

        GestureDetector gestureDetector;


        seoulSubwayMap myDbHelper = new seoulSubwayMap(this); // Reading SQLite database.
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        finally {
            myDbHelper.openDataBase();

            Cursor c = myDbHelper.query("seoulSubwayMap", null, null, null, null, null, null); // SQLDataRead
            gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // gesture 디텍팅으로 지하철 위치 읽기
                @Override
                public boolean onSingleTapUp(MotionEvent event) {

                    Log.d("# 픽셀 좌표 테스트 #", "onSingleTapUp");
                    if(subsamplingScaleImageView.isReady())
                    {
                        PointF sCoord = subsamplingScaleImageView.viewToSourceCoord(event.getX(), event.getY());
                        int x_cor = (int) sCoord.x;
                        int y_cor = (int) sCoord.y;

                        Log.d("# 픽셀좌표 테스트 1 >> ", "x_cor : " + x_cor +", y_cor : " +y_cor + ", event.x : " +event.getX() + ", event.getY : " + event.getY() );

                        // Loop for finding the station.
                        if (c.moveToFirst()) {
                            do {

                                if ((x_cor > c.getInt(2)) && (x_cor < c.getInt(4)) && (y_cor > c.getInt(3)) && (y_cor < c.getInt(5))) {
                                    String targetStation = c.getString(1); // 좌표를 통해 얻은 유저가 클릭한 지하철역
                                    Log.d("# 픽셀좌표 테스트 2 >> ", "targetStation : " + targetStation);

                                } // send Station Name (column 1)
                            } while (c.moveToNext());
                        }

                    }
                    return super.onSingleTapUp(event);
                }
            });

        }
        return gestureDetector;
    }
}