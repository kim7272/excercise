package records;

public class StudyResultByName {

    private String name;
    private double studyAverage;

    public StudyResultByName(String name, double studyAverage) {
        this.name = name;
        this.studyAverage = studyAverage;
    }

    public String getStudentName() {
        return name;
    }

    public double getStudyAverage() {
        return studyAverage;
    }
}
