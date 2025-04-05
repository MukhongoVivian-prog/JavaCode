package model;

import java.util.HashMap;
import java.util.Map;


public class Student extends Person {
    // Key: Course name or code, Value: Score (Integer, null if not assigned)
    private Map<String, Integer> enrolledCourses;

    public Student(String name, String id, String email) {
        super(name, id, email);
        this.enrolledCourses = new HashMap<>();
    }

    public void enrollCourse(String courseCode) {
        enrolledCourses.put(courseCode, null);  // score not yet assigned
    }

    public void assignScore(String courseCode, int score) {
        if (enrolledCourses.containsKey(courseCode)) {
            enrolledCourses.put(courseCode, score);
        } else {
            System.out.println("Course not enrolled: " + courseCode);
        }
    }

    public Map<String, Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public String toString() {
        return super.toString() + ", Enrolled Courses: " + enrolledCourses;
    }

    public String getStudentId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }
}
