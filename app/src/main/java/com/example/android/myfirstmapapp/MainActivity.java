package com.example.android.myfirstmapapp;

import android.content.Context;
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
import static com.example.android.myfirstmapapp.R.id.toSeattle;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap my_map;
    boolean mapReady = false;
    LatLng seattle = new LatLng(47.6204, -122.3791);
    LatLng newyouk = new LatLng(40.7127, -74.0059);
    LatLng dublin = new LatLng(53.3478, 6.2597);

    static final CameraPosition SEATTLE = CameraPosition.builder().target(new LatLng(47.6204, -122.3791))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition NEWYORK = CameraPosition.builder().target(new LatLng(40.7127, -74.0059))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();

    static final CameraPosition DUBLIN = CameraPosition.builder().target(new LatLng(53.3478, 6.2597))
            .zoom(14)
            .bearing(0)
            .tilt(45)
            .build();

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

        Button flyToSeattle = (Button) findViewById(R.id.toSeattle);
        flyToSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CameraPosition position = CameraPosition.builder().target(seattle).zoom(14).build();
                my_map.moveCamera(CameraUpdateFactory.newCameraPosition(position));*/
                flyToTheWorld(SEATTLE);
            }
        });

        Button flyToNewYork = (Button) findViewById(R.id.toNewYork);
        flyToNewYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CameraPosition position = CameraPosition.builder().target(newyouk).zoom(14).build();
                my_map.moveCamera(CameraUpdateFactory.newCameraPosition(position));*/
                flyToTheWorld(NEWYORK);
            }
        });

        Button flyToDublin = (Button) findViewById(R.id.toDublin);
        flyToDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CameraPosition position = CameraPosition.builder().target(dublin).zoom(14).build();
                my_map.moveCamera(CameraUpdateFactory.newCameraPosition(position));*/
                flyToTheWorld(DUBLIN);
        }});

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //add a marker at home and move camera
        my_map = googleMap;
        LatLng home = new LatLng(35.107244, 128.970783);
        CameraPosition position = CameraPosition.builder().target(home).zoom(14).build();
        my_map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
    }

    public void flyToTheWorld(CameraPosition target) {
        my_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 5000, null);
    }
}
