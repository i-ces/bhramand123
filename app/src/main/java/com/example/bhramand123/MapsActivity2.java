package com.example.bhramand123;

import androidx.fragment.app.FragmentActivity;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng mahendracave = new LatLng(, );
    private static final LatLng batcave  = new LatLng(, );
    private static final LatLng lakeside  = new LatLng(, );

    private Marker mmahendra;
    private Marker mbat;
    private Marker mlakeside;
    private LocationManager locationManager;
    private LocationListener locationListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps3);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//


        mmahendra = mMap.addMarker(new MarkerOptions().position(mahendracave).title("Mahendra cave"));
        mmahendra.setTag(0);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mahendracave));
        mbat = mMap.addMarker(new MarkerOptions().position(batcave).title("Bat cave"));
        mmahendra.setTag(0);

        mlakeside = mMap.addMarker(new MarkerOptions().position(lakeside).title("Lakeside"));
        mmahendra.setTag(0);

    }
}
