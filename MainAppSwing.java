import javax.swing.*;

import service.DataManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAppSwing {

    private DataManager dm;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainAppSwing().createAndShowGUI();
        });
    }

    public MainAppSwing() {
        dm = new DataManager();
        dm.loadAllData();  // Load data if it exists
    }

    public void createAndShowGUI() {
        // Create JFrame
        JFrame frame = new JFrame("Student System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create components
        JTextField studentIdField = new JTextField(20);
        studentIdField.setToolTipText("Enter Student ID");

        JTextField courseCodeField = new JTextField(20);
        courseCodeField.setToolTipText("Enter Course Code");

        JTextField scoreField = new JTextField(20);
        scoreField.setToolTipText("Enter New Score");

        JButton viewResultsButton = new JButton("View Student Results");
        JButton updateResultsButton = new JButton("Update Student Results");
        JButton listStudentsButton = new JButton("List All Students");
        JButton listCoursesButton = new JButton("List All Courses");
        JButton exitButton = new JButton("Exit");
         

        // Create panel for layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components to the panel
        panel.add(new JLabel("Student ID:"));
        panel.add(studentIdField);
        panel.add(new JLabel("Course Code:"));
        panel.add(courseCodeField);
        panel.add(new JLabel("Score:"));
        panel.add(scoreField);
        panel.add(scoreField);
        panel.add(updateResultsButton);
        panel.add(listStudentsButton);
        panel.add(listCoursesButton);
        panel.add(exitButton);

        // Add action listeners to buttons
        scoreField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                dm.displayStudentResults(studentId);
            }
        });

        updateResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText();
                String courseCode = courseCodeField.getText();
                try {
                    int newScore = Integer.parseInt(scoreField.getText());
                    dm.updateStudentResult(studentId, courseCode, newScore);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid score.");
                }
            }
        });

        listStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.listAllStudents();
            }
        });

        listCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dm.listAllCourses();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting...");
                frame.dispose();  // Close the application
            }
        });

        // Add panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
