import java.util.Scanner;

import service.DataManager;


public class Main {
    public static void main(String[] args) {
        DataManager dm = new DataManager();
        dm.loadAllData();  // Load data if exists

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Display menu
            System.out.println("\n=== Student System Menu ===");
            System.out.println("1. View Student Results");
            System.out.println("2. Update Student Results");
            System.out.println("3. List All Students");
            System.out.println("4. List All Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // View Student Results
                    System.out.print("Enter Student ID to view results: ");
                    String studentId = scanner.nextLine();
                    dm.displayStudentResults(studentId);
                    break;

                case 2:
                    // Update Student Results
                    System.out.print("Enter Student ID to update results: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter Course Code to update score: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    int newScore = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character
                    dm.updateStudentResult(studentId, courseCode, newScore);
                    break;

                case 3:
                    // List All Students
                    dm.listAllStudents();
                    break;

                case 4:
                    // List All Courses
                    dm.listAllCourses();
                    break;

                case 5:
                    // Exit
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Save data after each action
            dm.saveAllData();
        }

        scanner.close();
    }
}
