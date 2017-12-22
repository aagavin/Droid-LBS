package ca.aagavin.android.lbs;

import android.os.Bundle;
import android.support.v4.*;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, RadioGroup.OnCheckedChangeListener {

    private GoogleMap mMap;
    private String _markerName;

    private double _lat;
    private double _long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        Bundle extras = getIntent().getExtras();
        this._lat = extras.getDouble("Lat");
        this._long = extras.getDouble("Long");

        setTitle(extras.getString("markerName"));

        RadioGroup rg = (RadioGroup) findViewById(R.id.RG);
        rg.setOnCheckedChangeListener(this);

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

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(this._lat, this._long);

        //set map type to digital map
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Move the camera instantly to location with a zoom of 20.
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 20f));

        // Zoom in, animating the camera.
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);
        mMap.addMarker(new MarkerOptions().position(location).title(this._markerName));

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        switch (i){
            case R.id.radioSatellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.radioTerrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            default:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
        }


    }
}
