 package activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activities {

    private List<Activity> activities = new ArrayList<>();
    ActivityType[] activityTypeParts = ActivityType.values();

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public int numberOfTrackActivities() {
        int counter = 0;
        for (Activity activity : activities){
                if (activity.getType().ordinal() == 0 ||  activity.getType().ordinal() == 1 || activity.getType().ordinal() == 2){
                    counter = counter + 1;
                }
            }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;
        for (Activity activity : activities){
            if (activity.getType().ordinal() == 3){
                counter = counter + 1;
            }
        }
        return counter;
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        double distance = 0.0;
        for (ActivityType activityType : activityTypeParts){
            for (Activity activity : activities){
                if (activity.getType().equals(activityType)){
                    distance = distance + activity.getDistance();
                }
            }
            reports.add(new Report(activityType, distance));
        }
        return reports;
    }


    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void main(String[] args) {
        Track track = new Track();

        Activities activities = new Activities(Arrays.asList(
                new ActivityWithTrack(ActivityType.RUNNING, track),
                new ActivityWithoutTrack(ActivityType.BASKETBALL),
                new ActivityWithTrack(ActivityType.RUNNING, track)));

        System.out.println(activities.numberOfTrackActivities());
    }
}

