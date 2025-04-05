package model;
import java.io.Serializable ;

public class Course implements Serializable{
    private String name;
    private String code;
    private Lecturer lecturer;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void assignLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
        lecturer.assignCourse(this.code);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") - Lecturer: " + (lecturer != null ? lecturer.getName() : "Unassigned");
    }

    public String getCourseCode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseCode'");
    }

    public String getCourseName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourseName'");
    }
}
