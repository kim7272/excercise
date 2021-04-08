package activity;


import java.util.ArrayList;
import java.util.List;

public class Track {

    private List<TrackPoint> trackPoints = new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint){
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate(){
        double maxLatitude = Double.MIN_VALUE;
        double maxLongitude = Double.MIN_VALUE;
        Coordinate result = null;
        for (TrackPoint point : trackPoints){
            if (point.getCoordinate().getLatitude() > maxLatitude){
                maxLatitude = point.getCoordinate().getLatitude();
            }
            if (point.getCoordinate().getLongitude() > maxLongitude){
                maxLongitude = point.getCoordinate().getLongitude();
            }
        }
        result = new Coordinate(maxLatitude, maxLongitude);
        return result;
    }

    public Coordinate findMinimumCoordinate(){
        double minLatitude = Double.MAX_VALUE;
        double minLongitude = Double.MAX_VALUE;
        Coordinate result = null;
        for (TrackPoint point : trackPoints){
            if (point.getCoordinate().getLatitude() < minLatitude){
                minLatitude = point.getCoordinate().getLatitude();
            }
            if (point.getCoordinate().getLongitude() < minLongitude){
               minLongitude = point.getCoordinate().getLongitude();
            }
        }
        result = new Coordinate(minLatitude, minLongitude);
        return result;
    }

    public double getDistance(){
        double distance = 0.0;
        for (int i = 1; i < trackPoints.size(); i++){
           distance = distance + trackPoints.get(i).getDistanceFrom(trackPoints.get(i-1));
        }
        return distance;
    }

    public double getFullDecrease(){
        double decrease = 0.0;
        for (int i = 1; i < trackPoints.size(); i++){
            if (trackPoints.get(i).getElevation() < trackPoints.get(i-1).getElevation()){
                decrease = decrease + trackPoints.get(i-1).getElevation() - trackPoints.get(i).getElevation();
            }
        }
        return decrease;
    }

    public double getFullElevation(){
        double increase = 0.0;
        for (int i = 1; i < trackPoints.size(); i++){
            if (trackPoints.get(i).getElevation() > trackPoints.get(i-1).getElevation()){
                increase = increase + trackPoints.get(i).getElevation() - trackPoints.get(i-1).getElevation();
            }
        }
        return increase;
    }

 /*  public double getRectangleArea(){
        double totalDistance = trackPoints.get(0).getDistanceFrom(trackPoints.get(trackPoints.size()-1));
        double totalElevation = trackPoints.get(0).getElevation() + getFullElevation() - getFullDecrease();

        return totalDistance * totalElevation;
    }

  */

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
