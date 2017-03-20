package com.example.android.myfirstmapapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.Map;

import static com.example.android.myfirstmapapp.R.id.map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap my_map;
    boolean mapReady = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button nomalMap = (Button) findViewById(R.id.btnMap);
        nomalMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });

        Button satelliteMap = (Button) findViewById(R.id.btnSatellite);
        satelliteMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        Button hybMap = (Button) findViewById(R.id.btnHybrid);
        hybMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                my_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //add a marker at home and move camera
        my_map = googleMap;
        LatLng home = new LatLng(35.107244, 128.970783);
        CameraPosition position = CameraPosition.builder().target(home).zoom(14).build();
        my_map.moveCamera(CameraUpdateFactory.newCameraPosition(position));


    }
}
