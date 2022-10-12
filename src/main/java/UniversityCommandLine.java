import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityCommandLine {
    static InterfaceCoursesDB coursesDB = new CoursesDB();

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Meluska1234");
        printCommands();
        readCommands(connection);
    }

    public static void printCommands() {
        System.out.println("Welcome to the University!");
        System.out.println(" ---------------------- ");
        System.out.println("1. Add Student");
        System.out.println("2. Vew All students");
        System.out.println("3. Vew Single Student info");
        System.out.println("4. Enroll student in to the course");
        // System.out.println("5. View student Exams");
        // System.out.println("6. Delete student");
        System.out.println("7. Add Course");
        System.out.println("8. View All Courses");
        System.out.println("9. View Single Course info");
        System.out.println("10. Find Exam by Course name");
        System.out.println("11. Create Exam ");
        System.out.println("12. View Exam List");
        System.out.println("13. View Exam Result");
        System.out.println(" ---------------------- ");
        System.out.println("Choose the number for activity You would like to perform: ");
    }

    public static void readCommands(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i == 1) {
            addStudent(connection);
        } else if (i == 2) {
            University.viewStudents(connection);
        } else if (i == 3) {
            viewStudentInfo(connection);
        } else if (i == 4) {
            setCourseToStudent(connection);
        } else if (i == 7) {
            addCourse();
        } else if (i == 8) {
            viewAllCourses();
        } else if (i == 9) {
            viewSingleCourseInfo();
        } else if (i == 10) {
            findExamByCourse(connection);
        } else if (i == 11) {
            createExamList(connection);
        } else if (i == 12) {
            ExamDB examDB = new ExamDB();
            examDB.viewExamList(connection);
        } else if (i == 13) {
            viewExamResult(connection);
        }

    }

    public static void addStudent(Connection connection) {
        Students newStudents = new Students();
        University.addStudent(connection, newStudents);

    }

    public static void viewStudentInfo(Connection connection) {
        System.out.println("Enter student ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        University.viewStudentInfo(connection, id);
    }

    public static void setCourseToStudent(Connection connection) {
        System.out.println("Enter Student ID:");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Enter course ID");
        int courseID = scanner.nextInt();
        University.setCourseToStudent(connection, id, courseID);
        System.out.println("The student was successfully enrolled in a new course!");
    }

    private static void viewAllCourses() {
        ArrayList<Course> courses;
        try {
            courses = coursesDB.getCourses();
            for (Course c : courses) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addCourse() {
        System.out.println("Enter course title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("Enter duration (hours): ");
        int duration = scanner.nextInt();
        try {
            coursesDB.addCourse(title, duration);
            System.out.println("New course has been added successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void viewSingleCourseInfo() {
        System.out.println("Enter course title:");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        Course course;
        try {
            course = coursesDB.getCourseByTitle(title);
            System.out.println(course);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void findExamByCourse(Connection connection) {
        System.out.println("Enter course title:");
        Scanner scanner1 = new Scanner(System.in);
        String title = scanner1.nextLine();
        findExamByCourse(connection, title);
    }

    public static void findExamByCourse(Connection connection, String title) {
        String getSingleExamResults =
                "select ExamDate, ExamName from exams inner join courses on exams.ExamName = courses.title where courses.Title ="
                        + "'" + title + "'";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSingleExamResults);

            while (resultSet.next()) {
                System.out.print("Exam's date: " + resultSet.getString(1));
                System.out.print(" Name: " + resultSet.getString(2));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createExamList(Connection connection) {
        System.out.println("Enter Exam ID:");
        Scanner scanner = new Scanner(System.in);
        int examId = scanner.nextInt();
        System.out.println("Enter Exam Date:");
        int examDate = scanner.nextInt();
        System.out.println("Enter Exam Name:");
        String examName = scanner.next();
        ExamDB examDB = new ExamDB();
        examDB.createExam(connection, examId, examDate, examName);
    }

    public static void viewExamResult(Connection connection) {
        System.out.println("Enter Exam ID:");
        Scanner scanner = new Scanner(System.in);
        int inputID = scanner.nextInt();
        ExamDB examDB = new ExamDB();
        examDB.viewExamResult(connection,inputID );

    }
}
