package activity;

public final class Coordinate {

    private double latitude;
    private double longitude;

    public Coordinate(double latitude, double longitude) {
        if (latitude < -90.0 || latitude > 90.0){
            throw new IllegalArgumentException("Invalid parameter");
        }
        if (longitude < -180.0 || longitude > 180.0){
            throw new IllegalArgumentException("Invalid parameter");
        }

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
