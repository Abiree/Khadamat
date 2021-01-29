package com.example.khadamat;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.IOException;
import java.util.List;

public class ServiceDetail extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    SupportMapFragment mapFragment;
    String name,adr,description,ville,localisation;
    TextView serviceName,serviceDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_detail);

        mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.google_map);
        Bundle extra = getIntent().getExtras();
        name = extra.getString("nameService");
        description= extra.getString("nameDescription");
        ville = extra.getString("ville");
        adr = extra.getString("localisation");
        serviceName=(TextView)findViewById(R.id.ServiceName);
        serviceDescription=(TextView)findViewById(R.id.Description);
        serviceName.setText(name);
        serviceDescription.setText(description);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        localisation = ville+" "+adr;
        List<Address> addressList = null;
        if(localisation != null || !localisation.equals(""))
        {
            Geocoder geocoder = new Geocoder(ServiceDetail.this);
            try {
                addressList=geocoder.getFromLocationName(localisation,1);
            }catch (IOException e){
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
            map.addMarker(new MarkerOptions().position(latLng).title(adr));
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}