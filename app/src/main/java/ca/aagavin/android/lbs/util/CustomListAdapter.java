package ca.aagavin.android.lbs.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import ca.aagavin.android.lbs.R;

public class CustomListAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the logo images
    private final Integer[] imageViewIdArray;

    //to store the list of countries
    private final String[] titleViewIdArray;

    //to store the list of countries
    private final String[] addressViewIdArray;

    public CustomListAdapter(
        Activity context,
        String[] titleViewIdArray,
        String[] addressViewIdArray,
        Integer[] imageViewIdArray
    ) {
        super(context, R.layout.listview_row, titleViewIdArray);

        this.context = context;
        this.imageViewIdArray = imageViewIdArray;
        this.titleViewIdArray = titleViewIdArray;
        this.addressViewIdArray = addressViewIdArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView titleTextField = (TextView) rowView.findViewById(R.id.titleViewId);
        TextView addressField = (TextView) rowView.findViewById(R.id.addressViewId);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewId);

        //this code sets the values of the objects to values from the arrays
        titleTextField.setText(titleViewIdArray[position]);
        addressField.setText(addressViewIdArray[position]);
        imageView.setImageResource(imageViewIdArray[position]);

        return rowView;
    }
}
