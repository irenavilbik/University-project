import java.sql.Connection;
import java.sql.SQLException;


public interface ExamInterface  {
    static void viewExamList(Connection connection) throws SQLException, ClassNotFoundException {

    }

    void viewExamList() throws SQLException, ClassNotFoundException;

    static void createExam(Connection connection, int ExamID, int ExamDATE, String ExamName) throws SQLException, ClassNotFoundException {

    }

    static void viewExamResult(Connection connection, int inputID) throws SQLException, ClassNotFoundException {

    }

    static void findExamByCourse(Connection connection, String inputID) throws SQLException, ClassNotFoundException {

    }
}
