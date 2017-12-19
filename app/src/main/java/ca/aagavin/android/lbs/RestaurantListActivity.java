package ca.aagavin.android.lbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import ca.aagavin.android.lbs.util.CustomListAdapter;
import ca.aagavin.android.lbs.util.LatLong;

public class RestaurantListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    public String[] titleViewIdArray;
    public String[] addressViewIdArray;
    public Integer[] imageViewIdArray;

    private LatLong[] _LatLongArray;

    private ListView _listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        this._setArrays();
        CustomListAdapter customListAdapter = new CustomListAdapter(
                this,
                titleViewIdArray,
                addressViewIdArray,
                imageViewIdArray
        );

        this._listView = (ListView) findViewById(R.id.listview);
        this._listView.setAdapter(customListAdapter);
        this._listView.setOnItemClickListener(this);

    }

    private void _setArrays() {
        // set title array
        this.titleViewIdArray = new String[]{
            "Pizza Hut",
            "The Real McCoy",
            "Johnny's Hamburgers",
            "Milestones Grill and Bar",
            "AllStar Wings & Ribs",
            "Chris Jerk"
        };

        // set address array
        this.addressViewIdArray = new String[]{
            "3351 Lawrence Ave E, Scarborough, ON M1H 1A8",
            "1033 Markham Rd, Scarborough, ON M1H 2G1",
            "2595 Victoria Park Ave, Scarborough, ON M1T 1A4",
            "300 Borough Dr, Scarborough, ON M1P 4P5",
            "1245 McCowan Rd #1, Scarborough, ON M1H 3K3",
            "2570 Birchmount Rd, Scarborough, ON M1T 2M5"
        };

        // set images array
        this.imageViewIdArray = new Integer[] {
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder,
            R.drawable.placeholder,
        };

        // set long lat array
        this._LatLongArray = new LatLong[]{
            new LatLong(43.7740451, -79.2636021),
            new LatLong(43.7635487, -79.2946119),
            new LatLong(43.7740644, -79.2325777),
            new LatLong(43.7769881, -79.254876),
            new LatLong(43.7744804, -79.2546924),
            new LatLong(43.7896673, -79.3026652)
        };


    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        LatLong latLong = this._LatLongArray[i];
        Toast.makeText(this, "Clicked: " + i + " | lat: " + latLong.getLatitude() + ", long: " + latLong.getLongitude(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Lat", latLong.getLatitude());
        intent.putExtra("Long", latLong.getLongitude());
        startActivity(intent);
    }
}
