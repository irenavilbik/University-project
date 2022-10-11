

import java.sql.*;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Meluska1234");

           viewExamList(connection);
           // createExam(connection, 107, 20221010);
            //viewExamResult(connection, 101);
            //findExamByCourse(connection, "Algorithms");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void viewExamList(Connection connection) {
        String getAllExamsQuery = "SELECT * FROM university.exams";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getAllExamsQuery);

            while (resultSet.next()) {
                System.out.print("Exam's id: " + resultSet.getString(1));
                System.out.print(" Date: " + resultSet.getString(2));
                System.out.print(" Exam title: " + resultSet.getString(3));
                System.out.println("");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createExam(Connection connection, int ExamID, int ExamDATE) {
        String createExamQuery = "INSERT INTO university.exams(ExamID, ExamDATE) VALUES (?, ?);";

        try {
            PreparedStatement pStat = connection.prepareStatement(createExamQuery);
            pStat.setString(1, String.valueOf(ExamID));
            pStat.setString(2, String.valueOf(ExamDATE));
            pStat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewExamResult(Connection connection, int inputID ) {
        String getSingleExamResults = "SELECT * FROM university.results where ExamID = " + inputID;

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getSingleExamResults);

            while (resultSet.next()) {
                System.out.print("Student's id: " + resultSet.getString(2));
                System.out.print(" Result: " + resultSet.getString(3) + " ");
                System.out.print(" ExamID: " + resultSet.getString(4));
                System.out.println("");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void findExamByCourse(Connection connection, String inputID ) {
        String getSingleExamResults =
                "select ExamDate, ExamName from exams inner join courses on exams.ExamName = courses.title where courses.Title="
                + "'"+inputID + "'";

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

}