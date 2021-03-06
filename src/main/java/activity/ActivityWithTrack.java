package activity;

public class ActivityWithTrack implements  Activity {

    private ActivityType activityType;
    private Track track;

    public ActivityWithTrack(ActivityType activityType, Track track) {
        this.activityType = activityType;
        this.track = track;
    }

    @Override
    public double getDistance() {
       return track.getDistance();
    }

    @Override
    public ActivityType getType() {
        return activityType;
    }
}
