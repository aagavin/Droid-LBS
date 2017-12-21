package ca.aagavin.android.lbs;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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


        RadioGroup rg = (RadioGroup) findViewById(R.id.RG);

         RadioButton rbNormal = (RadioButton) findViewById(R.id.radioNormal);
         RadioButton rbSatellite = (RadioButton) findViewById(R.id.radioSatellite);
        RadioButton rbTerrain = (RadioButton) findViewById(R.id.radioTerrain);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioNormal){
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                }
                if(i == R.id.radioSatellite){
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
                if(i == R.id.radioTerrain){
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                }


            }
        });

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
        LatLng sydney = new LatLng(this._lat, this._long);

        //set map type to satellite
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.resetMinMaxZoomPreference();
        mMap.setMinZoomPreference(5f);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
