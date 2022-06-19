package com.example.subtago_java;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class kakaoMapActivity extends AppCompatActivity {
    Intent intentMain;
    MapView mapView;
    String provider;
    double longitude;
    double latitude;
    double altitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kakaomap_1);

/*        // 위치 권한 요청 코드
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);


        if (permissionCheck == PackageManager.PERMISSION_DENIED) { //포그라운드 위치 권한 확인
            //위치 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }

        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION);

        if (permissionCheck == PackageManager.PERMISSION_DENIED) { //백그라운드 위치 권한 확인
            //위치 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION}, 0);
        }

        mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.mapView);
        mapViewContainer.addView(mapView);

        final LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // 위치정보를 원하는 시간, 거리마다 갱신
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000,
                1,
                gpsLocationListener);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                1000,
                1,
                gpsLocationListener);

//        MapPOIItem marker = new MapPOIItem();
//        MapPoint nowPosition = MapPoint.mapPointWithGeoCoord(latitude, longitude);
//        marker.setCustomImageResourceId(R.drawable.pin);
//        marker.setItemName("현위치");
//        marker.setMapPoint(nowPosition);
//        marker.setCustomImageAnchor(0.5f, 0.5f);
//        mapView.addPOIItem(marker);
//        mapView.selectPOIItem(marker, true);
//        mapView.setMapCenterPoint(nowPosition, false);

//        mapView.setMapViewEventListener(this);
////        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading);

        Button btn = findViewById(R.id.btn_now);
        btn.setOnClickListener(myLocation);

        intentMain = new Intent(this, MainActivity.class);
    }

    View.OnClickListener myLocation = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(kakaoMapActivity.this, "불러옵니다.", Toast.LENGTH_SHORT).show();
            mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(latitude, longitude), true);

        }
    };

    final LocationListener gpsLocationListener = new LocationListener() {
        public void onLocationChanged(Location location) {

            provider = location.getProvider();
            longitude = location.getLongitude();
            latitude = location.getLatitude();
            altitude = location.getAltitude();

        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onProviderDisabled(String provider) {
        }
    };

        @Override
        public void onBackPressed () {
            startActivity(intentMain);
            finish();
        }*/
    }
}
