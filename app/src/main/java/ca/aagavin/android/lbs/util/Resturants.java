package ca.aagavin.android.lbs.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ca.aagavin.android.lbs.R;

/**
 * Created by aaron on 12/19/17.
 */

public class Resturants {

    static String[] titleViewIdArray = new String[]{
        "Pizza Hut",
        "The Real McCoy",
        "Johnny's Greek Hamburgers",

        "Milestones Grill and Bar",

        "AllStar Wings & Ribs",
        "Chris Jerk",
        "Federick Restaurant",

        "Rawlicious Whitby",
        "DQ Grill & Chill Restaurant",
        "Topper's Pizza Whitby",
    };

    // set address array
    static String[] addressViewIdArray = new String[]{
        "3351 Lawrence Ave E, Scarborough, ON M1H 1A8",
        "1033 Markham Rd, Scarborough, ON M1H 2G1",
        "2595 Victoria Park Ave, Scarborough, ON M1T 1A4",
        "300 Borough Dr, Scarborough, ON M1P 4P5",
        "1245 McCowan Rd #1, Scarborough, ON M1H 3K3",
        "2570 Birchmount Rd, Scarborough, ON M1T 2M5",
        "1920 Ellesmere Rd, Scarborough, ON M1H 2V6",
        "120 Dundas St W, Whitby, ON L1N 2L9",
        "3975 Garden St #3, Whitby, ON L1R 3A4",
        "3500 Brock St N, Whitby, ON L1R 3J4"
    };

    // set images array
    static Integer[] imageViewIdArray = new Integer[] {
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder,
        R.drawable.placeholder
    };

    // set long lat array
    static LatLong[] LatLongArray = new LatLong[]{
        new LatLong(43.7740451, -79.2636021),
        new LatLong(43.7635487, -79.2946119),
        new LatLong(43.7740644, -79.2325777),
        new LatLong(43.7769881, -79.254876),
        new LatLong(43.7744804, -79.2546924),
        new LatLong(43.7896673, -79.3026652),
        new LatLong(43.7975853,-79.196296),
        new LatLong(43.8920513,-78.9356605),
        new LatLong(43.9085021,-78.9383213),
        new LatLong(43.9085021,-78.9383213)


    };


    public static Map<String, Object[]> getResturantsByCusineType(String cusineType){

        Map<String, Object[]> map = new HashMap<>();

        switch (cusineType){
            case "Greek":
                map.put("titles", Arrays.copyOfRange(titleViewIdArray, 0,3));
                map.put("addresses", Arrays.copyOfRange(addressViewIdArray, 0,3));
                map.put("images",  Arrays.copyOfRange(imageViewIdArray, 0,3));
                map.put("longlats", Arrays.copyOfRange(LatLongArray, 0,3));
                break;
            case "Italian":
                map.put("titles", Arrays.copyOfRange(titleViewIdArray, 4,7));
                map.put("addresses", Arrays.copyOfRange(addressViewIdArray, 4,7));
                map.put("images",  Arrays.copyOfRange(imageViewIdArray, 4,7));
                map.put("longlats", Arrays.copyOfRange(LatLongArray, 4,7));
                break;
            case "Fast Food":
                map.put("titles", Arrays.copyOfRange(titleViewIdArray, 8,10));
                map.put("addresses", Arrays.copyOfRange(addressViewIdArray, 8,10));
                map.put("images",  Arrays.copyOfRange(imageViewIdArray, 8,10));
                map.put("longlats", Arrays.copyOfRange(LatLongArray, 8,10));
                break;
            default:
                break;
        }

        return map;
    }
}
