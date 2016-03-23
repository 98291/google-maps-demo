package com.main.mapdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final LatLng PITTSBURGH_LOC = new LatLng(40.4443963, -79.944846);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMap();
    }

    private void displayMap() {
        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mMap = mf.getMap();
        mf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PITTSBURGH_LOC, 15));
    }

}
