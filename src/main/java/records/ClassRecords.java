package records;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public double calculateClassAverage() {
        double result = 0.0;
        int counter = 0;
        if (students.isEmpty()){
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        for (Student student : students) {
            if (student.calculateAverage() != 0.0) {
                result = result + student.calculateAverage();
                counter = counter + 1;
            }
        }
        if (result == 0.0){
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        return result / counter;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double result = 0.0;
        int counter = 0;
        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) != 0.0) {
                result = result + student.calculateSubjectAverage(subject);
                counter = counter + 1;
            }
        }
        return result / counter;
    }

    public Student findStudentByName(String name) {
        Student result = null;
        if (name == ""){
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.isEmpty()){
            throw new IllegalStateException("No students to search!");
        }

        for (Student student : students){
            if (student.getName().equals(name)){
                result = student;
            }
        }
        if (result == null){
            throw new IllegalArgumentException("Student by this name cannot be found! " + name);
        }
        return result;
    }

    public Student repetition() {
        if (students.isEmpty()){
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(random.nextInt(students.size()));
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> result = new ArrayList<>();
        for (Student student : students) {
            result.add(new StudyResultByName(student.getName(), student.calculateAverage()));
        }
        return result;
    }

    public String listStudentNames() {
        StringBuilder sb = new StringBuilder();
        String result = "";
        for (Student student : students){
            sb.append(student.getName() + ", ");
        }
        result = sb.toString();
        result = result.substring(0,result.length()-2);
        return result;
    }

    public boolean addStudent(Student newStudent) {
        for (Student student : students){
            if (student.getName().equals(newStudent.getName())){
                return false;
            }
        }
        students.add(newStudent);
        return true;
    }

    public boolean removeStudent(Student studentRem){
        Student studentDel = null;
        for (Student student : students){
            if (student.getName().equals(studentRem.getName())){
                studentDel = studentRem;
            }
        }
        if (studentDel == null){
            return false;
        }
        students.remove(studentDel);
        return true;
    }

    public static void main(String[] args) {
        ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");


        System.out.println(classRecords.listStudentNames());
    }
}

