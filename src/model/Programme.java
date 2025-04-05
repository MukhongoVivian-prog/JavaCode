package model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable ;

public class Programme implements Serializable{
    private String name;
    private List<String> courseCodes;

    public Programme(String name) {
        this.name = name;
        this.courseCodes = new ArrayList<>();
    }

    public void addCourse(String courseCode) {
        if (!courseCodes.contains(courseCode)) {
            courseCodes.add(courseCode);
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getCourseCodes() {
        return courseCodes;
    }

    @Override
    public String toString() {
        return "Programme: " + name + " | Courses: " + courseCodes;
    }

    public Course[] getCourses() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCourses'");
    }
}
