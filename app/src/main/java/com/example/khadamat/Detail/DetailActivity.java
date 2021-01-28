package com.example.khadamat.Detail;


import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.example.khadamat.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class DetailActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.google_map);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}