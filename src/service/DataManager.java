package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataManager {
    private List<Student> students;
    private List<Lecturer> lecturers;
    private List<Course> courses;
    private List<Programme> programmes;

    public DataManager() {
        students = new ArrayList<>();
        lecturers = new ArrayList<>();
        courses = new ArrayList<>();
        programmes = new ArrayList<>();
    }

    // === STUDENT MANAGEMENT ===
    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    // === LECTURER MANAGEMENT ===
    public void addLecturer(Lecturer l) {
        lecturers.add(l);
    }

    public Lecturer findLecturerById(String id) {
        for (Lecturer l : lecturers) {
            if (l.getId().equals(id)) {
                return l;
            }
        }
        return null;
    }

    // === COURSE MANAGEMENT ===
    public void addCourse(Course c) {
        courses.add(c);
    }

    public Course findCourseByCode(String code) {
        for (Course c : courses) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    // === PROGRAMME MANAGEMENT ===
    public void addProgramme(Programme p) {
        programmes.add(p);
    }

    public Programme findProgrammeByName(String name) {
        for (Programme p : programmes) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // === Getters (for testing or display) ===
    public List<Student> getAllStudents() {
        return students;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    public void saveAllData() {
        FileManager.saveToFile(students, "data/students.dat");
        FileManager.saveToFile(lecturers, "data/lecturers.dat");
        FileManager.saveToFile(courses, "data/courses.dat");
        FileManager.saveToFile(programmes, "data/programmes.dat");
    }
    
    public void loadAllData() {
        System.out.println("Loading data...");
    
        students = FileManager.loadFromFile("data/students.dat");
        lecturers = FileManager.loadFromFile("data/lecturers.dat");
        courses = FileManager.loadFromFile("data/courses.dat");
        programmes = FileManager.loadFromFile("data/programmes.dat");
    
        System.out.println("Data loaded. Students count: " + students.size());
        System.out.println("Lecturers count: " + lecturers.size());
        System.out.println("Courses count: " + courses.size());
        System.out.println("Programmes count: " + programmes.size());
    
        // Fallback if files were not found
        if (students == null) students = new ArrayList<>();
        if (lecturers == null) lecturers = new ArrayList<>();
        if (courses == null) courses = new ArrayList<>();
        if (programmes == null) programmes = new ArrayList<>();
    }
    public void displayStudentResults(String studentId) {
    Student student = findStudentById(studentId);
    if (student == null) {
        System.out.println("Student not found!");
    } else {
        System.out.println("Student: " + student.getName());
        System.out.println("Courses enrolled: ");
        for (Map.Entry<String, Integer> entry : student.getEnrolledCourses().entrySet()) {
            System.out.println("Course: " + entry.getKey() + " | Score: " + entry.getValue());
        }
    }
}
public void updateStudentResult(String studentId, String courseCode, int newScore) {
    Student student = findStudentById(studentId);
    if (student == null) {
        System.out.println("Student not found!");
    } else {
        if (student.getEnrolledCourses().containsKey(courseCode)) {
            student.assignScore(courseCode, newScore);
            System.out.println("Updated " + student.getName() + "'s score for " + courseCode + " to " + newScore);
        } else {
            System.out.println("Course not found for student!");
        }
    }
}
public void listAllStudents() {
    if (students.isEmpty()) {
        System.out.println("No students found.");
    } else {
        System.out.println("=== List of All Students ===");
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentId() + " | Name: " + student.getName());
        }
    }
}

public void listAllCourses() {
    if (courses.isEmpty()) {
        System.out.println("No courses available.");
    } else {
        System.out.println("=== List of All Courses ===");
        for (Course course : courses) {
            String lecturerName = course.getLecturer() != null ? course.getLecturer().getName() : "No Lecturer";
            System.out.println("Course Code: " + course.getCourseCode() + " | Name: " + course.getCourseName() + " | Lecturer: " + lecturerName);
        }
    }

}
public void listStudentsInCourse(String courseCode) {
    boolean found = false;
    for (Student student : students) {
        if (student.getEnrolledCourses().containsKey(courseCode)) {
            System.out.println("Student ID: " + student.getStudentId() + " | Name: " + student.getName());
            found = true;
        }
    }
    if (!found) {
        System.out.println("No students enrolled in this course.");
    }
}
public void listCoursesInProgramme(String programmeName) {
    boolean found = false;
    for (Programme programme : programmes) {
        if (programme.getName().equalsIgnoreCase(programmeName)) {
            System.out.println("Courses under " + programmeName + " Programme:");
            for (Course course : programme.getCourses()) {
                System.out.println(course.getCourseCode() + ": " + course.getCourseName());
                found = true;
            }
        }
    }
    if (!found) {
        System.out.println("No courses found in this programme.");
    }
}
public void deleteStudent(String studentId) {
    students.removeIf(student -> student.getStudentId().equals(studentId));
    System.out.println("Student with ID " + studentId + " has been deleted.");
}

public void enrollStudentInCourse(String studentId, String courseToEnroll) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'enrollStudentInCourse'");
}

public void assignLecturerToCourse(String courseCode, String lecturerId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'assignLecturerToCourse'");
}

public void attachCourseToProgramme(String progCode, String courseCode) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'attachCourseToProgramme'");
}

public void listAllProgrammes() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listAllProgrammes'");
}

public void listAllLecturers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'listAllLecturers'");
}


}
