package ca.aagavin.android.lbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Map;

import ca.aagavin.android.lbs.util.CustomListAdapter;
import ca.aagavin.android.lbs.util.LatLong;
import ca.aagavin.android.lbs.util.Resturants;

public class RestaurantListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Map<String, Object[]> _mapselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        Bundle extras = getIntent().getExtras();
        String selectedCusine = extras.getString("cusine");

        _mapselected = Resturants.getResturantsByCusineType(selectedCusine);

        CustomListAdapter customListAdapter = new CustomListAdapter(
                this,
                (String[]) _mapselected.get("titles"),
                (String[]) _mapselected.get("addresses"),
                (Integer[]) _mapselected.get("images")
        );

        ListView _listView = (ListView) findViewById(R.id.listview);
        _listView.setAdapter(customListAdapter);
        _listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        LatLong[] latLongArray = (LatLong[]) this._mapselected.get("longlats");
        String title = ((String[]) _mapselected.get("titles"))[i];
        LatLong latLong = latLongArray[i];

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Lat", latLong.getLatitude());
        intent.putExtra("Long", latLong.getLongitude());
        intent.putExtra("markerName", title);
        startActivity(intent);
    }
}
