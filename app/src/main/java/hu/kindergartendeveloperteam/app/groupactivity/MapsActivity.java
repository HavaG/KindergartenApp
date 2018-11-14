package hu.kindergartendeveloperteam.app.groupactivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    AutoCompleteTextView textIn;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);

        textIn = (AutoCompleteTextView)findViewById(R.id.textin);

        Button buttonAddMarker = (Button) findViewById(R.id.addMarker);

        container = (LinearLayout) findViewById(R.id.container);

        buttonAddMarker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onAddMarker(v);
            }
        });

        Button postBtn = (Button) findViewById(R.id.post);
        postBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO: make post and save
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]
                        {
                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.INTERNET
                        }, 10);
            }
            return;
        }
        mMap.setMyLocationEnabled(true);
        LatLng Bp = new LatLng(19.040235, 47.497912);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bp));
    }

    public void onAddMarker(View view){
        if(textIn != null && !textIn.getText().toString().equals("")) {
            boolean success = setMarker();
            if(success) {
                //add the view
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.maps_marker_item, null);
                TextView textOut = (TextView) addView.findViewById(R.id.markerName);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button) addView.findViewById(R.id.removeMarkerBtn);

                //TODO: remove also the marker
                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });
                container.addView(addView);
            }
            else {
                Toast.makeText(this, "Place not found", Toast.LENGTH_LONG).show();
            }
            textIn.setText("");
        }
    }

    public boolean setMarker(){
        //set the marker
        List<Address> addresses = null;
        String location = textIn.getText().toString();
        Geocoder geocoder = new Geocoder(this);
        try {
            addresses = geocoder.getFromLocationName(location, 5);
            if(addresses.size() != 0) {
                Address address = addresses.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
