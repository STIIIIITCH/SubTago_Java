package com.example.subtago_java;


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
    GestureDetectorCompat gestureDetector;
    SubsamplingScaleImageView imageView;
    private static final String TAG = "클릭 좌표";
    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway_1);

/*        AutoCompleteTextView auto = findViewById(R.id.start_station);

        String[] items = {"안양", "수원", "서울역", "군포"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);

        auto.setAdapter(adapter);*/

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

        c = myDbHelper.query("seoulSubwayMap", null, null, null, null, null, null); // SQLDataRead


        imageView = findViewById(R.id.subwayImage); // 지하철역 고해상도 이미지뷰
        imageView.setImage(ImageSource.resource(R.drawable.smap_sg_all));
        imageView.setOnTouchListener(touchListener);
        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
        imageView.setMaximumDpi(900);
//        imageView.setScaleAndCenter(2f, new PointF(1698, 2571)); // 안양역



//        float[] values = new float[9];
//        matrix.getValues(values);
//        // values[2] and values[5] are the x,y coordinates of the top left corner of the drawable image, regardless of the zoom factor.
//        // values[0] and values[4] are the zoom factors for the image's width and height respectively. If you zoom at the same factor, these should both be the same value.
//
//        // event is the touch event for MotionEvent.ACTION_UP
//        float relativeX = (event.getX() - values[2]) / values[0];
//        float relativeY = (event.getY() - values[5]) / values[4];


        gestureDetector = new GestureDetectorCompat(this, new MyGestureListener());

    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getActionMasked()) {
                // 손으로 눌렀을 때
                case MotionEvent.ACTION_DOWN:
                    break;
                // 손을 떼었을 때
                case MotionEvent.ACTION_UP:
                    Log.d(TAG, "x 좌표 = " + x + " / y 좌표 = " + y);
                    break;
                // 누른 상태로 움직였을 때
                case MotionEvent.ACTION_MOVE:
                    break;
            }
            return gestureDetector.onTouchEvent(event);
        }
    };


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent touch) {
            if (imageView.isReady()) {
                PointF sCoord = imageView.viewToSourceCoord(touch.getX(), touch.getY());
                int x_cor = (int) sCoord.x;
                int y_cor = (int) sCoord.y;

                // Loop for finding the station.
                if (c.moveToFirst()) {
                    do {

                        if ((x_cor > c.getInt(2)) && (x_cor < c.getInt(4)) && (y_cor > c.getInt(3)) && (y_cor < c.getInt(5))) {
                            String targetStation = c.getString(1); // 유저가 클릭한 지하철역
                        } // send Station Name (column 1)
                    } while (c.moveToNext());
                }
            }
            return super.onSingleTapUp(touch);
        }
    };

}