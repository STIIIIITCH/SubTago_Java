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
    SubsamplingScaleImageView imageView;
    private static final String TAG = "* 클릭 좌표";
    Cursor c = null;

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

        c = myDbHelper.query("seoulSubwayMap", null, null, null, null, null, null); // SQLDataRead


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



//        float[] values = new float[9];
//        matrix.getValues(values);
//        // values[2] and values[5] are the x,y coordinates of the top left corner of the drawable image, regardless of the zoom factor.
//        // values[0] and values[4] are the zoom factors for the image's width and height respectively. If you zoom at the same factor, these should both be the same value.
//
//        // event is the touch event for MotionEvent.ACTION_UP
//        float relativeX = (event.getX() - values[2]) / values[0];
//        float relativeY = (event.getY() - values[5]) / values[4];


//        gestureDetector = new GestureDetectorCompat(this, new MyGestureListener());



    }


/*    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent touch) {
            if (imageView.isReady()) {
                PointF sCoord = imageView.viewToSourceCoord(touch.getX(), touch.getY());
                int x_cor = (int) sCoord.x;
                int y_cor = (int) sCoord.y;

                // Loop for finding the station.
                if (c.moveToFirst()) {
                    do {
                        Log.d("커서 테스트 >> ",  "커서 꺼짐 ? " + c.isClosed() + "커서 마지막인가요 ? " + c.isLast() + "커서 첫 번째인지" + String.valueOf(c.isFirst()));
                        if ((x_cor > c.getInt(2)) && (x_cor < c.getInt(4)) && (y_cor > c.getInt(3)) && (y_cor < c.getInt(5))) {
                            String targetStation = c.getString(1); // 유저가 클릭한 지하철역
                        } // send Station Name (column 1)
                    } while (c.moveToNext());
                }
            }
            return super.onSingleTapUp(touch);
        }
    };*/

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
//                                    CustomDialog customDialog = new CustomDialog(mContext, event.getX(), event.getY(),  targetStation);
//                                    customDialog.create();

/*                                    customDialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() {
                                        @Override
                                        public void onDismiss(DialogInterface dialog) {


                                            TextView tvSearchStation = findViewById(R.id.tv_serach_station);
                                            StringBuilder sb = new StringBuilder();

                                            if(StationData.startStation!=null && StationData.startLine!= null){

                                                sb.append("출발역 : ");
                                                sb.append(StationData.startStation);
                                                sb.append(" ");
                                                sb.append(StationData.startLine);
                                                sb.append("호선");
                                                sb.append("\n");
                                            }

                                            if(StationData.goalStation!=null && StationData.goalLine!= null){

                                                sb.append("도착역 : ");
                                                sb.append(StationData.goalStation);
                                                sb.append(" ");
                                                sb.append(StationData.goalLine);
                                                sb.append("호선");
                                            }


                                            tvSearchStation.setText(sb.toString());


                                        }
                                    });*/

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