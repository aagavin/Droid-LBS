package ca.aagavin.android.lbs.util;

public class LatLong {

    private double latitude;
    private double longitude;


    LatLong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
