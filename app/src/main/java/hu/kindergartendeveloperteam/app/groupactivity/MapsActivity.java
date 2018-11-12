package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.fragment.app.FragmentActivity;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Button buttonAddMarker;
    AutoCompleteTextView textIn;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        textIn = (AutoCompleteTextView)findViewById(R.id.textin);

        buttonAddMarker = (Button) findViewById(R.id.addMarker);

        buttonAddMarker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.maps_marker_item, null);
                AutoCompleteTextView textOut = (AutoCompleteTextView)addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.removeBtn);

                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }
                });
                textIn.setText("");
                container.addView(addView);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
