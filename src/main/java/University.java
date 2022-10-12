
import java.sql.*;
import java.util.Scanner;

public class University {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/university", "root", "Meluska1234");
            Students newStudents = new Students();
            newStudents.addStudent();
            addStudent(connection, newStudents);
            // setCourseToStudent(connection, 2, 2);

            //viewAllStudents(connection);
            //viewStudentInfo(connection, 5);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void viewStudents(Connection connection) {

        String geAllStudentsQuery = "SELECT * FROM University.Students";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(geAllStudentsQuery);

            while (resultSet.next()) {
                System.out.print("Student's id: " + resultSet.getString(1));
                System.out.print(" Name and surname: " + resultSet.getString(2) + resultSet.getString(3));
                System.out.println(" Date of birth: " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addStudent(Connection connection, Students students) {
        Scanner k = new Scanner(System.in);

        System.out.println("Please enter student's name: ");
        String studentName = k.next();

        System.out.println("Please enter student's surname: ");
        String studentSurname = k.next();

        System.out.println("enter student's date of birth by pattern yyyymmdd: ");
        //noinspection RedundantExplicitVariableType
        int dateOfBirth = k.nextInt();

        k.close();


        String addStudentQuery = "INSERT INTO University.Students(name, surname, date_of_birth) VALUES (?,?,?);";

        try (connection) {

            PreparedStatement pStatement = connection.prepareStatement(addStudentQuery);
            pStatement.setString(1, students.setName(studentName));
            pStatement.setString(2, students.setSurname(studentSurname));
            pStatement.setInt(3, students.setDateOfBirth(dateOfBirth));


            pStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void viewStudentInfo(Connection connection, int id) {

        String getUserQuery = "SELECT * FROM University.Students WHERE id = " + id;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getUserQuery);

            while (resultSet.next()) {
                System.out.println("Student's id: " + resultSet.getString(1));
                System.out.println("Name and surname: " + resultSet.getString(2));
                System.out.println("Email: " + resultSet.getString(3));
                System.out.println("Date of birth: " + resultSet.getString(4));
                System.out.println("Course id: " + resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setCourseToStudent(Connection connection, int id, int courseID) {
        String updateStudentQuery = "UPDATE University.Students SET courseID = ? WHERE id = ?";

        try {
            PreparedStatement pStatement = connection.prepareStatement(updateStudentQuery);

            pStatement.setInt(1, courseID);
            pStatement.setInt(2, id);

            pStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}