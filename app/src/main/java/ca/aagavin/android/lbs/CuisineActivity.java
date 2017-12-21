package ca.aagavin.android.lbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CuisineActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView _listView;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);

        this._listView = (ListView) findViewById(R.id.listview);
        this._listView.setOnItemClickListener(this);

    }

    /**
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectOption = (String) this._listView.getItemAtPosition(i);

        Intent intent = new Intent(this, RestaurantListActivity.class);
        intent.putExtra("cusine", selectOption);
        startActivity(intent);
    }
}
