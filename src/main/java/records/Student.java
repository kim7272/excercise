package records;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Mark> marks = new ArrayList<>();

    public Student(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    @Override
    public String toString() {
        Mark mark = marks.get(marks.size() - 1);
        return name + " marks: " + mark.getSubject().getSubjectName() + ": " + mark.toString();
    }

    public double calculateAverage() {
        int counter = 0;
        double sum = 0.0;
        double result = 0.0;

        double scale = Math.pow(10, 2);
        try {
            for (Mark mark : marks) {
                sum = sum + (double) mark.getMarkType().getValue();
                counter = counter + 1;
            }
            result = sum / counter;
            return Math.round(result * scale) / scale;
        } catch (NullPointerException npe) {
            return 0.0;
        }
    }


    public double calculateSubjectAverage(Subject value) {
        int counter = 0;
        double sum = 0.0;
        double result = 0.0;

        double scale = Math.pow(10, 2);
        try {
            for (Mark mark : marks) {
                if (mark.getSubject().getSubjectName().equals(value.getSubjectName())) {
                    sum = sum + (double) mark.getMarkType().getValue();
                    counter = counter + 1;
                }
                result = sum / counter;
            }
            return Math.round(result * scale) / scale;
        } catch (NullPointerException npe) {
            return 0.0;
        }
    }
}




   /* public boolean isEmpty(String word){

    }

    */




