package ph.com.bpi.M5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Act3_DBConnection {

	private static final String URL = "jdbc:postgresql://localhost:5432/training_db";
    private static final String USER = "rsporantoy";
    private static final String PASSWORD = "postgres";
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean runsMenu = true;
 
        while (runsMenu) {
            Menu();
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();
 
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    if (name == null || name.trim().isEmpty()) {
                        System.out.println("Name must not be empty.");
                        break;
                    }
 
                    System.out.print("Enter age: ");
                    String ageInput = sc.nextLine();
                    if (ageInput == null || ageInput.trim().isEmpty()) {
                        System.out.println("Age must not be empty.");
                        break;
                    }
 
                    int age;
                    try {
                        age = Integer.parseInt(ageInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Age must be a number.");
                        break;
                    }
 
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    if (email == null || email.trim().isEmpty()) {
                        System.out.println("Email must not be empty.");
                        break;
                    }
 
                    addStudent(name, age, email);
                    break;
 
                case 2:
                    System.out.print("Enter student ID: ");
                    String idInput = sc.nextLine();
                    if (idInput == null || idInput.trim().isEmpty()) {
                        System.out.println("ID must not be empty.");
                        break;
                    }
 
                    int studentId;
                    try {
                        studentId = Integer.parseInt(idInput);
                    } catch (NumberFormatException e) {
                        System.out.println("ID must be a number.");
                        break;
                    }
 
                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();
                    if (courseName == null || courseName.trim().isEmpty()) {
                        System.out.println("Course Name must not be empty.");
                        break;
                    }
 
                    System.out.print("Enter grade: ");
                    String gradeInput = sc.nextLine();
                    if (gradeInput == null || gradeInput.trim().isEmpty()) {
                        System.out.println("Grade must not be empty.");
                        break;
                    }
 
                    float grade;
                    try {
                        grade = Float.parseFloat(gradeInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Grade must be a number.");
                        break;
                    }
 
                    addCourses(studentId, courseName, grade);
                    break;
 
                case 3:
                    showStudent();
                    break;
 
                case 4:
                    showCourses();
                    break;
 
                case 0: // Exit
                    runsMenu = false;
                    System.out.println("Exiting the program. Thank you!");
                    break;
 
                default:
                    System.out.println("Invalid input! Try again!");
            }
        }
 
        sc.close();
    }
 
    static void Menu() {
        System.out.println("\n===== STUDENT COURSE MANAGEMENT =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Show Students");
        System.out.println("4. Show Courses");
        System.out.println("0. Exit");
    }
 
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
 
    public static void addStudent(String name, int age, String email) {
        String sql = "INSERT INTO students(name, age, email) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.executeUpdate();
 
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void addCourses(int studentId, String courseName, float grade) {
        String sql = "INSERT INTO courses(student_id, course_name, grade) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            ps.setFloat(3, grade);
            ps.executeUpdate();
 
            System.out.println("Course added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void showStudent() {
        String sql = "SELECT * FROM STUDENTS";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            if (!rs.isBeforeFirst()) {
                System.out.println("No students found.");
                return;
            }
 
            System.out.println("ID | Name | Age | Email");
            System.out.println("-------------------------");
 
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("email")
                );
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public static void showCourses() {
        String sql = "SELECT c.student_id, c.course_name, c.grade, s.name " +
                     "FROM courses c JOIN students s ON c.student_id = s.id";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
 
            if (!rs.isBeforeFirst()) {
                System.out.println("No courses found.");
                return;
            }
 
            System.out.println("Student ID | Course | Grade | Student Name");
            System.out.println("-----------------------------------------");
 
            while (rs.next()) {
                System.out.println(
                        rs.getInt("student_id") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getFloat("grade") + " | " +
                        rs.getString("name")
                );
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
