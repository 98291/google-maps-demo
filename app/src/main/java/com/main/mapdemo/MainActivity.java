package com.main.mapdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap
        .OnMarkerClickListener {

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
        int duration = 2000;
        int initialZoom = 10;
        int finalZoom = 15;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PITTSBURGH_LOC, initialZoom));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(finalZoom), duration, null);
        mMap.setMyLocationEnabled(true);
        mMap.setOnMarkerClickListener(this);

        displayMarkers();
    }

    private void displayMarkers() {
        LatLng[] MOCK_DATA = new LatLng[]{new LatLng(40.4443963, -79.944846),
                new LatLng(40.4428963, -79.941846), new LatLng(40.4435963, -79.945846)};

        for (LatLng ll : MOCK_DATA) {
            mMap.addMarker(new MarkerOptions().position(ll));
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this, "Dope", Toast.LENGTH_SHORT).show();
        return false;
    }

}
