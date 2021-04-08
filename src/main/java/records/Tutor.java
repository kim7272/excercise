package records;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tutor {

    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();


    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getTaughtSubjects() {
        return taughtSubjects;
    }

    public boolean tutorTeachingSubject(Subject value){
        for (Subject subject : taughtSubjects){
            if (subject.getSubjectName().equals(value.getSubjectName())){
                return true;
            }
        }
            return false;
    }

    public static void main(String[] args) {

        Tutor tutor = new Tutor("Nagy Csilla", Arrays.asList(new Subject("matematika"), new Subject("fizika")));

        System.out.println(tutor.tutorTeachingSubject(new Subject("matematika")));
    }
}
