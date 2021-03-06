package hu.kindergartendeveloperteam.app.groupactivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.KindergartenPost;
import io.swagger.client.model.Path;
import io.swagger.client.model.Post;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    AutoCompleteTextView textIn;
    LinearLayout container;
    private final int PLACE_PICKER_REQUEST = 1;
    private DefaultApi db = new DefaultApi();
    private List<Marker> markers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps_activity);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        markers = new ArrayList<>();

        textIn = findViewById(R.id.textin);

        Button buttonPlacePicker = findViewById(R.id.addMarker);

        container = findViewById(R.id.container);

        buttonPlacePicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

                try {
                    startActivityForResult(builder.build(MapsActivity.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        Button postBtn = findViewById(R.id.post);
        postBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                try {
                    int groupId = getIntent().getIntExtra(GroupChooseActivity.GROUP_ID, 0);
                    Post newPost = new Post();
                    newPost.setContent(textIn.getText().toString());

                    List<Path> path = new ArrayList<>();

                    for(int i = 0; i < markers.size(); i++){
                        Path e = new Path();
                        e.setX(markers.get(i).getPosition().latitude);
                        e.setY(markers.get(i).getPosition().longitude);
                        path.add(e);
                    }
                    newPost.setPath(path);

                    db.createPost(groupId, newPost);

                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);

                LatLng latLng = place.getLatLng();
                final Marker m = mMap.addMarker(new MarkerOptions().position(latLng).title(place.getName().toString()));
                markers.add(m);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.maps_marker_item, null);
                final TextView textOut = addView.findViewById(R.id.markerName);
                textOut.setText(place.getName().toString());
                Button buttonRemove = addView.findViewById(R.id.removeMarkerBtn);

                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        m.remove();
                        ((LinearLayout) addView.getParent()).removeView(addView);
                    }
                });
                container.addView(addView);
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
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

        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(47.49801,19.03991), 10.0f));
    }
}
