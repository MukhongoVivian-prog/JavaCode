package model;

import java.util.ArrayList;
import java.util.List;

public class Lecturer extends Person {
    private List<String> assignedCourses;

    public Lecturer(String name, String id, String email) {
        super(name, id, email);
        this.assignedCourses = new ArrayList<>();
    }

    public void assignCourse(String courseCode) {
        if (!assignedCourses.contains(courseCode)) {
            assignedCourses.add(courseCode);
        }
    }

    public List<String> getAssignedCourses() {
        return assignedCourses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Teaching: " + assignedCourses;
    }
}
